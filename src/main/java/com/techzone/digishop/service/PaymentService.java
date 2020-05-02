package com.techzone.digishop.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.techzone.digishop.domain.Payment;
import com.techzone.digishop.domain.Sale;
import com.techzone.digishop.domain.enums.PaymentMethod;
import com.techzone.digishop.domain.enums.PaymentType;
import com.techzone.digishop.repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
    @Autowired
    PaymentRepository paymentRepository;

    public List<Payment> generateRevenueOfSale(Sale sale){

        List<Payment> payments = new ArrayList<>();

        Boolean paid = false;
        if(sale.getPaymentMethod() == PaymentMethod.CREDIT_CARD){
            sale.setParcelNumber(1);
            paid = true;
        }

        if(sale.getFirstPayment() == null) {
            sale.setFirstPayment(new Date());
        }

        if(sale.getPaydayInterval() == null){
            sale.setPaydayInterval("15");

        }

        Calendar c = Calendar.getInstance();
        c.setTime(sale.getFirstPayment());
        Double parcelValue = sale.getTotalValue() / sale.getParcelNumber();

        for (int i = 0; i < sale.getParcelNumber(); i++){
            payments.add(new Payment(
                null, c.getTime(), 
                parcelValue, 
                paid == true ? parcelValue : 0.00, 
                paid == true ? c.getTime() : null, 
                null, 
                sale.getId() + "/" + (i+1), 
                PaymentType.REVENUE, 
                null, 
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
}