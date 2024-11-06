package com.anu3dev.service;

import java.util.List;
import java.util.Optional;

import com.anu3dev.entity.Vaccine;

public interface IVaccineService {
	public String registerVaccineInfo(Vaccine vaccine);
	public Iterable<Vaccine> registerMultipleVaccineInfo(Iterable<Vaccine> vaccines);
	public Long vaccinesCount();
	public Boolean checkVaccineAvailability(Integer id);
	public Iterable<Vaccine> getAllVaccinesInfo();
	public Iterable<Vaccine> getAllVaccines(Iterable<Integer>ids);
	public Optional<Vaccine> getVaccineById(Integer id);
	public String removeVaccineById(Integer id);
	public String removeVaccineByVaccine(Vaccine obj);
	public String removeAllVaccines(List<Integer>ids);
}
