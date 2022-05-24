<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/base.jspf"%>

<head>

<title>Quản lý Vaccine</title>
<link rel="stylesheet"
	href="<c:url value="/assets/css/admin/content.css" />" />
</head>
<body>

	<div class="content">
		<c:if test="${admin.role.id == 1}">
			<div id="modalAddVaccine" class="modal">
				<!-- Modal content -->
				<div class="modal-box">
					<span class="close">&times;</span>
					<div class="modal-content">
						<h3 class="modal-heading">Thêm vaccine</h3>
						<form action="#" id="form-addvaccine">
							<div class="form-group">
								<label for="vaccinename-add">Tên thuốc <span>*</span></label> <input
									class="form-control" type="text" placeholder="Nhập tên thuốc"
									name="vaccineName" id="vaccinename-add">
							</div>
							<input type="submit" value="Thêm">
						</form>
					</div>
				</div>
			</div>
			<div class="content-cards">
				<div class="content-card " data-target="modalAddVaccine"
					id="cardaddvaccine">
					<div class="content-cardleft">
						<p>Thêm mới</p>
					</div>
					<div class="content-cardright">
						<i class="fa-solid fa-plus"></i>
					</div>
				</div>
			</div>
		</c:if>

		<div class="content-table">
			<h3 class="content-headingtable">Vaccine</h3>
			<div class="content-tablerows">
				<table>
					<thead>
						<tr role="row">
							<th scope="col">STT</th>
							<th scope="col">Tên thuốc</th>
							<c:if test="${admin.role.id == 1}">
								<th scope="col">Sửa đổi</th>
								<th scope="col">Xóa</th>
							</c:if>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="vaccine" items="${vaccines}" varStatus="loop">
							<tr>
								<td>${loop.index+1}</td>
								<td data-vacineid="${vaccine.id}">${vaccine.vaccineName}</td>
								<c:if test="${admin.role.id == 1}">
									<td><i class="fa-solid fa-pen-to-square"
										data-target="modalUpdateVaccine"></i></td>
									<td><i class="fa-solid fa-trash btn-modal"
										data-target="modalDeleteVaccine"></i></td>
								</c:if>
							</tr>
						</c:forEach>


					</tbody>
					<tfoot>
						<tr role="row">
							<th scope="col">STT</th>
							<th scope="col">Tên thuốc</th>
							<c:if test="${admin.role.id == 1}">
								<th scope="col">Sửa đổi</th>
								<th scope="col">Xóa</th>
							</c:if>
						</tr>
					</tfoot>
				</table>
			</div>
		</div>
		<c:if test="${admin.role.id == 1}">
			<div id="modalUpdateVaccine" class="modal">
				<div class="modal-box">
					<span class="close">&times;</span>
					<div class="modal-content">
						<h3 class="modal-heading">Cập nhật vaccine</h3>
						<form action="#" id="form-updatevaccine">

							<div class="form-group">
								<label for="vaccinename-update">Tên thuốc <span>*</span></label>
								<input class="form-control" type="text"
									placeholder="Nhập tên thuốc" name="vaccineName"
									id="vaccinename-update">
							</div>

							<input class="form-control" type="hidden" name="id"
								id="vaccineid-update"> <input type="submit"
								value="Cập nhật">
						</form>
					</div>
				</div>
			</div>
			<div id="modalDeleteVaccine" class="modal">
				<div class="modal-box">
					<span class="close">&times;</span>
					<div class="modal-content">
						<h3 class="modal-heading">Xóa vaccine</h3>
						<form action="#" id="form-deletevaccine">
							<div class="form-group">
								<label for="vaccinename">Tên thuốc <span>*</span></label> <input
									class="form-control" type="text" placeholder="Nhập tên thuốc"
									name="vaccineName" id="vaccinename-update">
							</div>
							<input class="form-control" type="hidden" name="id"
								id="vaccineid-update"> <input type="submit" value="Xóa">
						</form>
					</div>
				</div>
			</div>
		</c:if>

	</div>
	<script type="module"
		src="<c:url value="/assets/js/admin/content.js" />"> </script>
</body>
