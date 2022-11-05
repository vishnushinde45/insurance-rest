package com.monocept.insuranceapp.service;

import java.util.List;

import com.monocept.insuranceapp.entity.InstallmentPayments;
import com.monocept.insuranceapp.entity.Installments;

public interface InstallmentsService {

	Installments getInstallment(int installmentId);

	void payInstallment(int customerId, int installmentId, String paymentType);

	List<InstallmentPayments> getInstallmentPayments();

}
