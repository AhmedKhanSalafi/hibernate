package com.Pessimistic.Pessimistic.locking;

import com.Pessimistic.Pessimistic.locking.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PessimisticLockingApplication {

	public static void main(String[] args) {
		SpringApplication.run(PessimisticLockingApplication.class, args);
	}







}
