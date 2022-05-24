package com.vacvn.dao.impl;

import java.util.List;

import com.vacvn.dao.IVaccinationScheduleDAO;
import com.vacvn.mapper.UserMapper;
import com.vacvn.mapper.VaccinationScheduleMapper;

import com.vacvn.model.UserModel;
import com.vacvn.model.VaccinationScheduleModel;

public class VaccinationScheduleDAO extends AbstractDao<VaccinationScheduleModel> implements IVaccinationScheduleDAO {

	@Override
	public List<VaccinationScheduleModel> findAll() {
		String queryString = "SELECT vaccinationschedule.*, vaccine.vaccinename FROM vaccinationschedule, vaccine "
				+ "WHERE vaccinationschedule.vaccineid = vaccine.id;";
		return query(queryString, new VaccinationScheduleMapper());
	}

	@Override
	public VaccinationScheduleModel findOne(Long id) {
		String queryString = "SELECT vaccinationschedule.*, vaccine.vaccinename FROM vaccinationschedule, vaccine "
				+ "WHERE vaccinationschedule.id = ? and vaccine.id = vaccinationschedule.vaccineid;";
		List<VaccinationScheduleModel> vaccinationSchedules = query(queryString, new VaccinationScheduleMapper(), id);
		return vaccinationSchedules.get(0);
	}
	
	@Override
	public Object[] findOne(Long vaccinationScheduleId, String userId) {
		String queryString = "SELECT * FROM vcs_user "
				+ "WHERE vaccinationscheduleid = ? and userid = ?;";
		return getAttribute(queryString, 4, vaccinationScheduleId, userId);
	}
	
	@Override
	public List<VaccinationScheduleModel> findByUserId(String userId) {
		String queryString = "SELECT vaccinationschedule.*,  vaccine.vaccinename FROM vcs_user, vaccinationschedule, vaccine "
				+ "WHERE vcs_user.userid = ? and vcs_user.enable = 1 "
				+ "and vaccinationschedule.vaccineid = vaccine.id and vaccinationschedule.id = vcs_user.vaccinationscheduleid "
				+ "and STR_TO_DATE(vaccinationschedule.date, '%d/%m/%Y') >= CURDATE()";
		return query(queryString, new VaccinationScheduleMapper(), userId);
	}

	@Override
	public List<VaccinationScheduleModel> findByAddress(String address) {
		String queryString = "SELECT vaccinationschedule.*, vaccine.vaccinename "
				+ "FROM vaccinationschedule, vaccine WHERE address RLIKE ? and vaccine.id = vaccinationschedule.vaccineid "
				+ "and vaccinationschedule.status = 1 and STR_TO_DATE(vaccinationschedule.date, '%d/%m/%Y') >= CURDATE()";
		return query(queryString, new VaccinationScheduleMapper(), address);
	}

	@Override
	public Long insert(VaccinationScheduleModel vaccinationSchedule, Long adminId) {
		String queryString = "INSERT INTO vaccinationschedule (address, date, day, amount, status, adminid, vaccineid) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?);";
		return insert(queryString, vaccinationSchedule.getAddress(), vaccinationSchedule.getDate(),
				vaccinationSchedule.getDay(), vaccinationSchedule.getAmount(),
				vaccinationSchedule.getStatus() ? 1 : 0, adminId, vaccinationSchedule.getVaccine().getId());
	}
	@Override
	public void insert(Long vaccinationScheduleId, String userId) {
		String queryString = "INSERT INTO vcs_user (vaccinationscheduleid, userid) "
				+ "VALUES (?, ?);";
		update(queryString, vaccinationScheduleId, userId);
	}
	@Override
	public void insert(Long vaccinationScheduleId, String userId, String vertification_code, Boolean isEnable) {
		String queryString = "INSERT INTO vcs_user (vaccinationscheduleid, userid, vertification_code, enable) "
				+ "VALUES (?, ?, ?, ?)  AS new (m, n, p, q) "
				+ " ON DUPLICATE KEY UPDATE vcs_user.vertification_code = new.p, vcs_user.enable = new.q;";
		
		update(queryString, vaccinationScheduleId, userId, vertification_code, isEnable);
		
	}
	
	@Override
	public void update(VaccinationScheduleModel vaccinationSchedule, Long adminId) {
		String queryString = null;
		System.out.println(vaccinationSchedule.getAddress());
		if(vaccinationSchedule.getAddress() != null) {
			queryString = "UPDATE vaccinationschedule SET address = ?, date = ?, day = ?, amount = ?, "
					+ "status = ?, adminid = ?, vaccineid = ? WHERE id = ?;";
			update(queryString, vaccinationSchedule.getAddress(), vaccinationSchedule.getDate(), 
					vaccinationSchedule.getDay(), vaccinationSchedule.getAmount(), 
					vaccinationSchedule.getStatus() ? 1 : 0, adminId, vaccinationSchedule.getVaccine().getId(), 
							vaccinationSchedule.getId());
		}
		else {
			queryString = "UPDATE vaccinationschedule SET date = ?, day = ?, amount = ?, "
					+ "status = ?, adminid = ?, vaccineid = ? WHERE id = ?;";
			update(queryString, vaccinationSchedule.getDate(), vaccinationSchedule.getDay(),
					vaccinationSchedule.getAmount(), vaccinationSchedule.getStatus() ? 1 : 0, adminId, 
					 vaccinationSchedule.getVaccine().getId(), vaccinationSchedule.getId());
		}
	}

	@Override
	public void delete(VaccinationScheduleModel vaccinationSchedule) {
		String queryString = "DELETE FROM vaccinationschedule WHERE id = ?";
		update(queryString, vaccinationSchedule.getId());
	}

	@Override
	public List<UserModel> findAllRegisteredUser(Long id) {
		String queryString = "SELECT user.*  FROM vcs_user, vaccinationschedule, user "
				+ "WHERE vaccinationschedule.id = ? "
				+ "and vcs_user.vaccinationscheduleid =  vaccinationschedule.id "
				+ "and vcs_user.userid = user.id and vcs_user.enable = 1";
		return query(queryString, new UserMapper(), id);
	}

	@Override
	public void delete(Long vaccinationScheduleId, String userId) {
		String queryString = "DELETE FROM vcs_user WHERE vaccinationscheduleid = ? and userid = ?";
		update(queryString, vaccinationScheduleId, userId);
	}

	

	
	

	

}
