import { dataGeo } from "../handler/AddressHandler.js";
const renderOption = (data, selectELement, level) => {
  let result = "";
  data.forEach((item) => {
    result += `<option id="${item["level" + level + "_id"]}" value="${
      item.name
    }">${item.name}</option>`;
  });
  selectELement.insertAdjacentHTML("beforeend", result);
};

const clearOption = (...selectELement) => {
  selectELement.forEach((element) => {
    const firstElementChild = element.firstElementChild;
    element.innerHTML = "";
    element.append(firstElementChild);
  });
};

export const handleSelect = (modal, objectName) => {
  const provinceSelect = modal.querySelector(`[id^=${objectName}province]`),
    districtSelect = modal.querySelector(`[id^=${objectName}district]`),
    wardSelect = modal.querySelector(`[id^=${objectName}ward`);
  let provinceData = null,
    districtData = null;
  clearOption(provinceSelect);
  renderOption(dataGeo, provinceSelect, 1);

  if (districtSelect && wardSelect) {
    provinceSelect.addEventListener("change", (event) => {
      clearOption(districtSelect, wardSelect);
      if (dataGeo[event.target.selectedIndex - 1]) {
        provinceData = dataGeo[event.target.selectedIndex - 1].level2s;
        renderOption(provinceData, districtSelect, 2);
      }
    });
    districtSelect.addEventListener("change", (event) => {
      clearOption(wardSelect);
      if (provinceData[event.target.selectedIndex - 1]) {
        districtData = provinceData[event.target.selectedIndex - 1].level3s;
        renderOption(districtData, wardSelect, 3);
      }
    });
  }
};
