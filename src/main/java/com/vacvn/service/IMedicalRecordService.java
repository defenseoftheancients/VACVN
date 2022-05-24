package com.vacvn.service;

import java.util.List;

import com.vacvn.model.MedicalRecordModel;

public interface IMedicalRecordService {
	List<MedicalRecordModel> findByUserId(String userId);
	MedicalRecordModel insert(MedicalRecordModel medicalRecordModel, Long adminId, String userId);
	MedicalRecordModel update(MedicalRecordModel medicalRecordModel, Long adminId, String userId);
	void delete(MedicalRecordModel medicalRecordModel, Long adminId, String userId);
}
