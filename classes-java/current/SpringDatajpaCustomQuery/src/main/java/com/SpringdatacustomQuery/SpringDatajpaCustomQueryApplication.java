package com.SpringdatacustomQuery;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.SpringdatacustomQuery.service.VaccineMngmtService;

@SpringBootApplication
public class SpringDatajpaCustomQueryApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringDatajpaCustomQueryApplication.class, args);
	
	     VaccineMngmtService service = context.getBean(VaccineMngmtService.class);
	     
//	     service.fetchVaccinesByCompanyName("BharatBiotech").forEach(v->System.out.println(v));
//	     System.out.println("*****************************************");
//	     
//	     System.out.println("*****************************************");
//	     
//	     List<VaccineDetails> list = service.fetchVaccinesByCompanies("BharatBiotech","Astrazen");
//	     list.forEach(vaccineDetails->System.out.println(vaccineDetails));
//	     
//	     System.out.println("*****************************************");
//	     
//	     System.out.println("*****************************************");
//	     
//	     service.fetachVaccinesByPriceRange(3234, 56453).forEach(vaccineNames->System.out.println(vaccineNames));
//	     System.out.println("*****************************************");
//	     
//	     System.out.println("*****************************************");
	     
//	     List<Object[]> list = service.fetchVaccinesByVaccinName("CovidShild", "phizer");
//	    // list.forEach(v->System.out.println(v));
//	     for(Object[] objects:list)
//	     {
//	    	 for(Object obj:objects)
//	    	 {
//	    		 System.out.println(obj + "  ");
//	    	 }
//	    	 System.out.println();
//	    	
//	     }
	     
	     //System.out.println("Number of rows affected : "+service.updateThePriceByVaccines(5454, "covaxin"));
	     //System.out.println("Number of rows deleted : "+ service.deleteTheVaccineByPrice(2345, 5454));
	     
//	    int insertedRows= service.insertVaccineDetails(454l, "BharatBiotech", "jnrCovaxin", 45454);
//	    System.out.println("Number of rows inserted " + insertedRows);
	     
	   Date date= service.getTheSystemDateAndTime();
	   System.out.println("The current Date and Time are : "+ date);
	     
	     context.close();
	
	}

}
