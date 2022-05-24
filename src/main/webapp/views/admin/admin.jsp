<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/base.jspf"%>

<head>

<title>Quản lý Quản trị viên</title>
<link rel="stylesheet" href="<c:url value="/assets/css/admin/content.css" />" />
</head>
<body>
	<div class="content">
		<div id="modalAddAdmin" class="modal">
			<!-- Modal content -->
			<div class="modal-box">
				<span class="close">&times;</span>
				<div class="modal-content">
					<h3 class="modal-heading">Thêm quản trị viên</h3>
					<form action="#" id="form-addadmin">
						<div class="form-group">
							<label for="adminname-add">Tên tài khoản <span>*</span></label> <input
								class="form-control" type="text"
								placeholder="Nhập tên tài khoản" id="adminname-add"
								name="adminName">
						</div>
						<div class="form-group">
							<label for="adminpassword-add">Mật khẩu <span>*</span></label> <input
								class="form-control" type="password" placeholder="Nhập mật khẩu"
								id="adminpassword-add" name="password">
						</div>
						<div class="form-group">
							<label for="fullname-add">Họ và tên <span>*</span></label> <input
								class="form-control" type="text" placeholder="Nhập họ và tên"
								id="fullname-add" name="fullName">
						</div>
						<!-- <div class="form-group">
                    <label for="dob">Ngày sinh <span>*</span></label>
                    <input class="form-control" type="date"  id="dob" name="dob">
                  </div> -->
						<div class="form-group">
							<label for="role-add">Vai trò <span>*</span></label> <select
								class="form-control" name="role" id="role-add">
								<option value="" selected>--- Chọn vai trò ---</option>
								<option value="1">admin</option>
								<option value="2">mod</option>
							</select>
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
							<label for="adminprovince-add">Khu vực công tác <span>*</span></label>
							<select class="form-control" name="adminprovince"
								id="adminprovince-add">
								<option value="" selected>--- Chọn tỉnh/thành phố ---</option>
							</select>
						</div>
						<input type="submit" value="Thêm">
					</form>
				</div>
			</div>
		</div>
		<div class="content-cards">
			<div class="content-card " data-target="modalAddAdmin"
				id="cardaddadmin">
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
		<div id="modalUpdateAdmin" class="modal">
			<!-- Modal content -->
			<div class="modal-box">
				<span class="close">&times;</span>
				<div class="modal-content">
					<h3 class="modal-heading">Cập nhật quản trị viên</h3>
					<form action="#" id="form-updateadmin">
						<input type="hidden" name="id">
						<div class="form-group">
							<label for="adminname-update">Tên tài khoản <span>*</span></label>
							<input class="form-control" type="text"
								placeholder="Nhập tên tài khoản" id="adminname-update"
								name="adminName">
						</div>
						<div class="form-group">
							<label for="fullname-update">Họ và tên <span>*</span></label> <input
								class="form-control" type="text" placeholder="Nhập họ và tên"
								id="fullname-update" name="fullName">
						</div>
						<div class="form-group">
							<label for="adminpassword-update">Mật khẩu <span>*</span></label>
							<input class="form-control" type="password"
								placeholder="Nhập mật khẩu" id="adminpassword-update"
								name="password">
						</div>
						<!-- <div class="form-group">
                    <label for="dob">Ngày sinh <span>*</span></label>
                    <input class="form-control" type="date"  id="dob" name="dob">
                  </div> -->
						<div class="form-group">
							<label for="role-update">Vai trò <span>*</span></label> <select
								class="form-control" name="role" id="role-update">
								<option value="" selected>--- Chọn vai trò ---</option>
								<option value="1">admin</option>
								<option value="2">mod</option>
							</select>
						</div>
						<div class="form-group">
							<label for="gender-update">Giới tính <span>*</span></label> <select
								class="form-control" name="gender" id="gender-update">
								<option value="" selected>--- Chọn giới tính ---</option>
								<option value="Nam">Nam</option>
								<option value="Nữ">Nữ</option>
							</select>
						</div>
						<div class="form-group">
							<label for="adminprovince-update">Khu vực công tác <span>*</span></label>
							<select class="form-control" name="adminprovince"
								id="adminprovince-update">
								<option value="" selected>--- Chọn tỉnh/thành phố ---</option>
							</select>
						</div>
						<input type="submit" value="Cập nhật">
					</form>
				</div>
			</div>
		</div>
		<div class="content-table">
			<h3 class="content-headingtable">Quản trị viên</h3>
			<div class="content-tablerows">
				<table>
					<thead>
						<tr role="row">
							<th scope="col">STT</th>
							<th scope="col">Tên tài khoản</th>
							<th scope="col">Họ và tên</th>
							<th scope="col">Giới tính</th>
							<th scope="col">Khu vực quản lý</th>
							<th scope="col">Vai trò</th>
							<th scope="col">Sửa đổi</th>
							<th scope="col">Xóa</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="admin" items="${admins}" varStatus="loop">
						<tr>
							<td data-adminid="${admin.id}">${loop.index+1}</td>
							<td>${admin.adminName}</td>
							<td>${admin.fullName}</td>
							<td>${admin.gender}</td>
							<td class="content-tableaddress" data-provincecode="${admin.provinceCode}">${admin.provinceCode}</td>
							<td>${admin.role.rolename}</td>
							<td><i class="fa-solid fa-pen-to-square"
								data-target="modalUpdateAdmin"></i></td>
							<td><i class="fa-solid fa-trash btn-modal"
								data-target="modalDeleteAdmin"></i></td>
						</tr>
						</c:forEach>
					</tbody>
					<tfoot>
						<tr role="row">
							<th scope="col">STT</th>
							<th scope="col">Tên tài khoản</th>
							<th scope="col">Họ và tên</th>
							<th scope="col">Giới tính</th>
							<th scope="col">Khu vực quản lý</th>
							<th scope="col">Vai trò</th>
							<th scope="col">Sửa đổi</th>
							<th scope="col">Xóa</th>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
		<div id="modalDeleteAdmin" class="modal">
			<!-- Modal content -->
			<div class="modal-box">
				<span class="close">&times;</span>
				<div class="modal-content">
					<h3 class="modal-heading">Xóa quản trị viên</h3>
					<form action="#" id="form-deleteadmin">
						<input type="hidden" name="id" value="">
						<div class="form-group">
							<label for="adminname-delete">Tên tài khoản <span>*</span></label>
							<input class="form-control" type="text"
								placeholder="Nhập tên tài khoản" id="adminname-delete"
								name="adminName">
						</div>
						<div class="form-group">
							<label for="fullname-delete">Họ và tên <span>*</span></label> <input
								class="form-control" type="text" placeholder="Nhập họ và tên"
								id="fullname-delete" name="fullName">
						</div>

						<!-- <div class="form-group">
                    <label for="dob">Ngày sinh <span>*</span></label>
                    <input class="form-control" type="date"  id="dob" name="dob">
                  </div> -->
						<div class="form-group">
							<label for="role-delete">Vai trò <span>*</span></label> <select
								class="form-control" name="role" id="role-delete">
								<option value="" selected>--- Chọn vai trò ---</option>
								<option value="1">admin</option>
								<option value="2">mod</option>
							</select>
						</div>
						<div class="form-group">
							<label for="gender-delete">Giới tính <span>*</span></label> <select
								class="form-control" name="gender" id="gender-delete">
								<option value="" selected>--- Chọn giới tính ---</option>
								<option value="Nam">Nam</option>
								<option value="Nữ">Nữ</option>
							</select>
						</div>
						<div class="form-group">
							<label for="adminprovince-delete">Khu vực công tác <span>*</span></label>
							<select class="form-control" name="adminprovince"
								id="adminprovince-delete">
								<option value="" selected>--- Chọn tỉnh/thành phố ---</option>
							</select>
						</div>
						<input type="submit" value="Xóa">
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="module" src="<c:url value="/assets/js/admin/content.js" />"> </script>
</body>
