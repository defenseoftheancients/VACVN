import { formatDate } from "../util/FormatUtil.js";
import { handleSelect } from "../util/AddressUtil.js";

// const btnModals = document.querySelectorAll(".btn-modal");
const btnModals = document.querySelectorAll("[data-target]");




btnModals.forEach((btn) => {
	const modal = document.querySelector(`#${btn.dataset.target}`);
	const span = modal.getElementsByClassName("close")[0];
	span.onclick = function() {
		modal.style.display = "none";
	};
	btn.onclick = function() {
		modal.style.display = "block";
		const tableRow = btn.closest('tr');
		if (btn.dataset.target === "modalDeleteUser"
			|| btn.dataset.target === "modalUpdateUser") {
			const modalInputs = modal.querySelectorAll('input:not([type=submit]');
			const genderSelect = modal.querySelector('[id^=gender]');
			modalInputs.forEach((input, index) => {
				if (input.name === 'dob')
					input.value = formatDate(tableRow.children[index].textContent, '/', '-');
				else
					input.value = tableRow.children[index].textContent;
			});

			[].slice.call(genderSelect.children).forEach(option => {
				if (option.value === tableRow.children[3].textContent)
					option.selected = 'selected';
				else
					option.selected = '';
			});
		}
		else if (btn.dataset.target === "modalAddUser") {
			handleSelect(modal, "user");
		}
		else if (btn.dataset.target === "modalUpdateMedicalRecord"
			|| btn.dataset.target === "modalDeleteMedicalRecord") {
			if (btn.dataset.target === "modalUpdateMedicalRecord")
				handleSelect(modal, "injection");
			const STT = modal.querySelector('[id^=STT]');
			const vaccineSelector = modal.querySelector('[id^=vaccinename]');
			const injectiondate = modal.querySelector('[id^=injectiondate]');
			STT.value = tableRow.children[0].dataset.stt;
			[].slice.call(vaccineSelector.children).forEach(option => {
				if (option.textContent === tableRow.children[1].textContent)
					option.selected = 'selected';
				else
					option.selected = '';
			});
			injectiondate.value = formatDate(tableRow.children[2].textContent, '/', '-');
		}
		else if (btn.dataset.target === "modalAddMedicalrecord") {
			handleSelect(modal, "injection");
		}
		else if (btn.dataset.target === "modalUpdateVaccine"
			|| btn.dataset.target === "modalDeleteVaccine") {
			const vaccineid = modal.querySelector('[id^=vaccineid]');
			const vaccineName = modal.querySelector('[id^=vaccinename]');
			console.log(tableRow.children[1].dataset.vacineid)
			vaccineid.value = tableRow.children[1].dataset.vacineid;
			vaccineName.value = tableRow.children[1].textContent;
		}
		else if (btn.dataset.target === "modalUpdateAdmin"
			|| btn.dataset.target === "modalDeleteAdmin") {
			const modalInputs = modal.querySelectorAll('input:not([type=submit]');
			const genderSelect = modal.querySelector('[id^=gender]');
			const roleSelect = modal.querySelector('[id^=role]');
			const provinceSelect = modal.querySelector('[id^=adminprovince]');
			modalInputs.forEach((input, index) => {
				if (input.name === 'id') {
					input.value = tableRow.children[index].dataset.adminid;
				}

				else if (input.name !== 'password')
					input.value = tableRow.children[index].textContent;
			});
			[].slice.call(genderSelect.children).forEach(option => {
				if (option.value === tableRow.children[3].textContent)
					option.selected = 'selected';
				else
					option.selected = '';
			});
			handleSelect(modal, "admin");
			[].slice.call(provinceSelect.children).forEach(option => {
				if (option.id === tableRow.children[4].dataset.provincecode)
					option.selected = 'selected';
				else
					option.selected = '';
			});
			[].slice.call(roleSelect.children).forEach(option => {
				if (option.textContent === tableRow.children[5].textContent)
					option.selected = 'selected';
				else
					option.selected = '';
			});
		}
		else if (btn.dataset.target === "modalAddAdmin") {
			handleSelect(modal, "admin");
		}
		else if (btn.dataset.target === 'modalAddVCS') {
			handleSelect(modal, "vcs");
		}
		else if (btn.dataset.target === 'modalDeleteUserVCS') {
			const modalInputs = modal.querySelectorAll('input:not([type=submit]');
			modalInputs.forEach((input, index) => {
				if (input.name === 'userid')
					input.value = tableRow.children[index + 1].textContent;
			});
		}
		else if (btn.dataset.target === 'modalUpdateVCS'
			|| btn.dataset.target === 'modalDeleteVCS') {
			const id = modal.querySelector('[id^=id]');
			const vcsdate = modal.querySelector('[id^=vcsdate]');
			const amount = modal.querySelector('[id^=amount]');
			const vaccineSelector = modal.querySelector('[id^=vaccinename]');
			const statusSelector = modal.querySelector('[id^=status]')
			const daySelector = modal.querySelector('[id^=day]');
			if (btn.dataset.target === 'modalUpdateVCS') {
				handleSelect(modal, "vcs");

			}
			else {

			}
			id.value = btn.closest("tr").getAttribute("data-vaccinationscheduleid");
			[].slice.call(daySelector.children).forEach(option => {
				if (option.textContent === tableRow.children[4].textContent)
					option.selected = 'selected';
				else
					option.selected = '';
			});
			amount.value = tableRow.children[5].textContent;
			[].slice.call(statusSelector.children).forEach(option => {
				if (option.textContent === tableRow.children[3].textContent)
					option.selected = 'selected';
				else
					option.selected = '';
			});
			vcsdate.value = formatDate(tableRow.children[0].textContent, '/', '-');
			[].slice.call(vaccineSelector.children).forEach(option => {
				if (option.textContent === tableRow.children[2].textContent)
					option.selected = 'selected';
				else
					option.selected = '';
			});
		}
	};
});
