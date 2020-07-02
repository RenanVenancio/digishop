package com.techzone.digishop.service;

import com.techzone.digishop.domain.Sale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;

public abstract class AbstractEmailService implements EmailService{
    
    @Value("${default.sender}")
    private String sender;

    @Override
    public void sendSaleConfirmationEmail(Sale obj){
        SimpleMailMessage sm = prepareSimpleEmailMessageFromSale(obj);
        sendEmail(sm);
    }

    protected SimpleMailMessage prepareSimpleEmailMessageFromSale(Sale obj){
        SimpleMailMessage sm = new SimpleMailMessage();
        sm.setTo(obj.getClient().getEmail());
        sm.setFrom(sender);
        sm.setSubject("Confirmação do Pedido " + obj.getCompany().getName());
        sm.setText(obj.toString());
        return sm;
    }

}