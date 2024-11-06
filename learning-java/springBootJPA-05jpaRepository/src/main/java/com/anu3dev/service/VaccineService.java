package com.anu3dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anu3dev.repo.IVaccineRepo;
import com.anu3dev.view.ResultView;
@Service
public class VaccineService implements IVaccineService {
	private IVaccineRepo repo;
	
	@Autowired
	public void setRepo(IVaccineRepo repo){	
		this.repo = repo;
	}

	@Override
	public List<ResultView> fetchByCost(Double cost) {
		return repo.findByCostLessThan(cost);
	}
}
