package com.sb.CrudRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.sb.CrudRepo.entity.VaccineDetails;
import com.sb.CrudRepo.service.VaccineManagementService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
		VaccineManagementService vService = context.getBean(VaccineManagementService.class);
		
		
		
		
		
		System.out.println("\n" + "below is example to store a record using method save()" + "\n");
		VaccineDetails vc = new VaccineDetails();		
		vc.setId(1L);
		vc.setVaccineName("CovidShield");
		vc.setVaccineCompany("Astrazanica");
		vc.setPrice(5999);
		vService.registerVaccine(vc);
		
		
		
		
		
		System.out.println("\n" + "below is example to store multiple record using method saveAll()" + "\n");
	    VaccineDetails vc1 = new VaccineDetails(2L, "CoVaccine", "bhatBiotech", 25363);
	    VaccineDetails vc2 = new VaccineDetails(3L, "pFizer", "someUsa", 25363455);
	    VaccineDetails vc3 = new VaccineDetails(4L, "sputanik", "SoRussia", 2536344);
	    VaccineDetails vc31 = new VaccineDetails(31L, "sputanik", "SoRussia", 2536344);
	    VaccineDetails vc32 = new VaccineDetails(32L, "CoVaccine", "bhatBiotech", 25363);
	    VaccineDetails vc33 = new VaccineDetails(33L, "pFizer", "someUsa", 25363455);
	    VaccineDetails vc34 = new VaccineDetails(34L, "sputanik", "SoRussia", 2536344);
	    VaccineDetails vc35 = new VaccineDetails(35L, "sputanik", "SoRussia", 2536344);
	    List<VaccineDetails> vaccineList = new ArrayList<>();
	    vaccineList.add(vc1);
	    vaccineList.add(vc2);
	    vaccineList.add(vc3);
	    vaccineList.add(vc31);
	    vaccineList.add(vc32);
	    vaccineList.add(vc33);
	    vaccineList.add(vc34);
	    vaccineList.add(vc35);
	    vService.registerInBatch(vaccineList);
	    
	    
	    
	    
		
	    System.out.println("\n" + "below is example to count using method count()" + "\n");
	    System.out.println("Number of vaccines added so far "+ vService.getVaccinesCount());
	    
	    
	    
	    
	    
	    System.out.println("\n" + "below is example to check whether a record exist or not using method existsById()" + "\n");
	    if(vService.checkAvailablity(7L))
	    	System.out.println("Vaccine is available");
	    else
	    	System.out.println("Vaccine is not available");

	    
	    
	    
	    
	    System.out.println("\n" + "below is example to fetch all records using method findAll()" + "\n");
		vService.fetchAllDetails().forEach(vaccine -> System.out.println(vaccine));
		
		
		
		
		
		System.out.println("\n" + "below is example to fetch multiple records by passing keys inside an array using method findAllById()" + "\n");
	    List<Long> idList1 = new ArrayList<>();
	    idList1.add(2L);
	    idList1.add(3L);
	    ArrayList<VaccineDetails> list1 = (ArrayList<VaccineDetails>) vService.fetchAllDetailsById(idList1);
	    for(VaccineDetails li:list1) {
	    	System.out.println("using ArrayList" + li);
	    }
	    Iterable<VaccineDetails> list2 = vService.fetchAllDetailsById(idList1);
	    list2.forEach(vaccine->System.out.println("using Iterable" + vaccine));

	    
	    
	    
	    
	    System.out.println("\n" + "below is example to fetch one record using method findById()" + "\n");
	    Optional<VaccineDetails> val = vService.fetchById(2L);
	    if(val.isPresent())
	    	System.out.println(val.get());
	    else
	    	val.orElseThrow(()-> new IllegalArgumentException("Record is not present with given id"));

	    
	    
	    
	    
	    System.out.println("\n" + "below is example to remove one record using method deleteById()" + "\n");
		System.out.println(vService.removeVaccineById(8L));		
		
		
		
		
		
		System.out.println("\n" + "below is example to remove records by passing keys inside an array using method deleteAllById()" + "\n");
	    List<Long> idList2 = new ArrayList<>();
	    idList2.add(5L);
	    idList2.add(7L);
	    System.out.println(vService.removeVaccineByIdsFromCrud(idList2));

	    
	    
	    
	    
	    System.out.println("\n" + "below is example to remove one record using method removeVaccineByObject()" + "\n"); 
		VaccineDetails vaccineDetails2 = new VaccineDetails(6L, "phizer", "SomeUs", 25363455);
		System.out.println(vService.removeVaccineByObject(vaccineDetails2));

	}
}
