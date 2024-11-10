package com.anu3dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anu3dev.service.VaccineService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(Application.class, args);
		VaccineService service = container.getBean(VaccineService.class);
		
		service.fetchDetailsBySorting(true, "vaccineName","vaccineCompany")
			.forEach(v->System.out.println(v.getVaccineName()+" "+v.getVaccineCompany()));
		System.out.println("");
		
		service.fetchDetailsByPagination(0, 2, true,"vaccineName","vaccineCompany")
			.forEach(v->System.out.println(v.getVaccineName()+" "+v.getVaccineCompany()));
		System.out.println("");
	
		service.fetchDetailsByPagination(2);
	}
}

/*
 * 
 * Dependencies ->
 * Spring Data JPA
 * MySQL Driver
 * Lombok
 * 
 * pagingandsortingRepository extends crudRepository extends Repository
 * 
 */