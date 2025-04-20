package com.springdatafinder.service;

import java.util.List;

import com.springdatafinder.entity.VaccineDetails;


public interface IVaccineMngmt 
{
  public List<VaccineDetails> fetchVaccineDetailsByCompany(String CompanyName);
  public List<VaccineDetails> fetchVaccineDetailsByPrice(Integer price);
  
  public List<VaccineDetails> fetchVaccineDetailsByVaccinesAndPriceRange(List<String> vaccines,Integer startRange, Integer endRange);
  
  public List<VaccineDetails>  fetchVaccineDetailsNotByName(List<String> vaccines);

}
