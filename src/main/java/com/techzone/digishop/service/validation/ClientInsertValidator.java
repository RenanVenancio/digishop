package com.techzone.digishop.service.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.techzone.digishop.domain.ClientType;
import com.techzone.digishop.dto.ClientNewDTO;
import com.techzone.digishop.resource.exception.FieldMessage;
import com.techzone.digishop.service.validation.utils.BR;

public class ClientInsertValidator implements ConstraintValidator<ClientInsert, ClientNewDTO> {

	@Override
	public void initialize(ClientInsert ann) {

	}

	@Override
	public boolean isValid(ClientNewDTO objectDTO, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (objectDTO.getType().equals(ClientType.PESSOA_FISICA) && !BR.isValidCPF(objectDTO.getCpfCnpj())) {
			list.add(new FieldMessage("cpfCnpj", "CPF inválido"));
		}

		if (objectDTO.getType().equals(ClientType.PESSOA_JURIDICA)
				&& !BR.isValidCNPJ(objectDTO.getCpfCnpj())) {
			list.add(new FieldMessage("cpfCnpj", "CNPJ inválido"));
		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMsg()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
