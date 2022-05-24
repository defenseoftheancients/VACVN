package com.vacvn.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.vacvn.dao.IMedicalRecordDAO;
import com.vacvn.model.MedicalRecordModel;
import com.vacvn.service.IMedicalRecordService;

public class MedicalRecordService implements IMedicalRecordService {

	@Inject
	private IMedicalRecordDAO medicalRecordDAO;
	
	@Override
	public List<MedicalRecordModel> findByUserId(String userId) {
		return medicalRecordDAO.findByUserId(userId);
	}

	@Override
	public MedicalRecordModel insert(MedicalRecordModel medicalRecordModel, Long adminId, String userId) {
		Long STT = medicalRecordDAO.countMedicalRecordByUserId(userId);
		if(STT == null)
			STT = 0L;
		System.out.println(STT);
		medicalRecordModel.setSTT(STT+1);
		medicalRecordDAO.insert(medicalRecordModel, adminId, userId);
		return medicalRecordDAO.findOneBySTTandUserId(STT+1, userId);
	}

	@Override
	public MedicalRecordModel update(MedicalRecordModel medicalRecordModel, Long adminId, String userId) {
		medicalRecordDAO.update(medicalRecordModel, adminId, userId);
		return medicalRecordDAO.findOneBySTTandUserId(medicalRecordModel.getSTT(), userId);
	}

	@Override
	public void delete(MedicalRecordModel medicalRecordModel, Long adminId, String userId) {
		medicalRecordDAO.delete(medicalRecordModel, adminId, userId);
	}

}
