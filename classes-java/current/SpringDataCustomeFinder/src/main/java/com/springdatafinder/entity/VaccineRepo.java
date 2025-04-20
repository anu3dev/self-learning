
package com.springdatafinder.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VaccineRepo extends JpaRepository<VaccineDetails, Long> 
{
	//property name followed by findBy
   public List<VaccineDetails> findByVaccineCompany(String companyName);
   
 //findByPropertyNamekeyword
   public List<VaccineDetails> findByVaccineCompanyIs(String companyName);
   public List<VaccineDetails> findByVaccineCompanyEquals(String companyName);
   
   public List<VaccineDetails> findByPriceLessThan(Integer price);
   //property followed by keyword
   public List<VaccineDetails> findByVaccineNameInAndPriceBetween(Collection<String> vaccineNames,
		   Integer startRange, Integer endRange);
   
   public List<VaccineDetails> findByVaccineNameNotIn(Collection<String> vaccineNames);
}
