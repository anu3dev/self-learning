package com.anu3dev.service;

import java.util.List;

import com.anu3dev.view.ResultView;

public interface IVaccineService {
	public List<ResultView> fetchByCost(Double cost);
}
