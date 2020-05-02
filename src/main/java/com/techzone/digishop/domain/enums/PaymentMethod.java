package com.techzone.digishop.domain.enums;

public enum PaymentMethod {
    
	PENDENT(0), CREDIT_CARD(1), BANK_SLIP(3);

	private Integer cod;

	private PaymentMethod(int cod) {
		this.cod = cod;
	}

	public Integer getCod() {
		if(this.cod == null){
			return null;
		}
		return this.cod;
	}

	public static PaymentMethod toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (PaymentMethod t : PaymentMethod.values()) {
			if (cod.equals(t.getCod())) {
				return t;
			}
		}

		throw new IllegalArgumentException("This enum cod is not valid");
	}
}