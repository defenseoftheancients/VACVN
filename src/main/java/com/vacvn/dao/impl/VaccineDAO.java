package com.vacvn.dao.impl;

import java.util.List;

import com.vacvn.dao.IVaccineDAO;
import com.vacvn.mapper.VaccineMapper;
import com.vacvn.model.VaccineModel;

public class VaccineDAO extends AbstractDao<VaccineModel> implements IVaccineDAO {
	
	@Override
	public List<VaccineModel> findAll() {
		String queryString = "SELECT * FROM vaccine";
		List<VaccineModel> results = query(queryString, new VaccineMapper());
		return results == null ? null : results;
	}
	@Override
	public VaccineModel findById(Long id) {
		String queryString = "SELECT * FROM vaccine WHERE id = ?";
		List<VaccineModel> results = query(queryString, new VaccineMapper(), id);
		return results == null ? null : results.get(0);
	}
	@Override
	public Long insert(VaccineModel vaccine) {
		String queryString = "INSERT INTO vaccine (vaccinename) VALUES(?)";
		return insert(queryString, vaccine.getVaccineName());
	}

	@Override
	public void update(VaccineModel vaccine) {
		String queryString = "UPDATE vaccine SET vaccinename = ?  WHERE id = ?";
		update(queryString, vaccine.getVaccineName(), vaccine.getId());
	}

	@Override
	public void deleteById(Long id) {
		String queryString = "DELETE from vaccine WHERE id = ?";
		update(queryString, id);
	}

	

	
}
