<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/base.jspf"%>


<head>
<title>${user.id}</title>
<link rel="stylesheet"
	href="<c:url value="/assets/css/admin/content.css" />" />
</head>
<body>
	<div class="content">
		<div id="modalAddMedicalrecord" class="modal">
			<!-- Modal content -->
			<div class="modal-box">
				<span class="close">&times;</span>
				<div class="modal-content">
					<h3 class="modal-heading">Thêm lịch sử tiêm chủng</h3>
					<form action="#" id="form-addmedicalrecord">
						<div class="form-group">
							<label for="vaccinename-add">Tên thuốc <span>*</span></label> <select
								class="form-control" name="vaccinename" id="vaccinename-add">
								<option value="" selected>--- Chọn tên thuốc ---</option>
								<c:forEach var="vaccine" items="${vaccines}">
									<option value="${vaccine.id}">${vaccine.vaccineName}</option>
								</c:forEach>
							</select>

						</div>
						<div class="form-group">
							<label for="injectiondate-add">Ngày tiêm<span>*</span></label> <input
								class="form-control" type="date" id="injectiondate-add"
								name="injectiondate" />
						</div>

						<div class="form-group">
							<label for="injectionprovince-add">Tỉnh / Thành phố <span>*</span></label>
							<select class="form-control" name="injectionprovince"
								id="injectionprovince-add">
								<option value="" selected>--- Chọn tỉnh/thành phố ---</option>
							</select>
						</div>
						<div class="form-group">
							<label for="injectiondistrict-add">Quận / Huyện <span>*</span></label>
							<select class="form-control" name="injectiondistrict"
								id="injectiondistrict-add">
								<option value="" selected>--- Chọn quận/huyện ---</option>
							</select>
						</div>
						<div class="form-group">
							<label for="injectionward-add">Phường / Xã <span>*</span></label>
							<select class="form-control" name="injectionward"
								id="injectionward-add">
								<option value="" selected>--- Chọn phường/xã ---</option>
							</select>
						</div>
						<input type="submit" value="Thêm mới" />
					</form>
				</div>
			</div>
		</div>
		<div class="content-cards">
			<!-- <div
              class="content-card"
              data-target="modalAddUser"
              id="cardadduser"
            >
              <div class="content-cardleft">
                <p>Thêm mới</p>
              </div>
              <div class="content-cardright">
                <i class="fa-solid fa-plus"></i>
              </div>
            </div> -->
			<!-- <div class="content-card" data-target="modalUpdateUser" id="cardupdateuser" >
              <div class="content-cardleft">
                <p>Sửa người dùng</p>
              </div>
              <div class="content-cardright">
                <i class="fa-solid fa-plus"></i>
              </div>
            </div> -->
			<div class="content-card" data-target="modalAddMedicalrecord"
				id="cardupdatemedicalrecord">
				<div class="content-cardleft">
					<p>Thêm tiêm chủng</p>
				</div>
				<div class="content-cardright">
					<i class="fa-solid fa-plus"></i>
				</div>
			</div>
		</div>
		<c:if test="${admin.role.id == 1}">

			<div id="modalUpdateUser" class="modal">
				<!-- Modal content -->
				<div class="modal-box">
					<span class="close">&times;</span>
					<div class="modal-content">
						<h3 class="modal-heading">Cập nhật người dùng</h3>
						<form action="#" id="form-updateuser">
							<div class="form-group">
								<label for="userid-update">Căn cước công dân <span>*</span></label>
								<input class="form-control" type="text"
									placeholder="Nhập căn cước công dân" id="userid-update"
									name="id" disabled>
							</div>
							<div class="form-group">
								<label for="fullname-update">Họ và tên <span>*</span></label> <input
									class="form-control" type="text" placeholder="Nhập họ và tên"
									id="fullname-update" name="fullName">
							</div>
							<div class="form-group">
								<label for="dob-update">Ngày sinh <span>*</span></label> <input
									class="form-control" type="date" id="dob-update" name="dob">
							</div>
							<div class="form-group">
								<label for="gender-update">Giới tính <span>*</span></label> <select
									class="form-control" name="gender" id="gender-update">
									<option value="" selected>--- Chọn giới tính ---</option>
									<option value="Nam">Nam</option>
									<option value="Nữ">Nữ</option>
								</select>
							</div>
							<!-- <div class="form-group">
                    <label for="userprovince">Tỉnh / Thành phố <span>*</span></label>
                    <select class="form-control" name="userprovince"
                      id="userprovince">
                      <option value="" selected>--- Chọn tỉnh/thành phố ---</option>
                    </select>
                  </div>
                  <div class="form-group">
                    <label for="userdistrict">Quận / Huyện <span>*</span></label> <select
                      class="form-control" name="userdistrict" id="userdistrict">
                      <option value="" selected>--- Chọn quận/huyện ---</option>
                    </select>
                  </div>
                  <div class="form-group">
                    <label for="userward">Phường / Xã <span>*</span></label> <select
                      class="form-control" name="userward" id="userward">
                      <option value="" selected>--- Chọn phường/xã ---</option>
                    </select>
                  </div> -->

							<input type="submit" value="Cập nhật">
						</form>
					</div>
				</div>
			</div>
			<div id="modalDeleteUser" class="modal">
				<div class="modal-box">
					<span class="close">&times;</span>
					<div class="modal-content">
						<h3 class="modal-heading">Xóa người dùng</h3>
						<form action="#" id="form-deleteuser">
							<div class="form-group">
								<label for="userid-delete">Căn cước công dân <span>*</span></label>
								<input class="form-control" type="text"
									placeholder="Nhập căn cước công dân" id="userid-delete"
									name="id" disabled>
							</div>
							<div class="form-group">
								<label for="fullname-delete">Họ và tên <span>*</span></label> <input
									class="form-control" type="text" placeholder="Nhập họ và tên"
									id="fullname-delete" name="fullName" disabled>
							</div>
							<div class="form-group">
								<label for="dob-delete">Ngày sinh <span>*</span></label> <input
									class="form-control" type="date" id="dob-delete" name="dob"
									disabled>
							</div>
							<div class="form-group">
								<label for="gender-delete">Giới tính <span>*</span></label> <select
									class="form-control" name="gender" id="gender-delete" disabled>
									<option value="" selected>--- Chọn giới tính ---</option>
									<option value="Nam">Nam</option>
									<option value="Nữ">Nữ</option>
								</select>
							</div>
							<input type="submit" value="Xóa">
						</form>
					</div>
				</div>
			</div>
		</c:if>

		<div class="content-table">
			<h3 class="content-headingtable">Người dùng</h3>
			<div class="content-tablerows">
				<table>
					<thead>
						<tr role="row">
							<th scope="col">Căn cước công dân</th>
							<th scope="col">Họ và tên</th>
							<th scope="col">Ngày sinh</th>
							<th scope="col">Giới tính</th>
							<th scope="col">Quê quán</th>

							<c:if test="${admin.role.id == 1}">
								<th scope="col">Sửa đổi</th>
								<th scope="col">Xóa</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${user.id}</td>
							<td>${user.fullName}</td>
							<td>${user.dob}</td>
							<td>${user.gender}</td>
							<td class="content-tableaddress">${user.address}</td>
							<c:if test="${admin.role.id == 1}">
								<td><i class="fa-solid fa-pen-to-square"
									data-target="modalUpdateUser"></i></td>
								<td><i class="fa-solid fa-trash btn-modal"
									data-target="modalDeleteUser"></i></td>
							</c:if>

						</tr>
					</tbody>
					<tfoot>
						<tr role="row">
							<th scope="col">Căn cước công dân</th>
							<th scope="col">Họ và tên</th>
							<th scope="col">Ngày sinh</th>
							<th scope="col">Quê quán</th>
							<th scope="col">Giới tính</th>
							<c:if test="${admin.role.id == 1}">
								<th scope="col">Sửa đổi</th>
								<th scope="col">Xóa</th>
							</c:if>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
		<div id="modalUpdateMedicalRecord" class="modal">
			<div class="modal-box">
				<span class="close">&times;</span>
				<div class="modal-content">
					<h3 class="modal-heading">Cập nhật tiêm chủng</h3>
					<form action="#" id="form-updatemedicalrecord">
						<input type="hidden" id="STT-update" name="STT" />
						<div class="form-group">
							<label for="vaccinename-update">Tên thuốc <span>*</span></label>
							<select class="form-control" name="vaccinename"
								id="vaccinename-update">
								<option value="" selected>--- Chọn tên thuốc ---</option>
								<c:forEach var="vaccine" items="${vaccines}">
									<option value="${vaccine.id}">${vaccine.vaccineName}</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group">
							<label for="injectiondate-update">Ngày tiêm<span>*</span></label>
							<input class="form-control" type="date" id="injectiondate-update"
								name="injectiondate" />
						</div>
						<div class="form-group">
							<label for="injectionprovince-update">Tỉnh / Thành phố <span>*</span></label>
							<select class="form-control" name=""
								id="injectionprovince-update">
								<option value="" selected>--- Chọn tỉnh/thành phố ---</option>
							</select>
						</div>
						<div class="form-group">
							<label for="injectiondistrict-update">Quận / Huyện <span>*</span></label>
							<select class="form-control" name=""
								id="injectiondistrict-update">
								<option value="" selected>--- Chọn quận/huyện ---</option>
							</select>
						</div>
						<div class="form-group">
							<label for="injectionward-update">Phường / Xã <span>*</span></label>
							<select class="form-control" name="" id="injectionward-update">
								<option value="" selected>--- Chọn phường/xã ---</option>
							</select>
						</div>
						<input type="submit" value="Cập nhật" />
					</form>
				</div>
			</div>
		</div>
		<div id="modalDeleteMedicalRecord" class="modal">
			<div class="modal-box">
				<span class="close">&times;</span>
				<div class="modal-content">
					<h3 class="modal-heading">Xóa lịch sử tiêm chủng</h3>
					<form action="#" id="form-deletemedicalrecord">
						<input type="hidden" id="STT-delete" name="STT" />
						<div class="form-group">
							<label for="vaccinename-delete">Tên thuốc <span>*</span></label>
							<select class="form-control" name="vaccinename"
								id="vaccinename-delete">
								<option value="" selected>--- Chọn tên thuốc ---</option>
								<c:forEach var="vaccine" items="${vaccines}">
									<option value="${vaccine.id}">${vaccine.vaccineName}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label for="injectiondate-delete">Ngày tiêm<span>*</span></label>
							<input class="form-control" type="date"
								id="injectiondate-deletee" name="injectiondate" />
						</div>
						<input type="submit" value="Xóa" />
					</form>
				</div>
			</div>
		</div>
		<div class="content-table">
			<h3 class="content-headingtable">Lịch sử tiêm chủng</h3>
			<div class="content-tablerows">
				<table>
					<thead>
						<tr role="row">
							<th scope="col">STT</th>
							<th scope="col">Tên thuốc</th>
							<th scope="col">Ngày tiêm</th>
							<th scope="col">Nơi tiêm</th>

							<th scope="col">Sửa đổi</th>
							<th scope="col">Xóa</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="medicalrecord" items="${user.medicalRecords}"
							varStatus="loop">
							<tr>
								<td data-stt="${medicalrecord.STT}">${loop.index+1}</td>
								<td>${medicalrecord.vaccine.vaccineName}</td>
								<td>${medicalrecord.date}</td>
								<td class="content-tableaddress">${medicalrecord.address}</td>
								<td><i class="fa-solid fa-pen-to-square"
									data-target="modalUpdateMedicalRecord"></i></td>
								<td><i class="fa-solid fa-trash btn-modal"
									data-target="modalDeleteMedicalRecord"></i></td>

							</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr role="row">
							<th scope="col">STT</th>
							<th scope="col">Tên thuốc</th>
							<th scope="col">Nơi tiêm</th>
							<th scope="col">Ngày tiêm</th>
							<th scope="col">Sửa đổi</th>
							<th scope="col">Xóa</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
	</div>
	<script type="module"
		src="<c:url value="/assets/js/admin/content.js" />"> </script>
</body>
