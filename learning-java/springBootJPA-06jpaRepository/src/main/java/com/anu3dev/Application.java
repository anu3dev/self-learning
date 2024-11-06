package com.anu3dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anu3dev.service.VaccineService;
import com.anu3dev.view.ResultView2;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(Application.class, args);
		VaccineService service = container.getBean(VaccineService.class);
		
		service.fetchByCostLessThan(54645.4, ResultView2.class).forEach(v->System.out.println
				(v.getVaccineName()+" "+v.getVaccineCompany()+" "+v.getCost()));
	}
}
