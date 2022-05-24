package com.vacvn.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.vacvn.dao.IVaccinationScheduleDAO;
import com.vacvn.model.UserModel;
import com.vacvn.model.VaccinationScheduleModel;
import com.vacvn.service.IVaccinationScheduleService;

public class VaccinationScheduleService implements IVaccinationScheduleService {

	@Inject
	private IVaccinationScheduleDAO vaccinationScheduleDAO;

	@Override
	public List<VaccinationScheduleModel> findAll() {
		return vaccinationScheduleDAO.findAll();
	}

	@Override
	public VaccinationScheduleModel findOne(Long id) {
		return vaccinationScheduleDAO.findOne(id);
	}

	@Override
	public Object[] findOne(Long vaccinationScheduleId, String userId) {
	
		return vaccinationScheduleDAO.findOne(vaccinationScheduleId, userId);
	}

	@Override
	public VaccinationScheduleModel insert(VaccinationScheduleModel vaccinationSchedule, Long adminId) {
		Long id = vaccinationScheduleDAO.insert(vaccinationSchedule, adminId);
		return findOne(id);
	}

	@Override
	public void insert(Long vaccinationScheduleId, String userId) {
		vaccinationScheduleDAO.insert(vaccinationScheduleId, userId, "AddByAdmin", true);
	}

	@Override
	public void insert(Long vaccinationScheduleId, String userId, String vertification_code, Boolean isEnable) {
		vaccinationScheduleDAO.insert(vaccinationScheduleId, userId, vertification_code, isEnable);
	}

	@Override
	public VaccinationScheduleModel update(VaccinationScheduleModel vaccinationSchedule, Long adminId) {
		vaccinationScheduleDAO.update(vaccinationSchedule, adminId);
		return findOne(vaccinationSchedule.getId());
	}

	@Override
	public void delete(VaccinationScheduleModel vaccinationSchedule) {
		vaccinationScheduleDAO.delete(vaccinationSchedule);
	}

	@Override
	public List<UserModel> findAllRegisteredUser(Long id) {
		return vaccinationScheduleDAO.findAllRegisteredUser(id);
	}

	@Override
	public void delete(Long vaccinationScheduleId, String userId) {
		vaccinationScheduleDAO.delete(vaccinationScheduleId, userId);
	}

	@Override
	public List<VaccinationScheduleModel> findByUserId(String userId) {
		return vaccinationScheduleDAO.findByUserId(userId);
	}

	@Override
	public List<VaccinationScheduleModel> findByAddress(String address) {
		return vaccinationScheduleDAO.findByAddress(address);
	}

}
