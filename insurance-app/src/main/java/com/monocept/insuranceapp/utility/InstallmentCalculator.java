package com.monocept.insuranceapp.utility;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.monocept.insuranceapp.entity.Installments;

public class InstallmentCalculator {

	public final static int year=12;
	public static List<Installments> getInstallments(double investedAmount, int premiumType, Date enrolledDate, int policyTerm) {
		  
		List<Installments> installments=new ArrayList<Installments>();
		
		int installmentsCount=(policyTerm*year)/premiumType;
		double installmentAmount=investedAmount/installmentsCount;
		
		Date currDate=enrolledDate;
		Calendar cal=Calendar.getInstance();
		cal.setTime(currDate);
		
		Date modified;
		for(int i=1;i<=installmentsCount;i++) {
			
			
			installments.add(new Installments(installmentAmount, (java.util.Date) currDate, "PENDING", 0));
			cal.add(Calendar.MONTH, premiumType);
			currDate=cal.getTime();
			
		}
		return installments;
	}

}
