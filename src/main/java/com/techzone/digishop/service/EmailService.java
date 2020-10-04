package com.techzone.digishop.service;

import javax.mail.internet.MimeMessage;

import com.techzone.digishop.domain.Sale;

import org.springframework.mail.SimpleMailMessage;

public interface EmailService {
    
    void sendSaleConfirmationEmail(Sale obj);

    void sendEmail(SimpleMailMessage msg);

    void sendSaleConfirmationHtmlEmail(Sale obj);

    void sendEmailHtml(MimeMessage msg);
}