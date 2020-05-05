package com.techzone.digishop.resource;

import java.util.List;

import com.techzone.digishop.domain.Payment;
import com.techzone.digishop.domain.enums.PaymentStatus;
import com.techzone.digishop.repository.PaymentRepository;
import com.techzone.digishop.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
    
    @Autowired
    PaymentService service;
    
	@RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Payment>> find(){
        return ResponseEntity.ok().body(service.find(2, PaymentStatus.PENDENT));
    }

}