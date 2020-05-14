package com.techzone.digishop.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.techzone.digishop.domain.Payment;
import com.techzone.digishop.domain.Sale;
import com.techzone.digishop.domain.enums.PaymentMethod;
import com.techzone.digishop.domain.enums.PaymentStatus;
import com.techzone.digishop.domain.enums.PaymentType;
import com.techzone.digishop.dto.PaymentDTO;
import com.techzone.digishop.repository.PaymentRepository;
import com.techzone.digishop.service.exception.BusinessRuleException;
import com.techzone.digishop.service.exception.ObjectNotFoundException;
import com.techzone.digishop.service.validation.utils.FormatDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Autowired
    SaleService saleService;

    public Payment findById(Integer id){
        Optional<Payment> payment = paymentRepository.findById(id);
        return payment.orElseThrow(() -> new ObjectNotFoundException(Sale.class.getName() + " not found"));
    }

    public List<Payment> generateRevenueOfSale(Sale sale){

        List<Payment> payments = new ArrayList<>();

        Boolean paid = false;
        Integer status = PaymentStatus.PENDENT.getCod();

        if(sale.getPaymentMethod() == PaymentMethod.CREDIT_CARD){
            sale.setParcelNumber(1);
            paid = true;
            status = PaymentStatus.PAID.getCod();
        }

        if(sale.getFirstPayment() == null) {
            sale.setFirstPayment(new Date());
        }

        if(sale.getPaydayInterval() == null){
            sale.setPaydayInterval("15");

        }

        Calendar c = Calendar.getInstance();
        c.setTime(sale.getFirstPayment());
        BigDecimal parcelValue = sale.getTotalValue().divide(new BigDecimal(String.valueOf(sale.getParcelNumber())).setScale(2, RoundingMode.HALF_EVEN));

        for (int i = 0; i < sale.getParcelNumber(); i++){
            payments.add(new Payment(
                null, c.getTime(), 
                parcelValue, 
                paid == true ? parcelValue : new BigDecimal("0.00"), 
                paid == true ? c.getTime() : null, 
                null, 
                sale.getId() + "/" + (i+1), 
                PaymentType.REVENUE,
                null, 
                PaymentStatus.toEnum(status),
                sale, 
                null
            )
        );
            if(sale.getPaydayInterval().equalsIgnoreCase("M")){
                c.add(Calendar.MONTH, 1);
            }else{
                c.add(Calendar.DATE, Integer.parseInt(sale.getPaydayInterval()));
            }
        }

        return payments;
    }

    public List<Payment> findRevenue(Integer clientId, PaymentStatus status){
        return paymentRepository.findBySaleClientAndStatus(clientId, status.getCod(), PaymentType.REVENUE.getCod());
    }

    public Page<Payment> search(String start, String end, Integer status, Integer paymentType, Integer page, Integer itensPerPage, String orderBy, String direction) {
		
		if(!(start.equals("all") && end.equals("all"))){
			Date startDate = FormatDate.parse(start);
			Date endDate = FormatDate.parse(end);

			if(startDate.compareTo(endDate) > 0){
				throw new BusinessRuleException("A data inicial deve ser menor que a final");
			}

			PageRequest pageRequest = PageRequest.of(page, itensPerPage, Direction.valueOf(direction), orderBy);
			return paymentRepository.findByDueDateBetweenAndStatusAndPaymentType(startDate, endDate, status, paymentType, pageRequest);
		}

		if(!(start.equals("all") || end.equals("all"))){
			throw new BusinessRuleException("Informe um período de datas válido");
		}		

		PageRequest pageRequest = PageRequest.of(page, itensPerPage, Direction.valueOf(direction), orderBy);
		return paymentRepository.findByStatusAndPaymentType(status, paymentType, pageRequest);
    }
    
    public Payment settlePayment(Payment payment){
        Payment newPayment = payment;
        payment = findById(payment.getId());

        if(payment.getStatus() == PaymentStatus.PAID){
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            throw new BusinessRuleException("O pagamento já foi baixado em " + sdf.format(payment.getPaydDate()));
        }

        if(newPayment.getAmountPaid().compareTo(payment.getValue()) == 1){
            throw new BusinessRuleException("O valor pago deve ser igual ou menor a " + payment.getValue());
        }

        if(newPayment.getAmountPaid().doubleValue() < payment.getValue().doubleValue()){
            List<Payment> payments = paymentRepository.findBySaleId(payment.getSale().getId());
            Long paydayInterval = 0L;
            if(payments.size() > 1){
                Date d1 = payments.get(payments.size() - 2).getDueDate();
                Date d2 = payments.get(payments.size() - 1).getDueDate();
                paydayInterval = Math.abs((d1.getTime()- d2.getTime()));
                Calendar c = Calendar.getInstance();
                c.setTime(d2);
                c.setTimeInMillis(c.getTimeInMillis() + paydayInterval);

                BigDecimal difference = (payment.getValue().subtract(newPayment.getAmountPaid())).abs();

                Payment p = new Payment(
                    null, 
                    c.getTime(), 
                    difference, 
                    new BigDecimal(0.00), 
                    null, 
                    payment.getBarCode(),
                    payment.getDocumentNumber() + " Diff", 
                    PaymentType.REVENUE,
                    null, 
                    PaymentStatus.PENDENT, 
                    payment.getSale(), 
                    null
                );

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

    public List<Payment> findBySaleId(Integer saleId){
        return paymentRepository.findBySaleId(saleId);
    }

    public Payment fromDTO(PaymentDTO paymentDTO){
        return new Payment(
            paymentDTO.getId(),
            paymentDTO.getDueDate(),
            paymentDTO.getValue(),
            paymentDTO.getAmountPaid(),
            paymentDTO.getPaydDate(),
            paymentDTO.getBarCode(),
            paymentDTO.getDocumentNumber(),
            paymentDTO.getPaymentType(),
            paymentDTO.getObservation(),
            paymentDTO.getStatus(),
            paymentDTO.getSale(),
            paymentDTO.getPurchase()
        );
    }

}