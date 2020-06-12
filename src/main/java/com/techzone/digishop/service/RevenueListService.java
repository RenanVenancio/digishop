package com.techzone.digishop.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.techzone.digishop.domain.Revenue;
import com.techzone.digishop.domain.RevenueList;
import com.techzone.digishop.domain.Sale;
import com.techzone.digishop.domain.enums.PaymentMethod;
import com.techzone.digishop.domain.enums.PaymentStatus;
import com.techzone.digishop.dto.RevenueListNewDTO;
import com.techzone.digishop.repository.RevenueListRepository;
import com.techzone.digishop.service.exception.BusinessRuleException;
import com.techzone.digishop.service.exception.ObjectNotFoundException;
import com.techzone.digishop.service.validation.utils.FormatDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class RevenueListService {

    @Autowired
    RevenueListRepository paymentRepository;

    @Autowired
    SaleService saleService;

    @Autowired
    RevenueService revenueService;

    public RevenueList findById(Integer id) {
        Optional<RevenueList> payment = paymentRepository.findById(id);
        return payment.orElseThrow(() -> new ObjectNotFoundException(Sale.class.getName() + " not found"));
    }

    public List<RevenueList> generateNewRevenue(Integer parcelNumber, String paydayInterval, Date firstPayment, BigDecimal value, String barCode, String documentNumber,
    String observation, PaymentStatus status, Sale sale, Revenue revenue) {

        Calendar c = Calendar.getInstance();
        c.setTime(firstPayment);

        List<RevenueList> generatedPayments = new ArrayList<>();

        for (int i = 0; i < parcelNumber; i++){
            generatedPayments.add(
                generateRevenueList(
                    c.getTime(), 
                    value.divide(new BigDecimal(Integer.toString(parcelNumber))).setScale(2, RoundingMode.HALF_EVEN), 
                    barCode, 
                    documentNumber + "/" + i, 
                    observation, 
                    status, 
                    sale, 
                    revenue
                )
            );

            if(paydayInterval.equalsIgnoreCase("M")){
                c.add(Calendar.MONTH, 1);
            }else{
                c.add(Calendar.DATE, Integer.parseInt(paydayInterval));
            }
        }
        
        return generatedPayments;
    }

    public RevenueList generateRevenueList(Date dueDate, BigDecimal value, String barCode, String documentNumber,
            String observation, PaymentStatus status, Sale sale, Revenue revenue) {
                return new RevenueList(
                    null, 
                    dueDate, 
                    value, 
                    status.equals(PaymentStatus.PAID) ? value : new BigDecimal("0.00"),
                    status.equals(PaymentStatus.PAID) ? new Date() : null, 
                    barCode, 
                    documentNumber, 
                    observation, 
                    status, 
                    sale, 
                    revenue
                    );
    }

    public List<RevenueList> findRevenue(Integer clientId, PaymentStatus status) {
        return paymentRepository.findBySaleClientIdOrRevenueClientIdAndStatus(clientId, clientId, status.getCod());
    }

    public Page<RevenueList> search(String start, String end, Integer status, Integer page, Integer itensPerPage,
            String orderBy, String direction) {

        if (!(start.equals("all") && end.equals("all"))) {
            Date startDate = FormatDate.parse(start);
            Date endDate = FormatDate.parse(end);

            if (startDate.compareTo(endDate) > 0) {
                throw new BusinessRuleException("A data inicial deve ser menor que a final");
            }

            PageRequest pageRequest = PageRequest.of(page, itensPerPage, Direction.valueOf(direction), orderBy);
            return paymentRepository.findByDueDateBetweenAndStatus(startDate, endDate, status, pageRequest);
        }

        if (!(start.equals("all") || end.equals("all"))) {
            throw new BusinessRuleException("Informe um período de datas válido");
        }

        PageRequest pageRequest = PageRequest.of(page, itensPerPage, Direction.valueOf(direction), orderBy);
        return paymentRepository.findByStatus(status, pageRequest);
    }

    public RevenueList settlePayment(RevenueList payment) {
        RevenueList newPayment = payment;
        payment = findById(payment.getId());

        if (payment.getStatus() == PaymentStatus.PAID) {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            throw new BusinessRuleException("O pagamento já foi baixado em " + sdf.format(payment.getPaydDate()));
        }

        if (newPayment.getAmountPaid().compareTo(payment.getValue()) == 1) {
            throw new BusinessRuleException("O valor pago deve ser igual ou menor a " + payment.getValue());
        }

        if (newPayment.getAmountPaid().doubleValue() < payment.getValue().doubleValue()) {
            List<RevenueList> payments = paymentRepository.findBySaleId(payment.getSale().getId());
            Long paydayInterval = 0L;
            if (payments.size() > 1) {
                Date d1 = payments.get(payments.size() - 2).getDueDate();
                Date d2 = payments.get(payments.size() - 1).getDueDate();
                paydayInterval = Math.abs((d1.getTime() - d2.getTime()));
                Calendar c = Calendar.getInstance();
                c.setTime(d2);
                c.setTimeInMillis(c.getTimeInMillis() + paydayInterval);

                BigDecimal difference = (payment.getValue().subtract(newPayment.getAmountPaid())).abs();

                RevenueList p = new RevenueList(null, c.getTime(), difference, new BigDecimal(0.00), null,
                        payment.getBarCode(), payment.getDocumentNumber() + " Diff", null, PaymentStatus.PENDENT,
                        payment.getSale());

                payment.setStatus(PaymentStatus.PAID);
                payment.setPaydDate(new Date());
                payment.setAmountPaid(newPayment.getAmountPaid());

                paymentRepository.save(payment);
                paymentRepository.save(p);

                return payment;
            }
        }

        payment.setStatus(PaymentStatus.PAID);
        payment.setPaydDate(new Date());
        payment.setAmountPaid(payment.getValue());
        paymentRepository.save(payment);

        return payment;
    }

    public List<RevenueList> findBySaleId(Integer saleId) {
        return paymentRepository.findBySaleId(saleId);
    }

    public RevenueList fromDTO(RevenueListNewDTO revenueDTO) {

        Sale sale = new Sale();
        Revenue revenue = new Revenue();
        if (!(revenueDTO.getSale() == null)) {
            sale = saleService.findById(revenueDTO.getSale());
        }

        if (!(revenueDTO.getRevenue() == null)) {
            revenue = revenueService.findById(revenueDTO.getRevenue());
        }

        return new RevenueList(revenueDTO.getId(), revenueDTO.getDueDate(), revenueDTO.getValue(),
                revenueDTO.getAmountPaid(), revenueDTO.getPaydDate(), revenueDTO.getBarCode(),
                revenueDTO.getDocumentNumber(), revenueDTO.getObservation(), revenueDTO.getStatus(), sale, revenue);
    }

}