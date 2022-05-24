<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/base.jspf"%>

<head>

<title>Quản lý người dùng</title>
<link rel="stylesheet"
	href="<c:url value="/assets/css/admin/content.css" />" />
</head>
<body>
	<div class="content">
		<div id="modalAddUser" class="modal">
			<!-- Modal content -->
			<div class="modal-box">
				<span class="close">&times;</span>
				<div class="modal-content">
					<h3 class="modal-heading">Thêm người dùng</h3>
					<form action="#" id="form-adduser">
						<div class="form-group">
							<label for="fullname-add">Họ và tên <span>*</span></label> <input
								class="form-control" type="text" placeholder="Nhập họ và tên"
								id="fullname-add" name="fullName">
						</div>
						<div class="form-group">
							<label for="dob-add">Ngày sinh <span>*</span></label> <input
								class="form-control" type="date" id="dob-add" name="dob">
						</div>
						<div class="form-group">
							<label for="gender-add">Giới tính <span>*</span></label> <select
								class="form-control" name="gender" id="gender-add">
								<option value="" selected>--- Chọn giới tính ---</option>
								<option value="Nam">Nam</option>
								<option value="Nữ">Nữ</option>
							</select>
						</div>
						<div class="form-group">
							<label for="userprovince-add">Tỉnh / Thành phố <span>*</span></label>
							<select class="form-control" name="userprovince"
								id="userprovince-add">
								<option value="" selected>--- Chọn tỉnh/thành phố ---</option>
							</select>
						</div>
						<div class="form-group">
							<label for="userdistrict-add">Quận / Huyện <span>*</span></label>
							<select class="form-control" name="userdistrict"
								id="userdistrict-add">
								<option value="" selected>--- Chọn quận/huyện ---</option>
							</select>
						</div>
						<div class="form-group">
							<label for="userward-add">Phường / Xã <span>*</span></label> <select
								class="form-control" name="userward" id="userward-add">
								<option value="" selected>--- Chọn phường/xã ---</option>
							</select>
						</div>

						<!-- <div class="form-group">
                    <label for="fullname">Họ và tên <span>*</span></label>
                    <input class="form-control" type="text" placeholder="Nhập họ và tên" id="fullname">
                  </div> -->
						<input type="submit" value="Thêm">
					</form>
				</div>
			</div>
		</div>
		<div class="content-cards">
			<div class="content-card " data-target="modalAddUser"
				id="cardadduser">
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
							<th scope="col">Sửa đổi</th>
							<c:if test="${admin.role.id == 1}">
								<th scope="col">Xóa</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<tr>
							<c:forEach var="user" items="${users}">
								<tr>
									<td class="content-tableuserid">${user.id}</td>
									<td class="content-tableusername">${user.fullName}</td>
									<td>${user.dob}</td>

									<td>${user.gender}</td>
									<td class="content-tableaddress">${user.address}</td>
									<td><a href="<c:url value="/admin/user?id=${user.id}"/>"><i
											class="fa-solid fa-pen-to-square"></i></a></td>
									<c:if test="${admin.role.id == 1}">
										<td><i class="fa-solid fa-trash btn-modal"
											data-target="modalDeleteUser"></i></td>
									</c:if>

								</tr>
							</c:forEach>
						</tr>
					</tbody>
					<tfoot>
						<tr role="row">
							<th scope="col">Căn cước công dân</th>
							<th scope="col">Họ và tên</th>
							<th scope="col">Ngày sinh</th>

							<th scope="col">Giới tính</th>
							<th scope="col">Quê quán</th>
							<th scope="col">Sửa đổi</th>
							<c:if test="${admin.role.id == 1}">
								<th scope="col">Xóa</th>
							</c:if>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
		<c:if test="${admin.role.id == 1}">
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

	</div>
	<script type="module"
		src="<c:url value="/assets/js/admin/content.js" />"> </script>
</body>
