
package com.springdatafinderStatic.entity;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springdatafinderStatic.type.ResultView;

public interface VaccineRepo extends JpaRepository<VaccineDetails, Long> 
{
     public List<ResultView> findByPriceGreaterThanEqual(Integer price);
     
     
}
