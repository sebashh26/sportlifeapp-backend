package com.sportlife.Enum;

import org.springframework.util.StringUtils;

public enum EnumYesNo {
	
	Y("YES", "yes"),
	N("NO", "no");
    private final String value;
    private final String label;
	
	EnumYesNo(String value, String label){
		this.value= value;
		this.label= label;
	}

	public String getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}
	
	/**
     * Retorna la etiqueta asociada al valor.
     * @param valor el valor de la enumeraci\u00F3n
     * @return la etiqueta asociada al valor.
     */
    public static String decodifitorValue(String value) {
        for (EnumYesNo e : EnumYesNo.values()) {
            if (e.value.equals(value)) {
                return e.label;
            }
        }
        return StringUtils.hasLength(value) ? "blanco" : "";
    }

}
