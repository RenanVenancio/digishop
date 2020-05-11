package com.techzone.digishop.resource;
import java.util.List;
import java.util.stream.Collectors;

import com.techzone.digishop.domain.Payment;
import com.techzone.digishop.domain.enums.PaymentStatus;
import com.techzone.digishop.dto.PaymentDTO;
import com.techzone.digishop.service.PaymentService;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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

    @RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<PaymentDTO>> findPage(
            @RequestParam(value = "status", defaultValue = "") Integer status,
            @RequestParam(value = "paymentType", defaultValue = "") Integer paymentType,
			@RequestParam(value = "start", defaultValue = "all") String start, 
			@RequestParam(value = "end", defaultValue = "all") String end, 
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "itensPerPage" ,defaultValue = "24") Integer itensPerPage, 
			@RequestParam(value = "orderBy" ,defaultValue = "id") String orderBy, 
			@RequestParam(value = "direction" ,defaultValue = "ASC") String direction){

		Page<Payment> paymentList = service.search(start, end, status, paymentType, page, itensPerPage, orderBy, direction);
		Page<PaymentDTO> listDto = paymentList.map((obj) -> new PaymentDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

	@RequestMapping(value="settle/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Payment> settlePayment(@PathVariable Integer id, @RequestBody Payment payment){
		payment.setId(id);
		return ResponseEntity.ok().body(service.settlePayment(payment));

	}

	@RequestMapping(value="sale/{id}", method=RequestMethod.GET)
	public ResponseEntity<List<Payment>> findBySaleId(@PathVariable Integer id){
		return ResponseEntity.ok().body(service.findBySaleId(id));

	}
	


}