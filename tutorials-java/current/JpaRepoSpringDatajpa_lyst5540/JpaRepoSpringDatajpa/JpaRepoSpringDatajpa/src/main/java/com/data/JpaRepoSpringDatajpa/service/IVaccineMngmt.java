package com.data.JpaRepoSpringDatajpa.service;

import java.util.List;

import com.data.JpaRepoSpringDatajpa.entity.VaccineDetails;


public interface IVaccineMngmt 
{
  public List<VaccineDetails> searchVaccineByGivenData(VaccineDetails vaccine, boolean status, String... args);
  
  public List<VaccineDetails> searchVaccineByGivenData(VaccineDetails vaccine);
  
  public VaccineDetails searchVaccineById(Long id);
  public String removeVaccineByIds(Iterable<Long> ids);
}
