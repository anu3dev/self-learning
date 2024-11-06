package com.anu3dev;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
		
		Vaccine vac = new Vaccine("Phizer","Moderena",45454.4);
		String status = service.registerVaccineInfo(vac);
		System.out.println(status);

		List<Vaccine> vaccines = new ArrayList<Vaccine>();
		vaccines.add(new Vaccine("Polio","WHO",4545.4));
		vaccines.add(new Vaccine("CovidShield","Astrazenica",45445.4));
		vaccines.add(new Vaccine("Covaxin","BharatBio",454544.4));
		service.registerMultipleVaccineInfo(vaccines).forEach(v -> System.out.println(v));
		
		Long count=service.vaccinesCount();
		System.out.println("Number of vaccines available "+ count);
		
		int id = 5;
		Boolean status1 = service.checkVaccineAvailability(id);
		if(status1)
			System.out.println("Vaccine with id "+ id+" is available");
		else
			System.out.println("Vaccine with id "+ id+" is not available");
		
		service.getAllVaccinesInfo().forEach(v -> System.out.println(v));
		
		List<Integer> ids = new ArrayList<>();
		ids.add(2);
		ids.add(4);
		service.getAllVaccines(ids).forEach(v->System.out.println(v));
		
		Integer idVal = 12;
		Optional<Vaccine> optional = service.getVaccineById(idVal);
		if(optional.isPresent())
			System.out.println(optional.get());
		else
			System.out.println("vaccine with id "+idVal+" is not present in records");
		
		Integer idRemVal = 2;
		String status2 = service.removeVaccineById(idRemVal);
		System.out.println(status2);
		
		Vaccine vac1 = new Vaccine("Polio","WHO",4545.4);
		vac1.setId(2);
		String status3 = service.removeVaccineByVaccine(vac1);
		System.out.println(status3);
		
		List<Integer> idsVal = new ArrayList<>();
		ids.add(1);	
		ids.add(2);
		ids.add(4);
	    String status4 = service.removeAllVaccines(idsVal);
	    System.out.println(status4);
	}
}
