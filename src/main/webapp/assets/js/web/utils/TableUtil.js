export const createUserTable = (data) => {
    const [province, district, ward] = data.address.split(", ");
    const userTable = `
    <div class="bang">
        <h3 class="bang__tieude">Thông tin cá nhân</h3>
        <div class="bang__noidung">
            <table>
                <tr>
                    <th>Họ và tên</th>
                    <th>Ngày sinh</th>
                    <th>Giới tính</th>
                    <th>Quê quán</th>
                    
                </tr>
                <tbody>
                    <tr>
                        <td>${data.fullName}</td>
                        <td>${data.dob}</td>
                        <td>${data.gender}</td>
                        <td class="bang__diachi">
                            <span>${province}</span>, <span>${district}</span>, <span>${ward}</span>
                        </td>
                    
                    </tr>
                </tbody>
            </table>
        </div>
    </div>`;
    return userTable;
};

export const createMedicalRecordsTable = (data) => {
    const tableRows = data
        .map((medicalrecord, index) => {
            const [province, district, ward] = medicalrecord.address.split(", ");
            const tableRow = ` <tr>
                        <td>${index + 1}</td>
                        <td>${medicalrecord.vaccine.vaccineName}</td>
                        <td>${medicalrecord.date}</td>
                        <td class="bang__diachi">
                            <span>${province}</span>, <span>${district}</span>, <span>${ward}</span>
                        </td>
                    </tr>`;
            return tableRow;
        })
        .join("\n");
    const medicalRecordsTable = `
    <div class="bang">
        <h3 class="bang__tieude">Lịch sử tiêm chủng</h3>
        <div class="bang__noidung">
            <table>
                <tr>
                    <th>STT</th>
                    <th>Tên thuốc</th>
                    <th>Ngày tiêm</th>
                    <th>Nơi tiêm</th>
                
                </tr>
                <tbody>
                   ${tableRows}
                </tbody>
            </table>
        </div>
    </div>`;
    return medicalRecordsTable;
};

export const createVaccinationSchedulesTable = (data) => {
    const tableRows = data
        .map((vaccinationSchedule, index) => {
         
            const [province, district, ward] = vaccinationSchedule.address.split(", ");
            const tableRow = ` <tr>
                        <td>${index + 1}</td>
                        <td>${vaccinationSchedule.vcsdate}</td>
                        <td>${vaccinationSchedule.day}</td>
                        <td class="bang__diachi">
                            <span>${province}</span>, <span>${district}</span>, <span>${ward}</span>
                        </td>
                        <td>${vaccinationSchedule.vaccine.vaccineName}</td>    
                    </tr>`;
            return tableRow;
        })
        .join("\n");
    const vaccinationSchedulesTable = `
    <div class="bang">
        <h3 class="bang__tieude">Lịch tiêm</h3>
        <div class="bang__noidung">
            <table>
                <tr>
                    <th>STT</th>
                    <th>Ngày tiêm</th>
                    <th>Buổi tiêm</th>
                    <th>Nơi tiêm</th>
                    <th>Tên thuốc</th>
                </tr>
                <tbody>
                    ${tableRows}       
                </tbody>
            </table>
        </div>
    </div>`;
    return vaccinationSchedulesTable;
};
export const createVaccinationSchedulesTableSearch = (data) => {
    const tableRows = data
        .map((vaccinationSchedule, index) => {
         
            const [province, district, ward] = vaccinationSchedule.address.split(", ");
            const tableRow = ` <tr>
                        <td data-id="${vaccinationSchedule.id}">${index + 1}</td>
                        <td>${vaccinationSchedule.vcsdate}</td>
                        <td>${vaccinationSchedule.day}</td>
                        <td class="bang__diachi">
                            <span>${province}</span>, <span>${district}</span>, <span>${ward}</span>
                        </td>
                        <td>${vaccinationSchedule.vaccine.vaccineName}</td>  
                        <td class="bang__dangky"><i class="fa-solid fa-pen-clip myBtn"></i></td>  
                    </tr>`;
            return tableRow;
        })
        .join("\n");
    const vaccinationSchedulesTable = `
    <div class="bang">
        <h3 class="bang__tieude">Lịch tiêm</h3>
        <div class="bang__noidung">
            <table>
                <tr>
                    <th>STT</th>
                    <th>Ngày tiêm</th>
                    <th>Buổi tiêm</th>
                    <th>Nơi tiêm</th>
                    <th>Tên thuốc</th>
                    <th>Đăng ký</th>
                </tr>
                <tbody>
                    ${tableRows}       
                </tbody>
            </table>
        </div>
    </div>`;
    return vaccinationSchedulesTable;
};