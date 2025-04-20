package com.springdatafinder;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springdatafinder.entity.VaccineDetails;
import com.springdatafinder.service.VaccineMngmtService;

@SpringBootApplication
public class SpringDataCustomeFinderApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataCustomeFinderApplication.class, args);
		
		VaccineMngmtService service = context.getBean(VaccineMngmtService.class);
		
		//service.fetchVaccineDetailsByCompany("BharatBiotech").forEach(vac->System.out.println(vac));
		//service.fetchVaccineDetailsByPrice(8644).forEach(v->System.out.println(v));
		
		List<String> vaccines=new ArrayList<>();
		
		vaccines.add("Covaxin");
		vaccines.add("phizer");
		
		//List<VaccineDetails> list = service.fetchVaccineDetailsByVaccinesAndPriceRange(vaccines, 432, 54433253);
		
		//list.forEach(v->System.out.println(v));
		service.fetchVaccineDetailsNotByName(vaccines).forEach(v->System.out.println(v));
		
		context.close();
	}

}
