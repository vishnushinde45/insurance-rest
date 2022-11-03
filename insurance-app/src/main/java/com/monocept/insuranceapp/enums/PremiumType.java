package com.monocept.insuranceapp.enums;

public enum PremiumType {
     THREE(3),SIX(6),YEAR(12);
     
     private int value;
	
	PremiumType(int value) {
		this.value=value;
	}
	
	public int getValue() {
		return value;
	}
}
