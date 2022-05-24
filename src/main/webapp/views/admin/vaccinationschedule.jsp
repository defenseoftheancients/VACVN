<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/base.jspf"%>

<head>

<title>Quản lý lịch tiêm</title>
<link rel="stylesheet"
	href="<c:url value="/assets/css/admin/content.css" />" />
</head>
<body>
	<div class="content">
		<div id="modalAddVCS" class="modal">
			<!-- Modal content -->
			<div class="modal-box">
				<span class="close">&times;</span>
				<div class="modal-content">
					<h3 class="modal-heading">Thêm lịch tiêm</h3>
					<form action="#" id="form-addvcs">
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
							<label for="date-add">Ngày tiêm <span>*</span></label> <input
								class="form-control" type="date" id="vcsdate-add" name="vcsdate" />
						</div>
						<div class="form-group">
							<label for="amount-add">Số lượng tối đa <span>*</span></label> <input
								class="form-control" type="number" id="amount-add" name="amount"
								min="50" value="50" max="2000">
						</div>
						<div class="form-group">
							<label for="day-add">Buổi tiêm <span>*</span></label> <select
								class="form-control" name="day" id="day-add">
								<option value="" selected>--- Chọn buổi tiêm ---</option>
								<option value="Cả ngày">Cả ngày</option>
								<option value="Buổi sáng">Buổi sáng</option>
								<option value="Buổi chiều">Buổi chiều</option>
								<option value="Buổi tối">Buổi tối</option>
							</select>
						</div>
						<div class="form-group">
							<label for="status-add">Trạng thái <span>*</span></label> <select
								class="form-control" name="status" id="status-add">
								<option value="" selected>--- Chọn trạng thái ---</option>
								<option value="true">Công khai</option>
								<option value="false">Riêng tư</option>
							</select>
						</div>
						<div class="form-group">
							<label for="vcsprovince-add">Tỉnh / Thành phố <span>*</span>
							</label> <select class="form-control" name="vcsprovince"
								id="vcsprovince-add">
								<option value="" selected>--- Chọn tỉnh/thành phố ---</option>
							</select>
						</div>
						<div class="form-group">
							<label for="vcsdistrict-add">Quận / Huyện <span>*</span>
							</label> <select class="form-control" name="vcsdistrict"
								id="vcsdistrict-add">
								<option value="" selected>--- Chọn quận/huyện ---</option>
							</select>
						</div>
						<div class="form-group">
							<label for="vcsward-add">Phường / Xã <span>*</span></label> <select
								class="form-control" name="vcsward" id="vcsward-add">
								<option value="" selected>--- Chọn phường/xã ---</option>
							</select>
						</div>

						<input type="submit" value="Thêm" />
					</form>
				</div>
			</div>
		</div>
		<div class="content-cards">
			<div class="content-card" data-target="modalAddVCS" id="cardaddvcs">
				<div class="content-cardleft">
					<p>Thêm mới</p>
				</div>
				<div class="content-cardright">
					<i class="fa-solid fa-plus"></i>
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
							<th scope="col">Sửa đổi</th>
							<th scope="col">Xóa</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="vaccinationschedule"
							items="${vaccinationschedules}">
							<tr data-vaccinationscheduleid="${vaccinationschedule.id}">
								<td>${vaccinationschedule.date}</td>
								<td class="content-tableaddress">${vaccinationschedule.address}</td>
								<td>${vaccinationschedule.vaccine.vaccineName}</td>
								<td>${vaccinationschedule.status ? "Công khai" : "Riêng tư"}</td>
								<td>${vaccinationschedule.day}</td>
								<td>${vaccinationschedule.amount}</td>
								<td><a
									href="<c:url value="/admin/vaccinationschedule?id=${vaccinationschedule.id}"/>"><i
										class="fa-solid fa-pen-to-square"></i></a></td>
								<td><i class="fa-solid fa-trash btn-modal"
									data-target="modalDeleteVCS"></i></td>
							</tr>
						</c:forEach>

					</tbody>
					<tfoot>
						<tr role="row">
							<th scope="col">Ngày tiêm</th>
							<th scope="col">Địa chỉ</th>
							<th scope="col">Tên thuốc</th>
							<th scope="col">Trạng thái</th>
							<th scope="col">Buổi tiêm</th>
							<th scope="col">Số lượng tối đa</th>
							<th scope="col">Sửa đổi</th>
							<th scope="col">Xóa</th>
						</tr>
					</tfoot>
				</table>
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
							<label for="id-delete">ID <span>*</span></label> 
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
							<label for="day-delete">Buổi tiêm <span>*</span></label> <select
								class="form-control" name="day" id="day-delete">
								<option value="" selected>--- Chọn buổi tiêm ---</option>
								<option value="Cả ngày">Cả ngày</option>
								<option value="Buổi sáng">Buổi sáng</option>
								<option value="Buổi chiều">Buổi chiều</option>
								<option value="Buổi tối">Buổi tối</option>
							</select>
						</div>
						<div class="form-group">
							<label for="status-delete">Trạng thái <span>*</span></label> <select
								class="form-control" name="status" id="status-delete">
								<option value="" selected>--- Chọn trạng thái ---</option>
								<option value="true">Công khai</option>
								<option value="false">Riêng tư</option>
							</select>
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