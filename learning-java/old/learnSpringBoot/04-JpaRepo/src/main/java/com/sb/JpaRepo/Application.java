package com.sb.JpaRepo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sb.JpaRepo.entity.VaccineDetails;
import com.sb.JpaRepo.service.VaccineManagementService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		VaccineManagementService vService = context.getBean(VaccineManagementService.class);
		
		
		
		
		
		System.out.println("\n" + "below is example to search records using method of()" + "\n");
		VaccineDetails vd1 = new VaccineDetails(4L, "sputanik", "SoRussia", 2536344);
		vService.searchVaccineByGivenData(vd1, true, "vaccineName", "vaccineCompany").
		forEach(vaccine -> System.out.println(vaccine));
		
		
		
		
		
		System.out.println("\n" + "below is example to search records using method of()" + "\n");
		VaccineDetails vd2 = new VaccineDetails(4L, "sputanik", "SoRussia", 2536344);
		vService.searchVaccineByGivenData(vd2).forEach(vac->System.out.println(vac));
		
		
		
		
		
		System.out.println("\n" + "below is example to search a record using method getReferenceById()" + "\n");
		VaccineDetails vaccine = vService.searchVaccineById(2L);
		System.out.println(vaccine);
		
		
		
		
		
		System.out.println("\n" + "below is example to delete records by passing keys inside array using deleteAllByIdInBatch()" + "\n");
		List<Long> ids = new ArrayList<>();
		ids.add(34L);		
		String mesg = vService.removeVaccineByIdsFromJpa(ids);
		System.out.println(mesg);
	}
}
