package com.anu3dev.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anu3dev.repo.IVaccineRepo;
import com.anu3dev.view.View;
@Service
public class VaccineService implements IVaccineService {
	private IVaccineRepo repo;
	
	@Autowired
	public void setRepo(IVaccineRepo repo) {	
		this.repo = repo;
	}

	@Override
	public <T extends View> List<T> fetchByCostLessThan(Double cost, Class<T> cls){
		return repo.findByCostLessThan(cost, cls);
	}
}
