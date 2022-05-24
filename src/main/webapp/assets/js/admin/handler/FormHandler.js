
import { handleFormUser, handleFormVaccine, handleFormMedicalRecord, handleFormAdmin, handleFormVaccinationSchedule, handleFormUserVCS } from "../util/FormUtil.js";
import { handleSubmit } from "../util/JsonUtil.js";
import { SYSTEM_URL } from "../../common/SYSTEM_URL.js";
const formAddUser = document.querySelector('#form-adduser');
const formUpdateUser = document.querySelector('#form-updateuser');
const formDeleteUser = document.querySelector('#form-deleteuser');
const formAddVaccine = document.querySelector('#form-addvaccine');
const formUpdateVaccine = document.querySelector('#form-updatevaccine');
const formDeleteVaccine = document.querySelector('#form-deletevaccine');
const formAddMedicalRecord = document.querySelector('#form-addmedicalrecord');
const formUpdateMedicalRecord = document.querySelector('#form-updatemedicalrecord');
const formDeleteMedicalRecord = document.querySelector('#form-deletemedicalrecord');
const formAddAdmin = document.querySelector('#form-addadmin');
const formUpdateAdmin = document.querySelector('#form-updateadmin');
const formDeleteAdmin = document.querySelector('#form-deleteadmin');
const formAddVCS = document.querySelector('#form-addvcs');
const formUpdateVCS = document.querySelector('#form-updatevcs');
const formDeleteVCS = document.querySelector('#form-deletevcs');
const formAddUserVCS = document.querySelector('#form-adduservcs');
const formDeleteUserVCS = document.querySelector('#form-deleteuservcs');
if (formAddUser) {
	formAddUser.addEventListener('submit', function(e) {
		e.preventDefault();
		handleSubmit(e, SYSTEM_URL.USER_API_URL(),
			"POST", JSON.stringify(handleFormUser(formAddUser, true, 'user')),
			SYSTEM_URL.USER_ADMIN_URL,
			SYSTEM_URL.USER_ADMIN_URL);
	});
};
if (formUpdateUser) {
	formUpdateUser.addEventListener('submit', function(e) {
		handleSubmit(e, SYSTEM_URL.USER_API_URL(),
			"PUT", JSON.stringify(handleFormUser(formUpdateUser, false, 'user')),
			SYSTEM_URL.USER_ADMIN_URL,
			SYSTEM_URL.USER_ADMIN_URL);
	});
};

if (formDeleteUser) {
	formDeleteUser.addEventListener('submit', function(e) {
		handleSubmit(e, SYSTEM_URL.USER_API_URL(),
			"DELETE", JSON.stringify(handleFormUser(formDeleteUser, false, 'user')),
			SYSTEM_URL.USER_ADMIN_URL,
			SYSTEM_URL.USER_ADMIN_URL);
	});
};

if (formAddVaccine) {
	formAddVaccine.addEventListener('submit', function(e) {
		handleSubmit(e, SYSTEM_URL.VACCINE_API_URL,
			"POST", JSON.stringify(handleFormVaccine(formAddVaccine)),
			SYSTEM_URL.VACCINE_ADMIN_URL,
			SYSTEM_URL.VACCINE_ADMIN_URL);
	});
};
if (formUpdateVaccine) {
	formUpdateVaccine.addEventListener('submit', function(e) {
		handleSubmit(e, SYSTEM_URL.VACCINE_API_URL,
			"PUT", JSON.stringify(handleFormVaccine(formUpdateVaccine)),
			SYSTEM_URL.VACCINE_ADMIN_URL,
			SYSTEM_URL.VACCINE_ADMIN_URL);
	});
};
if (formDeleteVaccine) {
	formDeleteVaccine.addEventListener('submit', function(e) {

		handleSubmit(e, SYSTEM_URL.VACCINE_API_URL,
			"DELETE", JSON.stringify(handleFormVaccine(formDeleteVaccine)),
			SYSTEM_URL.VACCINE_ADMIN_URL,
			SYSTEM_URL.VACCINE_ADMIN_URL);
	});
};

