package com.anu3dev.repo;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.anu3dev.entity.Vaccine;

public interface IVaccineRepo extends JpaRepository<Vaccine,Integer> {
	@Query("FROM Vaccine WHERE vaccineCompany=:company")
	public List<Vaccine> searchByVaccineCompany(@Param("company")String companyName);
	
	@Query("FROM Vaccine WHERE vaccineCompany IN(:comp1,:comp2)")
	public List<Vaccine> searchByVaccineCompany(String comp1,String comp2);
	
	@Query("SELECT vaccineName,vaccineCompany FROM Vaccine WHERE cost BETWEEN :startingRange AND :maxRange")
	public List<String> searchVaccinesByCost(Double startingRange, Double maxRange);
	
	@Transactional
	@Modifying
	@Query("UPDATE Vaccine SET cost=:newPrice WHERE vaccineName=:vaccineName")
	public int updatePriceByVaccineName(Double newPrice, String vaccineName);
	
	@Transactional
	@Modifying
	@Query("Delete FROM Vaccine WHERE vaccineName=:vaccineName")
	public int deleteVaccinesByvaccineNames(String vaccineName);
	
	@Transactional
	@Modifying
	@Query(value="INSERT INTO vaccine(`id`,`vaccine_name`,`vaccine_company`,`cost`)Values(?,?,?,?)", nativeQuery=true)
	public int insertVaccineInfo(Integer id,String vaccineName, String vaccineCompany, Double cost);
	
	@Query(value="SELECT NOW() FROM DUAL", nativeQuery=true)
	public Date getTheSystemDateAndTime();
}
