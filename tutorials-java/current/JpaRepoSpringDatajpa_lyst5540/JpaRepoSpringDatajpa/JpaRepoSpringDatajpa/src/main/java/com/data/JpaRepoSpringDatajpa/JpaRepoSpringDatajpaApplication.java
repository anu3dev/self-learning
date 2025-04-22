package com.data.JpaRepoSpringDatajpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.data.JpaRepoSpringDatajpa.service.VaccineMngmtService;

@SpringBootApplication
public class JpaRepoSpringDatajpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JpaRepoSpringDatajpaApplication.class, args);
	 
		VaccineMngmtService vser = context.getBean(VaccineMngmtService.class);
		  
		//VaccineDetails vd=new VaccineDetails(14l, "CovidShild","AstraZen",123456);
		/*
		 * vser.searchVaccineByGivenData(vd, true, "vaccineName", "vaccineCompany").
		 * forEach(vaccine -> System.out.println(vaccine));
		 */
		//vser.searchVaccineByGivenData(vd).forEach(vac->System.out.println(vac));
		
//		VaccineDetails vaccine = vser.searchVaccineById(44l);
//		System.out.println(vaccine);
		
		List<Long> ids=new ArrayList<>();
		ids.add(12l);
		ids.add(44l);
		
		String mesg=vser.removeVaccineByIds(ids);
		System.out.println(mesg);
	
	     context.close();
	
	}

}
