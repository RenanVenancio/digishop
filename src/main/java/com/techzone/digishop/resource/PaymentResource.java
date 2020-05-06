package com.techzone.digishop.resource;

import java.util.List;
import java.util.stream.Collectors;

import com.techzone.digishop.domain.Payment;
import com.techzone.digishop.domain.enums.PaymentStatus;
import com.techzone.digishop.dto.PaymentDTO;
import com.techzone.digishop.repository.PaymentRepository;
import com.techzone.digishop.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {
    
    @Autowired
    PaymentService service;
    
	@RequestMapping(value = "revenues/client/{id}",  method = RequestMethod.GET)
    public ResponseEntity<List<PaymentDTO>> findRevenue(@PathVariable Integer id, @RequestParam(value = "status", defaultValue = "0") Integer status){
        List<Payment> payments = service.findRevenue(id, PaymentStatus.toEnum(status));
        List<PaymentDTO> paymentDTOs = payments.stream().map((x) -> new PaymentDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(paymentDTOs);
    }

}