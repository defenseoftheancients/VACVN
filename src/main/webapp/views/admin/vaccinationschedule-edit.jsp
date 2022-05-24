<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/base.jspf"%>

<head>

<title>Lịch tiêm ${vaccinationschedule.id}</title>
<link rel="stylesheet"
	href="<c:url value="/assets/css/admin/content.css" />" />
</head>
<body>
	<div class="content">
		<div id="modalAddUserVCS" class="modal">
			<!-- Modal content -->
			<div class="modal-box">
				<span class="close">&times;</span>
				<div class="modal-content">
					<h3 class="modal-heading">Thêm người đăng ký</h3>
					<form action="#" id="form-adduservcs">
						<div class="form-group">
							<label for="userid-add">Căn cước công dân <span>*</span>
							</label> <input class="form-control" type="text"
								placeholder="Nhập căn cước công dân" id="userid-add"
								name="userid" />
						</div>

						<input type="submit" value="Thêm" />
					</form>
				</div>
			</div>
		</div>
		<div class="content-cards">
			<div class="content-card" data-target="modalAddUserVCS"
				id="cardadduservcs">
				<div class="content-cardleft">
					<p>Thêm mới</p>
				</div>
				<div class="content-cardright">
					<i class="fa-solid fa-plus"></i>
				</div>
			</div>
			<!-- <div class="content-card">
              <div class="content-cardleft">
                <p>Thêm mới</p>
              </div>
              <div class="content-cardright">
                <i class="fa-solid fa-plus"></i>
              </div>
            </div>
            <div class="content-card">
              <div class="content-cardleft">
                <p>Thêm mới</p>
              </div>
              <div class="content-cardright">
                <i class="fa-solid fa-plus"></i>
              </div>
            </div> -->
		</div>
		<div id="modalUpdateVCS" class="modal">
			<div class="modal-box">
				<span class="close">&times;</span>
				<div class="modal-content">
					<h3 class="modal-heading">Cập nhật tiêm chủng</h3>
					<form action="#" id="form-updatevcs">
					<input type="hidden" id="id-delete"
								name="id" />
						<!-- <div class="form-group">
							<label for="id-update">ID <span>*</span></label> <input
								class="form-control" type="text" id="id-update" name="id" />
						</div> -->
						<div class="form-group">
							<label for="vaccinename-update">Tên thuốc <span>*</span>
							</label> <select class="form-control" name="vaccinename"
								id="vaccinename-update">
								<option value="" selected>--- Chọn tên thuốc ---</option>
								<c:forEach var="vaccine" items="${vaccines}">
									<option value="${vaccine.id}">${vaccine.vaccineName}</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group">
							<label for="date-update">Ngày tiêm <span>*</span></label> <input
								class="form-control" type="date" id="vcsdate-update"
								name="vcsdate" />
						</div>
						<div class="form-group">
							<label for="amount-update">Số lượng tối đa <span>*</span>
							</label> <input class="form-control" type="number" id="amount-update"
								name="amount" min="1" value="50" max="2000" />
						</div>
						<div class="form-group">
							<label for="day-update">Buổi tiêm <span>*</span></label> <select
								class="form-control" name="day" id="day-update">
								<option value="" selected>--- Chọn buổi tiêm ---</option>
								<option value="Cả ngày">Cả ngày</option>
								<option value="Buổi sáng">Buổi sáng</option>
								<option value="Buổi chiều">Buổi chiều</option>
								<option value="Buổi tối">Buổi tối</option>
							</select>
						</div>
						<div class="form-group">
							<label for="status-update">Trạng thái <span>*</span></label> <select
								class="form-control" name="status" id="status-update">
								<option value="" selected>--- Chọn trạng thái ---</option>
								<option value="true">Công khai</option>
								<option value="false">Riêng tư</option>
							</select>
						</div>
						<div class="form-group">
							<label for="vcsprovince-update">Tỉnh / Thành phố <span>*</span>
							</label> <select class="form-control" name="vcsprovince"
								id="vcsprovince-update">
								<option value="" selected>--- Chọn tỉnh/thành phố ---</option>
							</select>
						</div>
						<div class="form-group">
							<label for="vcsdistrict-update">Quận / Huyện <span>*</span>
							</label> <select class="form-control" name="vcsdistrict"
								id="vcsdistrict-update">
								<option value="" selected>--- Chọn quận/huyện ---</option>
							</select>
						</div>
						<div class="form-group">
							<label for="vcsward-update">Phường / Xã <span>*</span></label> <select
								class="form-control" name="vcsward" id="vcsward-update">
								<option value="" selected>--- Chọn phường/xã ---</option>
							</select>
						</div>
						<input type="submit" value="Cập nhật" />
					</form>
				</div>
			</div>
		</div>
		<div id="modalDeleteVCS" class="modal">
			<div class="modal-box">
				<span class="close">&times;</span>
				<div class="modal-content">
					<h3 class="modal-heading">Xóa lịch tiêm chủng</h3>
					<form action="#" id="form-deletevcs">
					<input type="hidden" id="id-delete"
								name="id" />
						<!-- <div class="form-group">
							<label for="id-delete">ID <span>*</span></label> <input
								class="form-control" type="text" id="id-delete" name="id" />
						</div> -->
						<div class="form-group">
							<label for="vaccinename-delete">Tên thuốc <span>*</span>
							</label> <select class="form-control" name="vaccinename"
								id="vaccinename-delete">
								<option value="" selected>--- Chọn tên thuốc ---</option>
								<c:forEach var="vaccine" items="${vaccines}">
									<option value="${vaccine.id}">${vaccine.vaccineName}</option>
								</c:forEach>
							</select>
						</div>

						<div class="form-group">
							<label for="date-delete">Ngày tiêm <span>*</span></label> <input
								class="form-control" type="date" id="vcsdate-delete"
								name="vcsdate" />
						</div>
						<div class="form-group">
							<label for="amount-delete">Số lượng tối đa <span>*</span>
							</label> <input class="form-control" type="number" id="amount-delete"
								name="amount" min="50" value="50" max="2000" />
						</div>
						<div class="form-group">
							<label for="status-delete">Trạng thái <span>*</span></label> <select
								class="form-control" name="status" id="status-delete">
								<option value="" selected>--- Chọn trạng thái ---</option>
								<option value="true">Công khai</option>
								<option value="false">Riêng tư</option>
							</select>
						</div>
						<div class="form-group">
							<label for="day-delete">Buổi tiêm <span>*</span></label> <select
								class="form-control" name="day" id="day-delete">
								<option value="" selected>--- Chọn buổi tiêm ---</option>
								<option value="Cả ngày">Cả ngày</option>
								<option value="Buổi sáng">Buổi sáng</option>
								<option value="Buổi chiều">Buổi chiều</option>
								<option value="Buổi tối">Buổi tối</option>
							</select>
						</div>
						<input type="submit" value="Xóa" />
					</form>
				</div>
			</div>
		</div>
		<div class="content-table">
			<h3 class="content-headingtable">Lịch tiêm</h3>
			<div class="content-tablerows">
				<table>
					<thead>
						<tr role="row">
							<th scope="col">Ngày tiêm</th>
							<th scope="col">Địa chỉ</th>
							<th scope="col">Tên thuốc</th>
							<th scope="col">Trạng thái</th>
							<th scope="col">Buổi tiêm</th>
							<th scope="col">Số lượng tối đa</th>
							<th scope="col">Số lượng hiện tại</th>

							<th scope="col">Sửa đổi</th>
							<th scope="col">Xóa</th>
						</tr>
					</thead>
					<tbody>
						<tr data-vaccinationscheduleid="${vaccinationschedule.id}">
							<td>${vaccinationschedule.date}</td>
							<td class="content-tableaddress">${vaccinationschedule.address}</td>
							<td>${vaccinationschedule.vaccine.vaccineName}</td>

							<td>${vaccinationschedule.status ? "Công khai" : "Riêng tư"}</td>
							<td>${vaccinationschedule.day}</td>
							<td>${vaccinationschedule.amount}</td>
							<td>${fn:length(vaccinationschedule.users)}</td>

							<td><i class="fa-solid fa-pen-to-square"
								data-target="modalUpdateVCS"></i></td>
							<td><i class="fa-solid fa-trash btn-modal"
								data-target="modalDeleteVCS"></i></td>
						</tr>
					</tbody>
					<tfoot>
						<tr role="row">
							<th scope="col">Ngày tiêm</th>
							<th scope="col">Địa chỉ</th>
							<th scope="col">Tên thuốc</th>
							<th scope="col">Trạng thái</th>
							<th scope="col">Buổi tiêm</th>
							<th scope="col">Số lượng tối đa</th>
							<th scope="col">Số lượng hiện tại</th>

							<th scope="col">Sửa đổi</th>
							<th scope="col">Xóa</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
		<div class="content-table">
			<h3 class="content-headingtable">Người đã đăng ký</h3>
			<div class="content-tablerows">
				<table>
					<thead>
						<tr role="row">
							<th scope="col">STT</th>
							<th scope="col">Căn cước công dân</th>
							<th scope="col">Họ và tên</th>
							<th scope="col">Ngày sinh</th>
							<th scope="col">Giới tính</th>
							<th scope="col">Quê quán</th>

							<th scope="col" style="display: none"></th>
							<th scope="col">Xóa</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="user" items="${vaccinationschedule.users}"
							varStatus="loop">
							<tr>
								<td>${loop.index+1}</td>
								<td>${user.id}</td>
								<td>${user.fullName}</td>
								<td>${user.dob}</td>
								<td>${user.gender}</td>
								<td class="content-tableaddress">${user.address}</td>
								<td style="display: none"></td>
								<td><i class="fa-solid fa-trash btn-modal"
									data-target="modalDeleteUserVCS"></i></td>
							</tr>
						</c:forEach>

					</tbody>
					<tfoot>
						<tr role="row">
							<th scope="col">STT</th>
							<th scope="col">Căn cước công dân</th>
							<th scope="col">Họ và tên</th>
							<th scope="col">Ngày sinh</th>
							<th scope="col">Giới tính</th>
							<th scope="col">Quê quán</th>
							<th scope="col" style="display: none"></th>
							<th scope="col">Xóa</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
		<div id="modalDeleteUserVCS" class="modal">
			<div class="modal-box">
				<span class="close">&times;</span>
				<div class="modal-content">
					<h3 class="modal-heading">Xóa người dùng</h3>
					<form action="#" id="form-deleteuservcs">
						<div class="form-group">
							<label for="userid-deleteVCS">Căn cước công dân <span>*</span>
							</label> <input class="form-control" type="text"
								placeholder="Nhập căn cước công dân" id="userid-deletevcs"
								name="userid" disabled />
						</div>

						<input type="submit" value="Xóa" />
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="module"
		src="<c:url value="/assets/js/admin/content.js" />"> </script>
</body>