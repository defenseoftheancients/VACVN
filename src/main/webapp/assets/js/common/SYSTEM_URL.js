export const SYSTEM_URL = {
	USER_ADMIN_URL: `https://localhost:8443/vacvn/admin/user`,
	VACCINE_ADMIN_URL: `https://localhost:8443/vacvn/admin/vaccine`,
	VACCINATION_SCHEDULE_ADMIN_URL: `https://localhost:8443/vacvn/admin/vaccinationschedule`,

	VACCINE_API_URL: `https://localhost:8443/vacvn/api/vaccines`,
	MEDICAL_RECORDS_API_URL: `https://localhost:8443/vacvn/api/medicalrecords`,
	ADMIN_API_URL: `https://localhost:8443/vacvn/api/admins`,
	USER_API_URL: (id = null) => {
        return id === null ? `https://localhost:8443/vacvn/api/users` : 
        `https://localhost:8443/vacvn/api/users?id=${id}`;
    },
    VACCINATION_SCHEDULE_API_URL: (address = null) => {
        return address === null ? `https://localhost:8443/vacvn/api/vaccinationschedules`:
        `https://localhost:8443/vacvn/api/vaccinationschedules?address=${address}`;
    },
    VACCINATION_SCHEDULE_REGISTRY_API_URL: `http://localhost:8080/vacvn/api/vaccinationschedules/registry`

}