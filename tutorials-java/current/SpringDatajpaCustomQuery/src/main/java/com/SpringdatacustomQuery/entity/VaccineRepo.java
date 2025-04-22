
package com.SpringdatacustomQuery.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;


public interface VaccineRepo extends JpaRepository<VaccineDetails, Long> 
{
//    @Query("FROM VaccineDetails WHERE vaccineCompany= :companyName")
//    public List<VaccineDetails> searchVaccinesByCompanyName(String companyName);
    
    @Query("FROM VaccineDetails WHERE vaccineCompany= :company")
    public List<VaccineDetails> searchVaccinesByCompanyName(@Param("company")String companyName);
    
    @Query("FROM VaccineDetails WHERE vaccineCompany IN(:comp1,:comp2)")
    public List<VaccineDetails> searchVaccinesByCompanies(String comp1, String comp2);
    
    
    @Query("SELECT vaccineName FROM VaccineDetails WHERE price BETWEEN :min AND :max")
    public List<String> searchVaccinesByPriceRange(Integer min, Integer max);
    
    @Query("SELECT vaccineCompany, price FROM VaccineDetails WHERE vaccineName IN(:vac1, :vac2)")
    public List<Object[]> searchVaccinesByVaccinName(String vac1, String vac2);
    
//    @Query("SELECT vaccineCompany, price FROM VaccineDetails WHERE vaccineName IN(:vac1, :vac2)")
//    public List<Object> searchVaccinesByVaccinName(String vac1, String vac2);
    
       @Transactional
       @Modifying
       @Query("UPDATE VaccineDetails SET price=:newPrice WHERE vaccineName=:vaccineName")
       public int updatePriceByVaccines(Integer newPrice, String vaccineName) ;
       
       @Transactional
       @Modifying
       @Query("DELETE FROM VaccineDetails WHERE price BETWEEN :minPrice AND :maxPrice")
       public int deleteVaccineByPrice(Integer minPrice, Integer maxPrice);
       
       
       @Transactional
       @Modifying
       @Query(value="INSERT INTO vaccinedetails(`id`, `vaccinecompany`, `vaccinename`, `price`) Values(?,?,?,?)", nativeQuery=true)
       public int insertVaccineData(Long id , String companyName, String vaccineName, Integer price );
       
       @Query(value="SELECT NOW() FROM DUAL" , nativeQuery=true)
       public Date getTheSystemDateAndTime();
       
    
    
    
    
     
}
