package com.anu3dev.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anu3dev.entity.Vaccine;
import com.anu3dev.view.ResultView;

public interface IVaccineRepo extends JpaRepository<Vaccine,Integer>{
	List<ResultView> findByCostLessThan(Double cost);
}
