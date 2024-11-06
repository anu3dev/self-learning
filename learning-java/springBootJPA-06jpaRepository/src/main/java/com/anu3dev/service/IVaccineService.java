package com.anu3dev.service;

import java.util.List;

import com.anu3dev.view.View;

public interface IVaccineService {
	public<T extends View>List<T>fetchByCostLessThan(Double cost, Class<T> cls);
}
