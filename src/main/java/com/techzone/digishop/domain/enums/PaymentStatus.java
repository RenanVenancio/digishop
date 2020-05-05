package com.techzone.digishop.domain.enums;

public enum PaymentStatus {

    PENDENT(0), PAID(1), CANCELLED(3);

	private int cod;

	private PaymentStatus(int cod) {
		this.cod = cod;
	}

	public int getCod() {
		return this.cod;
	}

	public static PaymentStatus toEnum(Integer cod) {
		if (cod == null) {
			return null;
		}

		for (PaymentStatus t : PaymentStatus.values()) {
			if (cod.equals(t.getCod())) {
				return t;
			}
		}

		throw new IllegalArgumentException("This enum cod is not valid");
	}

}