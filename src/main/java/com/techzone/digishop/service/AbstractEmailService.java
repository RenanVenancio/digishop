package com.techzone.digishop.service;

import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.techzone.digishop.domain.Sale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

public abstract class AbstractEmailService implements EmailService{
    
    @Value("${default.sender}")
    private String sender;

    @Autowired
    private TemplateEngine templateEngine;

    @Autowired
    private JavaMailSender javaMailSender;

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

    protected String htmlFromTempleteSale(Sale obj){
        Context ctx = new Context();
        ctx.setVariable("sale", obj);
        return templateEngine.process("email/confirmation/saleConfirmation", ctx);
    }

    public void sendSaleConfirmationHtmlEmail(Sale obj) {
        try {
            MimeMessage mm = prepareMimeMessageFromSale(obj);
            sendEmailHtml(mm);
        } catch (MessagingException e) {
            sendSaleConfirmationEmail(obj);
        }
    }

    protected MimeMessage prepareMimeMessageFromSale(Sale obj) throws MessagingException{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mmh = new MimeMessageHelper(mimeMessage, true);
        mmh.setTo(obj.getClient().getEmail());
        mmh.setFrom(sender);
        mmh.setSubject("CONFIRMAÇÃO DE PEDIDO");
        mmh.setSentDate(new Date(System.currentTimeMillis()));
        mmh.setText(htmlFromTempleteSale(obj), true);

        return mimeMessage;
    }

}