package com.vacvn.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.vacvn.dao.IVaccineDAO;
import com.vacvn.model.VaccineModel;
import com.vacvn.service.IVaccineService;

public class VaccineService implements IVaccineService {

	@Inject
	private IVaccineDAO vaccineDAO;
	
	@Override
	public List<VaccineModel> findAll() {
		return vaccineDAO.findAll();
	}
	@Override
	public VaccineModel findById(Long id) {
		return vaccineDAO.findById(id);
	}
	@Override
	public VaccineModel insert(VaccineModel vaccine) {
		Long id = vaccineDAO.insert(vaccine);
		return vaccineDAO.findById(id);
	}

	@Override
	public VaccineModel update(VaccineModel vaccine) {
		vaccineDAO.update(vaccine);
		return vaccineDAO.findById(vaccine.getId());
	}

	@Override
	public void deleteById(VaccineModel vaccine) {
		vaccineDAO.deleteById(vaccine.getId());
	}

}
