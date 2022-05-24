import { setupModal } from "./utils/ModalUtil.js";
import { handleFormQuery } from "./utils/FormUtil.js";
import { handleSelect } from "./utils/AddressUtil.js";
import { fetchFunc } from "./utils/fetch.js";

const nuttracuu = document.querySelector(".thantrang__nuttracuu");
const feedback = document.querySelector(".thantrang__thongbao");
const form = document.querySelector('#form-userquery');


form.addEventListener('submit', (e)=> {
    e.preventDefault();
    handleFormQuery(form);
})


await fetchFunc(`https://raw.githubusercontent.com/daohoangson/dvhcvn/master/data/dvhcvn.json`).then((response) => {
   
    handleSelect(response.data, document.querySelector("#userprovince"),
    document.querySelector("#userdistrict"),
    document.querySelector("#userward"));
    setupModal();
    nuttracuu.addEventListener("click", async () => {
        document.getElementById("myModal").style.display = "block";
    });
});
