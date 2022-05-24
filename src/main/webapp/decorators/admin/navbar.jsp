<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="navbar">
	<div class="navbar-left">
		<div class="navbar-togglesidebar_mobile">
			<i class="fa-solid fa-bars"></i>
		</div>
		<form class="navbar-form" action="">
			<input type="text" placeholder="Tìm kiếm..." />
			<div class="navbar-boxsearchbtn">
				<button class="navbar-searchbtn">
					<i class="fa-solid fa-magnifying-glass"></i>
				</button>
			</div>
		</form>
	</div>
	<div class="navbar-right">
		<div class="navbar-boxsearchtoggle_mobile">
			<button class="navbar-searchtoggle_mobile">
				<i class="fa-solid fa-magnifying-glass"></i>
			</button>
		</div>

		<div class="navbar-admin" data-adminid="${admin.id}">${admin.fullName}</div>
		<div class="navbar-logout">
			<a href="<c:url value="/admin/login?logout"/>">Đăng xuất</a>
		</div>
	</div>
</div>