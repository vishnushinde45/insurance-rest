package com.monocept.insuranceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.monocept.insuranceapp.email.EmailSenderService;

@SpringBootApplication
public class InsuranceAppApplication {


	public static void main(String[] args) {
		SpringApplication.run(InsuranceAppApplication.class, args);
	}

	
}
