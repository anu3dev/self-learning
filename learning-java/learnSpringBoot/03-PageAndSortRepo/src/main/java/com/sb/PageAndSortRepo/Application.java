package com.sb.PageAndSortRepo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sb.PageAndSortRepo.entity.VaccineDetails;
import com.sb.PageAndSortRepo.service.VaccineManagementService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		VaccineManagementService vService = context.getBean(VaccineManagementService.class);
		
		
		
		
		
		System.out.println("\n" + "below is example to fetch sorted records using Sort in ascending" + "\n");
		vService.fetchSortedDetail(true, "vaccineName").
		forEach(vaccine->System.out.println(vaccine.getVaccineName()+ " "+ vaccine.getVaccineCompany()));

		
		
		
		
		System.out.println("\n" + "below is example to fetch sorted records using Sort in descending" + "\n");
		vService.fetchSortedDetail(false, "vaccineName").
		forEach(vaccine->System.out.println(vaccine.getVaccineName()+ " "+ vaccine.getVaccineCompany()));
	    
		
		
		
		
		System.out.println("\n" + "below is example to fetch and sort records from a particular page using method fetchDetailsByPageNo()" + "\n");
		Iterable<VaccineDetails> list = vService.fetchDetailsByPageNo(1, 2, true, "vaccineName","vaccineCompany");
		list.forEach(vaccine-> System.out.println(vaccine.getVaccineName()+ " "+ vaccine.getVaccineCompany()));
		
		
		
		
		
		System.out.println("\n" + "below is example to fetch records using fetchDetailsByPagination()" + "\n");
		vService.fetchDetailsByPagination(3);
	}
}
