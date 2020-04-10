package com.techzone.digishop.domain;

public enum ClientType {
	PESSOA_FISICA(0, "Pessoa Física"),
	PESSOA_JURIDICA(1, "Pessoa Jurícica");
	
	private int cod;
	private String description;
	
	private ClientType(int cod, String description) {
		this.cod = cod;
		this.description = description;
	}
	
	public int getCod() {
		return cod;
	}

	public String getDescription() {
		return description;
	}
	
	public static ClientType toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(ClientType c : ClientType.values()) {
			if(cod.equals(c.getCod())){
				return c;
			}
		}
		
		throw new IllegalArgumentException("Invalid Id");
	}

	
	
	
	
}
