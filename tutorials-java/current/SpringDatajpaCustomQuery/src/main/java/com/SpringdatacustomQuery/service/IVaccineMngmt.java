package com.SpringdatacustomQuery.service;

import java.util.Date;
import java.util.List;

import com.SpringdatacustomQuery.entity.VaccineDetails;


public interface IVaccineMngmt 
{
	public List<VaccineDetails> fetchVaccinesByCompanyName(String companyName);
	
	public List<VaccineDetails> fetchVaccinesByCompanies(String comp1, String comp2);
	
	public List<String> fetachVaccinesByPriceRange(Integer min, Integer max);
	
	 public List<Object[]> fetchVaccinesByVaccinName(String vac1, String vac2);
	
	//public List<Object> fetchVaccinesByVaccinName(String vac1, String vac2);
	 
	 public int updateThePriceByVaccines(Integer newPrice, String vaccineName) ;
	 
	 public int deleteTheVaccineByPrice(Integer minPrice, Integer maxPrice);

	 public int insertVaccineDetails(Long id , String companyName, String vaccineName, Integer price );
	 
	 public Date getTheSystemDateAndTime();
}
