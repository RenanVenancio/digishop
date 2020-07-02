package com.techzone.digishop.service;

import com.techzone.digishop.domain.Sale;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    
    void sendSaleConfirmationEmail(Sale obj);
    void sendEmail(SimpleMailMessage msg);
}