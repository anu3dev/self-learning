package com.anu3dev;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.anu3dev.entity.Vaccine;
import com.anu3dev.service.VaccineService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext container = SpringApplication.run(Application.class, args);
		VaccineService service = container.getBean(VaccineService.class);
		
		Vaccine vac1 = service.searchVaccineById(4);
		System.out.println(vac1);
		
		Vaccine vac2 = new Vaccine("CovidShield", "Astrazenica", 45445.4);
		vac2.setId(3);
		service.searchVaccineByGivenInfo(vac2).forEach(v->System.out.println(v));
		
		List<Integer> ids = new ArrayList<>();
		ids.add(150);
		ids.add(153);
		ids.add(154);
		String status = service.removeVaccineInfoByIds(ids);
		System.out.println(status);
	}
}

/*
 * 
 * Dependencies ->
 * Spring Data JPA
 * MySQL Driver
 * Lombok
 * 
 * JPARepository extends pagingandsortingRepository extends crudRepository extends Repository
 * 
 */