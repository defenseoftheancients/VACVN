package com.vacvn.dao;

import java.util.List;

import com.vacvn.model.MedicalRecordModel;


public interface IMedicalRecordDAO extends IGenericDAO<MedicalRecordModel>{
	List<MedicalRecordModel> findByUserId(String userId);
	MedicalRecordModel findOneBySTTandUserId(Long STT, String userId);
	void insert(MedicalRecordModel medicalRecordModel, Long adminId, String userId);
	void update(MedicalRecordModel medicalRecordModel, Long adminId, String userId);
	void delete(MedicalRecordModel medicalRecordModel, Long adminId, String userId);
	Long countMedicalRecordByUserId(String userId);
}
