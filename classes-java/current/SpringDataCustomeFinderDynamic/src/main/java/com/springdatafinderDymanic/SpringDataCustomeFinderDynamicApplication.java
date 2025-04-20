package com.springdatafinderDymanic;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springdatafinderDymanic.service.VaccineMngmtService;
import com.springdatafinderDymanic.type.ResultView1;


@SpringBootApplication
public class SpringDataCustomeFinderDynamicApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataCustomeFinderDynamicApplication.class, args);
		
		VaccineMngmtService service = context.getBean(VaccineMngmtService.class);
		
//		List<ResultView2> list1 = service.searchByVaccineCompany("BharatBiotech", ResultView2.class);
//				list1.forEach(vac->System.out.println(vac.getVaccineName() + " : "+ vac.getVaccineCompany()));
				
//				List<ResultView3> list2 = service.searchByVaccineCompany("BharatBiotech", ResultView3.class);
//				
//				list2.forEach(vac->System.out.println(vac.getPrice()));
				
		
		List<ResultView1> list2 = service.searchByVaccineCompany("BharatBiotech", ResultView1.class);
		
		list2.forEach(vac->System.out.println(vac.getId() + " : "+ vac.getVaccineName() + " : "+ vac.getPrice()));
				
		
	   context.close();
	}

}
