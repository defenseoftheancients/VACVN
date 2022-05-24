package com.vacvn.service;

import java.util.List;


import com.vacvn.model.UserModel;
import com.vacvn.model.VaccinationScheduleModel;

public interface IVaccinationScheduleService {
	List<VaccinationScheduleModel> findAll();
	VaccinationScheduleModel findOne(Long id);
	Object[] findOne(Long vaccinationScheduleId, String userId);
	
	VaccinationScheduleModel insert(VaccinationScheduleModel vaccinationSchedule, Long adminId);
	void insert(Long vaccinationScheduleId, String userId);
	void insert(Long vaccinationScheduleId, String userId, String vertification_code, Boolean isEnable);
	VaccinationScheduleModel update(VaccinationScheduleModel vaccinationSchedule,  Long adminId);
	void delete(VaccinationScheduleModel vaccinationSchedule);
	void delete(Long vaccinationScheduleId, String userId);
	List<UserModel> findAllRegisteredUser(Long id);
	List<VaccinationScheduleModel> findByUserId(String userId);
	List<VaccinationScheduleModel> findByAddress(String address);
}
