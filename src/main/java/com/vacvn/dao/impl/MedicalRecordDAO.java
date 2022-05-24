package com.vacvn.dao.impl;

import java.util.List;

import com.vacvn.dao.IMedicalRecordDAO;
import com.vacvn.mapper.MedicalRecordMapper;
import com.vacvn.model.MedicalRecordModel;

public class MedicalRecordDAO extends AbstractDao<MedicalRecordModel> implements IMedicalRecordDAO {

	@Override
	public List<MedicalRecordModel> findByUserId(String userId) {
		String querString = "SELECT medicalrecord.*, vaccine.vaccinename FROM medicalrecord, user, admin, vaccine "
				+ "WHERE user.id = ? and medicalrecord.userid = user.id " 
				+ "and medicalrecord.adminid = admin.id and medicalrecord.vaccineid = vaccine.id;";
		return query(querString, new MedicalRecordMapper(), userId);
	}

	@Override
	public void insert(MedicalRecordModel medicalRecordModel, Long adminId, String userId) {
		String querString = "INSERT INTO medicalrecord (STT, adminid, userid, vaccineid, date, address) VALUES(?, ?, ?, ?, ?, ?);";
		update(querString, medicalRecordModel.getSTT(), adminId, userId, 
				medicalRecordModel.getVaccine().getId(), medicalRecordModel.getDate(), medicalRecordModel.getAddress());
	}

	@Override
	public Long countMedicalRecordByUserId(String userId) {
		String queryString = "SELECT medicalrecord.STT FROM medicalrecord WHERE medicalrecord.userid = ? ORDER BY STT DESC LIMIT 1";
		Object[] result = getAttribute(queryString, 1, userId);
		return (Long) (result.length > 0 ? result[0] : null);
		
	}

	@Override
	public MedicalRecordModel findOneBySTTandUserId(Long STT, String userId) {
		String querString = "SELECT medicalrecord.*, vaccine.vaccinename FROM medicalrecord, user, vaccine "
				+ "WHERE user.id = ? and medicalrecord.STT = ? and medicalrecord.userid = user.id" 
				+ " and medicalrecord.vaccineid = vaccine.id;";
		List<MedicalRecordModel> results = query(querString, new MedicalRecordMapper(), userId, STT);
		return results.isEmpty() ? null : results.get(0);
	}

	@Override
	public void update(MedicalRecordModel medicalRecordModel, Long adminId, String userId) {
		if(medicalRecordModel.getAddress() != null) {
			String queryString = "UPDATE medicalrecord SET adminid = ?, vaccineid = ?, date = ?, address = ? "
					+ "WHERE STT = ? and userid = ?";
			update(queryString, adminId, medicalRecordModel.getVaccine().getId(), medicalRecordModel.getDate(), 
					medicalRecordModel.getAddress(), medicalRecordModel.getSTT(), userId);
		}
		else {
			String queryString = "UPDATE medicalrecord SET adminid = ?, vaccineid = ?, date = ? "
					+ "WHERE STT = ? and userid = ?";
			update(queryString, adminId, medicalRecordModel.getVaccine().getId(), medicalRecordModel.getDate(), 
					 medicalRecordModel.getSTT(), userId);
		}
	}

	@Override
	public void delete(MedicalRecordModel medicalRecordModel, Long adminId, String userId) {
		String queryString = "DELETE from medicalrecord WHERE STT = ? and userid = ? and adminId = ?";
		update(queryString, medicalRecordModel.getSTT(), userId, adminId);
	}

	

}
