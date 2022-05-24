package com.vacvn.dao;

import java.util.List;

import com.vacvn.model.VaccineModel;

public interface IVaccineDAO {
	List<VaccineModel> findAll();
	VaccineModel findById(Long id);
	Long insert(VaccineModel vaccine);
	void update(VaccineModel vaccine);
	void deleteById(Long id);
}
