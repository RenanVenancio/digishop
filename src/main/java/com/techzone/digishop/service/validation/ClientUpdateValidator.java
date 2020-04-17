package com.techzone.digishop.service.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.techzone.digishop.domain.Client;
import com.techzone.digishop.dto.ClientDTO;
import com.techzone.digishop.repository.ClientRepository;
import com.techzone.digishop.resource.exception.FieldMessage;

public class ClientUpdateValidator implements ConstraintValidator<ClientUpdate, ClientDTO> {

	@Autowired
	HttpServletRequest request;

	@Autowired
	ClientRepository clientRepository;

	@Override
	public void initialize(ClientUpdate ann) {

	}

	@Override
	public boolean isValid(ClientDTO objectDTO, ConstraintValidatorContext context) {
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));

		List<FieldMessage> list = new ArrayList<>();

		Client aux = clientRepository.findByEmail(objectDTO.getEmail());

		if (aux != null && !aux.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "Email já cadastrado"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMsg()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