if (formAddMedicalRecord) {
	formAddMedicalRecord.addEventListener('submit', function(e) {
		handleSubmit(e, SYSTEM_URL.MEDICAL_RECORDS_API_URL,
			"POST", JSON.stringify(handleFormMedicalRecord(formAddMedicalRecord, true, 'injection')),
			window.location.href,
			window.location.href);
	});
};

if (formUpdateMedicalRecord) {
	formUpdateMedicalRecord.addEventListener('submit', function(e) {
		handleSubmit(e, SYSTEM_URL.MEDICAL_RECORDS_API_URL,
			"PUT", JSON.stringify(handleFormMedicalRecord(formUpdateMedicalRecord, true, 'injection')),
			window.location.href,
			window.location.href);
	});
};
if (formDeleteMedicalRecord) {
	formDeleteMedicalRecord.addEventListener('submit', function(e) {
		handleSubmit(e, SYSTEM_URL.MEDICAL_RECORDS_API_URL,
			"DELETE", JSON.stringify(handleFormMedicalRecord(formDeleteMedicalRecord, false, 'injection')),
			window.location.href,
			window.location.href);
	});
};

if (formAddAdmin) {
	formAddAdmin.addEventListener('submit', function(e) {
		handleSubmit(e, SYSTEM_URL.ADMIN_API_URL,
			"POST", JSON.stringify(handleFormAdmin(formAddAdmin, 'admin')),
			window.location.href,
			window.location.href);
	});
};
if (formUpdateAdmin) {
	formUpdateAdmin.addEventListener('submit', function(e) {
		handleSubmit(e, SYSTEM_URL.ADMIN_API_URL,
			"PUT", JSON.stringify(handleFormAdmin(formUpdateAdmin, 'admin')),
			window.location.href,
			window.location.href);
	});
};

if (formDeleteAdmin) {
	formDeleteAdmin.addEventListener('submit', function(e) {
		handleSubmit(e, SYSTEM_URL.ADMIN_API_URL,
			"DELETE", JSON.stringify(handleFormAdmin(formDeleteAdmin, 'admin')),
			window.location.href,
			window.location.href);
	});
};
if (formAddVCS) {
	formAddVCS.addEventListener('submit', function(e) {
		handleSubmit(e, SYSTEM_URL.VACCINATION_SCHEDULE_API_URL(),
			"POST", JSON.stringify(handleFormVaccinationSchedule(formAddVCS, true, 'vcs')),
			window.location.href,
			window.location.href);
	});
};
if (formUpdateVCS) {
	formUpdateVCS.addEventListener('submit', function(e) {
		handleSubmit(e, SYSTEM_URL.VACCINATION_SCHEDULE_API_URL(),
			"PUT", JSON.stringify(handleFormVaccinationSchedule(formUpdateVCS, true, 'vcs')),
			SYSTEM_URL.VACCINATION_SCHEDULE_ADMIN_URL,
			SYSTEM_URL.VACCINATION_SCHEDULE_ADMIN_URL);
	});
}
if (formDeleteVCS) {
	formDeleteVCS.addEventListener('submit', function(e) {
		handleSubmit(e, SYSTEM_URL.VACCINATION_SCHEDULE_API_URL(),
			"DELETE", JSON.stringify(handleFormVaccinationSchedule(formDeleteVCS, false, 'vcs')),
			SYSTEM_URL.VACCINATION_SCHEDULE_ADMIN_URL,
			SYSTEM_URL.VACCINATION_SCHEDULE_ADMIN_URL);
	});
};

if (formAddUserVCS) {
	formAddUserVCS.addEventListener('submit', function(e) {
		handleSubmit(e, SYSTEM_URL.VACCINATION_SCHEDULE_API_URL(),
			"POST", JSON.stringify(handleFormUserVCS(formAddUserVCS)),
			window.location.href,
			window.location.href);
	});
};
if (formDeleteUserVCS) {
	formDeleteUserVCS.addEventListener('submit', function(e) {
		handleSubmit(e, SYSTEM_URL.VACCINATION_SCHEDULE_API_URL(),
			"DELETE", JSON.stringify(handleFormUserVCS(formDeleteUserVCS)),
			window.location.href,
			window.location.href);
	});
};
