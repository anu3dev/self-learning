package com.springdatafinder.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdatafinder.entity.VaccineDetails;
import com.springdatafinder.entity.VaccineRepo;



@Service("vservice")
public class VaccineMngmtService implements IVaccineMngmt {

	@Autowired
	private VaccineRepo repo;

	@Override
	public List<VaccineDetails> fetchVaccineDetailsByCompany(String companyName) {
		System.out.println(repo.getClass().getName() + " class implementing following methods" +
	       Arrays.toString(repo.getClass().getDeclaredMethods()));
	      
		List<VaccineDetails> list1=repo.findByVaccineCompany(companyName);
		System.out.println("find by company equals");
		repo.findByVaccineCompanyEquals(companyName).forEach(vac->System.out.println(vac));
		System.out.println("find by company is");
		repo.findByVaccineCompanyIs(companyName).forEach(vac->System.out.println(vac));
		System.out.println("find by company without keyword");
		
		
		return list1;
		
	}

	@Override
	public List<VaccineDetails> fetchVaccineDetailsByPrice(Integer price) {
		return repo.findByPriceLessThan(price);
		
	}

	@Override
	public List<VaccineDetails> fetchVaccineDetailsByVaccinesAndPriceRange(List<String> vaccines, Integer startRange,
			Integer endRange) 
	{
		return repo.findByVaccineNameInAndPriceBetween(vaccines, startRange, endRange);
		
	}

	@Override
	public List<VaccineDetails> fetchVaccineDetailsNotByName(List<String> vaccines) {
		return repo.findByVaccineNameNotIn(vaccines);
		
	}


}
