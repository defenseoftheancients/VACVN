package com.vacvn.service;

import java.util.List;

import com.vacvn.model.VaccineModel;

public interface IVaccineService {
	List<VaccineModel> findAll();
	VaccineModel findById(Long id);
	VaccineModel insert(VaccineModel vaccine);
	VaccineModel update(VaccineModel vaccine);
	void deleteById(VaccineModel vaccine);
}
