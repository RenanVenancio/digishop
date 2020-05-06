package com.techzone.digishop.domain.enums;

public enum SaleStatus {
	PENDENT(0),
	DELIVERED(1),
	CANCELLED(2);
	
	private int cod;
	
	private SaleStatus(int cod) {
		this.cod = cod;
	}
	
	public int getCod() {
		return cod;
	}


	public static SaleStatus toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(SaleStatus c : SaleStatus.values()) {
			if(cod.equals(c.getCod())){
				return c;
			}
		}
		
		throw new IllegalArgumentException("Invalid Id");
	}

	
	
	
	
}
