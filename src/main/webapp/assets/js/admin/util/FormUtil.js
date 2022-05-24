import { formatDate } from "../util/FormatUtil.js";
import { getUrlVars } from "./JsonUtil.js";

const handleSelectAddressForm = (form, objectName) => {
    const provinceSelect = form.querySelector(`[id^=${objectName}province]`),
    districtSelect = form.querySelector(`[id^=${objectName}district]`),
    wardSelect = form.querySelector(`[id^=${objectName}ward]`);
    return [provinceSelect.value, districtSelect.value, wardSelect.value].join(', ');
}

export const handleFormUser = (form, handleSelectAddress, objectName) => {
    const object = {};
    const inputs = form.querySelectorAll('input:not([type=submit]');
    const genderSelect = form.querySelector('[id^=gender]');
    inputs.forEach(input=> {
        if(input.name === 'dob')
            object[input.name] = formatDate(input.value, '-', '/');
         else
            object[input.name] = input.value;
    });
    object[genderSelect.name] = genderSelect.value;
    if(handleSelectAddress) {
        object['address'] =  handleSelectAddressForm(form, objectName); 
        const provinceSelect = form.querySelector(`[id^=${objectName}province]`);
        object['provinceCode'] =  provinceSelect.options[provinceSelect.selectedIndex ].id.toString();
    }
    console.log(object);
    return object;
}

export const handleFormVaccine = (form) => {
    const object = {};
    const inputs = form.querySelectorAll('input:not([type=submit]');
    inputs.forEach(input=> {object[input.name] = input.value;});
    console.log(object);
    return object;
}

export const handleFormMedicalRecord = (form, handleSelectAddress, objectName) => {
    const object = {};
    const inputs = form.querySelectorAll('input:not([type=submit]');
    console.log(inputs);
    const vaccineSelect = form.querySelector('[id^=vaccinename]');
    const admin = document.querySelector("[data-adminid]");
    
    inputs.forEach(input=> {
        if(input.name === `${objectName}date`)
            object[input.name] = formatDate(input.value, '-', '/');
        else
         object[input.name] = input.value;
    });
    object['vaccine'] = {
        'id':parseInt( vaccineSelect.value), 
        'vaccineName':vaccineSelect.options[vaccineSelect.selectedIndex].textContent
    };
    object['adminid'] = parseInt(admin.dataset.adminid);
    object['userid'] =  getUrlVars()["id"];
    if(handleSelectAddress && handleSelectAddressForm(form, objectName) !== ", , ") 
        object['address'] =  handleSelectAddressForm(form, objectName); 
    console.log(object);
    return object;
}
export const handleFormAdmin = (form, objectName) => {
    const object = {};
    const inputs = form.querySelectorAll('input:not([type=submit]');
    const roleSelect = form.querySelector('[id^=role]');
    const provinceSelect = form.querySelector(`[id^=${objectName}province]`);
    const genderSelect = form.querySelector('[id^=gender]');
    
    inputs.forEach(input=> {
        if(input.name === 'password' && input.value !== '')
            object[input.name] = input.value;
        else
            object[input.name] = input.value;
    });
    object['role'] = {
        'id': parseInt(roleSelect.value), 
        'rolename': roleSelect.options[roleSelect.selectedIndex].textContent
    };
    object[genderSelect.name] = genderSelect.value;
    object['provinceCode'] =  provinceSelect.options[provinceSelect.selectedIndex].id.toString();
    console.log(object);
    return object;
}
export const handleFormVaccinationSchedule = (form, handleSelectAddress, objectName) => {
    const object = {};
    const inputs = form.querySelectorAll('input:not([type=submit]');
    const vaccineSelect = form.querySelector('[id^=vaccinename]');
    const statusSelect = form.querySelector('[id^=status]');
    const daySelect = form.querySelector('[id^=day]');
    const admin = document.querySelector("[data-adminid]");
  
    inputs.forEach(input=> {
        console.log(input.value);
        if(input.name === `${objectName}date`)
            object[input.name] = formatDate(input.value, '-', '/');
        else if(input.type === 'number') 
            object[input.name] = parseInt(input.value);
        else
            object[input.name] = input.value;
    });
    object['day'] = daySelect.options[daySelect.selectedIndex].textContent;
    object['vaccine'] = {
        'id': parseInt(vaccineSelect.value), 
        'vaccineName':vaccineSelect.options[vaccineSelect.selectedIndex].textContent
    };
    object['adminid'] = parseInt(admin.dataset.adminid);
    object['status'] = statusSelect.value;
  /*  if(form.id.includes('update') || form.id.includes('delete'))
        object['id'] =  getUrlVars()["id"];*/
    if(handleSelectAddress && handleSelectAddressForm(form, objectName) !== ", , ") 
        object['address'] =  handleSelectAddressForm(form, objectName); 
    console.log(object);
    return object;
}
export const handleFormUserVCS = (form, handleSelectAddress, objectName) => {
    const object = {};
    const inputs = form.querySelectorAll('input:not([type=submit]');
    inputs.forEach(input=> {
        object[input.name] = input.value;
    });
    object['vaccinationscheduleid'] =  getUrlVars()["id"];
    console.log(object);
    return object;
}