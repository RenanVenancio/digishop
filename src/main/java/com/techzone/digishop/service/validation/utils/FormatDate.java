package com.techzone.digishop.service.validation.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormatDate {
    
    public static Date parse(String value, String format){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(value);
		} catch (ParseException e) {			
			throw new RuntimeException("Data inválida");
		}
    }

    public static Date parse(String value){
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            return sdf.parse(value);
		} catch (ParseException e) {			
			throw new RuntimeException("Data inválida");
		}
    }

}