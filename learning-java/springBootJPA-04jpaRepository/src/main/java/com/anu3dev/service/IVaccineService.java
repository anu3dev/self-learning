package com.anu3dev.service;

import java.util.List;

import com.anu3dev.entity.Vaccine;

public interface IVaccineService {
	public Vaccine searchVaccineById(Integer id);
	public List<Vaccine> searchVaccineByGivenInfo(Vaccine vac);
	public String removeVaccineInfoByIds(Iterable<Integer> ids);
}
