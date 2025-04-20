package com.springdatafinderStatic;

import java.util.Arrays;
import java.util.List;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springdatafinderStatic.service.VaccineMngmtService;
import com.springdatafinderStatic.type.ResultView;

@SpringBootApplication
public class SpringDataCustomeFinderStaticApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDataCustomeFinderStaticApplication.class, args);
	
		VaccineMngmtService service = context.getBean(VaccineMngmtService.class);
		
		List<ResultView> list = service.searchVaccineByStartPrice(3542);
		System.out.println("We are getting result view");
		list.forEach(vac->
		{
			System.out.println(vac.getClass().getName()+ " => "+ Arrays.toString(vac.getClass().getDeclaredMethods()));
		
		          System.out.println(vac.getVaccineCompany() + " "+ vac.getVaccineName());
		});
		
	   context.close();
	
	}

}
