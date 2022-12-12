package com.materialmanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class MaterialManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MaterialManagementApplication.class, args);
	}

}
