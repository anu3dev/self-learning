
package com.springdatafinderDymanic.entity;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatafinderDymanic.type.View;



public interface VaccineRepo extends JpaRepository<VaccineDetails, Long> 
{
    
     public <T extends View>List<T> findByVaccineCompany(String companyName, Class<T> cls);
     
}
