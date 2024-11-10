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

		service.fetchByVaccineCompany("BharatBio").forEach(v->System.out.println(v));
		service.fetchByVaccineCompany("BharatBio","Moderena").forEach(v->System.out.println(v));

		service.fetchVaccinesByCost(45454.4, 454544.4).forEach(v->System.out.println(v));
		
		int rowsAffected1 = service.updateThePriceByVaccineName(65454.4, "Covaxin");
		if(rowsAffected1!=0)
			System.out.println("Update success");
		else
			System.out.println("Update failure");
		
		int rowsAffected2 = service.deleteTheVaccinesByvaccineNames("Covaxin");
		if(rowsAffected2!=0)
			System.out.println("Record deleted");
		else
			System.out.println("deletion failure");
		
		int rowsAffected3 = service.insertVaccineDetails(4,"Covaxin", "BharatBio", 456534.5);
		if(rowsAffected3!=0)
			System.out.println("New Record Added");
		else
			System.out.println("Failed to add new Record");
		
		System.out.println(service.getSystemDateAndTime());
	}
}
