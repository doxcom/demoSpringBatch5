package com;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//https://medium.com/@devalerek/spring-batch-retrieve-data-from-the-csv-file-and-save-it-to-database-h2-75a689b7370
@SpringBootApplication
public class DemoSpringBatch5Application {

	public static void main(String[] args) {

		SpringApplication.run(DemoSpringBatch5Application.class, args);
	}

}
