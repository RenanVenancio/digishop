package com.techzone.digishop.domain.enums;

public enum PaymentType {

	REVENUE(0), PAYMENT(1);

	private int cod;

	private PaymentType(int cod) {
		this.cod = cod;
	}

	public int getCod() {
		return this.cod;
	}

	public static PaymentType toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (PaymentType t : PaymentType.values()) {
			if (cod.equals(t.getCod())) {
				return t;
			}
		}

		throw new IllegalArgumentException("This enum cod is not valid");
	}

}
