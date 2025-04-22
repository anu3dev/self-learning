
package com.data.JpaRepoSpringDatajpa.entity;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface VaccineRepo extends JpaRepository<VaccineDetails, Long> 
{

}
