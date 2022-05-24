package com.vacvn.dao;

import java.util.List;

import com.vacvn.model.UserModel;
import com.vacvn.model.VaccinationScheduleModel;

public interface IVaccinationScheduleDAO {
	List<VaccinationScheduleModel> findAll();
	VaccinationScheduleModel findOne(Long id);
	Object[] findOne(Long vaccinationScheduleId, String userId);
	Long insert(VaccinationScheduleModel vaccinationSchedule, Long adminId);
	void insert(Long vaccinationScheduleId, String userId);
	void insert(Long vaccinationScheduleId, String userId, String vertification_code, Boolean isEnable);
	void update(VaccinationScheduleModel vaccinationSchedule, Long adminId);
	void delete(VaccinationScheduleModel vaccinationSchedule);
	void delete(Long vaccinationScheduleId, String userId);
	List<UserModel> findAllRegisteredUser(Long id);
	List<VaccinationScheduleModel> findByUserId(String userId);
	List<VaccinationScheduleModel> findByAddress(String address);
}
