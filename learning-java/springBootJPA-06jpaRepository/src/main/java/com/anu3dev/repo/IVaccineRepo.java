package com.anu3dev.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anu3dev.entity.Vaccine;
import com.anu3dev.view.View;

public interface IVaccineRepo extends JpaRepository<Vaccine,Integer>{
	public<T extends View>List<T>findByCostLessThan(Double cost, Class<T> cls);
}
