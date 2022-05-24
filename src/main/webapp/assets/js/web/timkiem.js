import { getData, fetchFunc} from "./utils/fetch.js";
import { handleSelect } from "./utils/AddressUtil.js"; 
import { SYSTEM_URL } from "../common/SYSTEM_URL.js";
import { setupModal } from "./utils/ModalUtil.js";
import { handleFormRegistry } from "./utils/FormUtil.js";
import {createVaccinationSchedulesTableSearch} from  "./utils/TableUtil.js";
let tr = null;
const modal = document.getElementById("myModal");
const ntim = document.querySelector('.ntim');
const form = document.querySelector('#form-adduserregistry');
const feedback = form.querySelector('.feedback');


const searchVaccinationSchedule = async () => {
    const result = document.querySelector('.thantrang__ketqua');
    result.innerHTML = "";
    const provinceSelect = document.querySelector("#provinceSelect");
    const districtSelect = document.querySelector("#districtSelect");
    const wardSelect = document.querySelector("#wardSelect");
    let address = "";
    address += provinceSelect.selectedIndex !== 0 ? provinceSelect.options[provinceSelect.selectedIndex].textContent : "";
    address += districtSelect.selectedIndex !== 0 ? ", " + districtSelect.options[districtSelect.selectedIndex].textContent : "";
    address += wardSelect.selectedIndex !== 0 ? ", " + wardSelect.options[wardSelect.selectedIndex].textContent : "";
    console.log(address);
    
    const response = await getData(SYSTEM_URL.VACCINATION_SCHEDULE_API_URL(address));
    console.log(response);
    if(response.status === 200) {
        
        if(response.data.length > 0) {
            result.insertAdjacentHTML('beforeend', createVaccinationSchedulesTableSearch(response.data));
            document.querySelectorAll('.myBtn').forEach(btn=> {
                btn.addEventListener('click', ()=> {
                    modal.style.display = "block";
                    tr = btn.closest('tr');
                    feedback.textContent = "";
                })
            })
        }
        else {
            result.insertAdjacentHTML('beforeend', "<p style=\"text-align:center\">Không có lịch tiêm nào!</p>");
        }   
        
       
    }
    else if(response.status === 404) {

    }
}
form.addEventListener('submit', (e)=> {
    e.preventDefault();
    console.log(tr);
    handleFormRegistry(tr, form, SYSTEM_URL.VACCINATION_SCHEDULE_REGISTRY_API_URL);

})

await fetchFunc(`https://raw.githubusercontent.com/daohoangson/dvhcvn/master/data/dvhcvn.json`).then((response) => {
    handleSelect(response.data,document.querySelector("#provinceSelect"),
    document.querySelector("#districtSelect"),
    document.querySelector("#wardSelect"));
    handleSelect(response.data, document.querySelector("#userprovince"),
    document.querySelector("#userdistrict"),
    document.querySelector("#userward"));
    setupModal();
    ntim.addEventListener('click', searchVaccinationSchedule)
});




