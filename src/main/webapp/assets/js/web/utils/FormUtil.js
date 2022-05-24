import { getData, postData } from "./fetch.js";
import { formatDate } from "./FormatUtil.js";
import { SYSTEM_URL } from "../../common/SYSTEM_URL.js";
import {createUserTable, createMedicalRecordsTable, createVaccinationSchedulesTable} from "./TableUtil.js";
const handleFormUser = (form) => {
    const user = {};
    const inputs = form.querySelectorAll("input:not([type=submit]");
    const provinceSelect = form.querySelector("#userprovince");
    const districtSelect = form.querySelector("#userdistrict");
    const wardSelect = form.querySelector("#userward");
    const gender = form.querySelector("#gender");
    inputs.forEach((input) => {
        if (input.name === "dob") user[input.name] = formatDate(input.value, "-", "/");
        else user[input.name] = input.value;
    });
    const address =
        provinceSelect.options[provinceSelect.selectedIndex].textContent +
        ", " +
        districtSelect.options[districtSelect.selectedIndex].textContent +
        ", " +
        wardSelect.options[wardSelect.selectedIndex].textContent;
    user["address"] = address;
    user["gender"] = gender.options[gender.selectedIndex].textContent;
    return user;
};

const renderResult = async (data) => {
    const result = document.querySelector(".thantrang__ketqua");
    console.log(data);
    result.insertAdjacentHTML("beforeend", createUserTable(data));
    result.insertAdjacentHTML("beforeend", createMedicalRecordsTable(data.medicalRecords));
    result.insertAdjacentHTML("beforeend", createVaccinationSchedulesTable(data.vaccinationSchedules));
};

export const handleFormRegistry = async (tr, form, url) => {
    const feedback = form.querySelector('.feedback');
    const object = {};
    const user = handleFormUser(form);
    object["vaccinationScheduleId"] = tr.firstElementChild.getAttribute("data-id")
   
    object["user"] = user;
    console.log(object);
    const response = await postData(url, JSON.stringify(object));
    if (response.status === 200) {
        feedback.textContent = response.data;
        console.log(feedback);
        console.log(response.data);
    } else if (response.status === 404) {
        feedback.textContent = "Thông tin không hợp lệ!";
    }
};

const showError = (message) => {
    const feedback = form.querySelector('.feedback');
    feedback.textContent = message;
};
export const handleFormQuery = async (form) => {
    const user = handleFormUser(form);
    console.log(user);
    const response = await getData(SYSTEM_URL.USER_API_URL(encodeURIComponent(JSON.stringify(user))));
    console.log(SYSTEM_URL.USER_API_URL(encodeURIComponent(JSON.stringify(user))));
    console.log(response);
    if (response.status === 200) {
        renderResult(response.data);
        document.getElementById("myModal").style.display = "none";
    } else if (response.status === 404) {
        showError("Thông tin không hợp lệ!");
    }
};
