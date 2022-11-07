package com.monocept.insuranceapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.monocept.insuranceapp.documents.FileUploadProperties;


@SpringBootApplication
@EnableConfigurationProperties({
    FileUploadProperties.class
})
public class InsuranceAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(InsuranceAppApplication.class, args);
	}

	
}
