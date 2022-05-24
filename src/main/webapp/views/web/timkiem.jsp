<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/base.jspf"%>

<head>
<meta charset="UTF-8">
<title>Tìm kiếm</title>
<link rel="stylesheet"
	href="<c:url value="/assets/css/web/timkiem.css" />" />
</head>
<body>
	<div class="ochua">
		<form>
			<div class="form-trong">
				<div class="tim-kiem">
					<span class="ten">TRA CỨU LỊCH TIÊM PHÒNG COVID-19</span>
					<div class="hang">
						<div class="hop-dauvao">
							<div class="chon-dauvao">
								<select data-trigger="" name="choices-single-defaul"
									id="provinceSelect" class="chonthu">
									<option placeholder="" value="">Tỉnh/Thành Phố</option>
								</select>
							</div>
						</div>
						<div class="hop-dauvao">
							<div class="chon-dauvao">
								<select data-trigger="" name="choices-single-defaul"
									id="districtSelect" class="chonthu">
									<option placeholder="" value="">Quận/Huyện</option>
								</select>
							</div>
						</div>
						<div class="hop-dauvao">
							<div class="chon-dauvao">
								<select data-trigger="" name="choices-single-defaul"
									id="wardSelect" class="chonthu">
									<option placeholder="" value="">Xã/Phường</option>
								</select>
							</div>
						</div>
					</div>
					<div class="hang third">
						<div class="hop-dauvao">
							<div class="khg-trong"></div>
							<div class="nhom-nut">
								<div class="ntim">TÌM KIẾM</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
	</div>
	<div class="thantrang">
		<div class="thantrang__ketqua">
			<!-- <div class="bang">
                    <h3 class="bang__tieude">Lịch tiêm</h3>
                    <div class="bang__noidung">
                        <table>
                            <tr>
                                <th>STT</th>
                                <th>Ngày tiêm</th>
                                <th>Tên thuốc</th>
                                <th>Địa chỉ</th>
                                <th>Đăng ký</th>
                            </tr>
                            <tbody>
                                <tr>
                                    <td>1</td>
                                    <td>14/04/2022</td>
                                    <td>Pfizer</td>
                                    <td class="bang__diachi"><span>Phường Quang Trung</span>, <span>Thành Phố Uông Bí</span>, <span>Tỉnh Quảng Ninh</span></td>
                                    <td class="bang__dangky"><i class="fa-solid fa-pen-clip" id="myBtn"></i></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div> -->
		</div>
	</div>
	<div id="myModal" class="modal">
		<!-- Modal content -->
		<div class="modal-box">
			<span class="close">&times;</span>
			<div class="modal-content">
				<h3 class="modal-heading">Mẫu đăng ký</h3>
				<form action="#" id="form-adduserregistry">
					<div class="form-group">
						<label for="id">Số căn cước công dân <span>*</span></label> <input
							class="form-control" type="text"
							placeholder="Nhập căn cước công dân" id="id" name="id" />
					</div>
					<div class="form-group">
						<label for="fullname">Họ và tên <span>*</span></label> <input
							class="form-control" type="text" placeholder="Nhập họ và tên"
							id="fullname" name="fullName" />
					</div>
					<div class="form-group">
						<label for="dob">Ngày sinh <span>*</span></label> <input
							class="form-control" type="date" id="dob" name="dob" />
					</div>
					<div class="form-group">
						<label for="email">Email <span>*</span></label> <input
							class="form-control" type="email" id="email" name="email"
							placeholder="Vui lòng nhập email" />
					</div>
					<div class="form-group">
						<label for="gender">Giới tính <span>*</span></label> <select
							class="form-control" name="gender" id="gender">
							<option value="" selected>--- Chọn giới tính ---</option>
							<option value="Nam">Nam</option>
							<option value="Nữ">Nữ</option>
						</select>
					</div>
					<div class="form-group">
						<label for="userprovince">Tỉnh / Thành phố <span>*</span></label>
						<select class="form-control" name="province" id="userprovince">
							<option value="" selected>--- Chọn tỉnh/thành phố ---</option>
						</select>
					</div>
					<div class="form-group">
						<label for="userdistrict">Quận / Huyện <span>*</span></label> <select
							class="form-control" name="district" id="userdistrict">
							<option value="" selected>--- Chọn quận/huyện ---</option>
						</select>
					</div>
					<div class="form-group">
						<label for="userward">Phường / Xã <span>*</span></label> <select
							class="form-control" name="ward" id="userward">
							<option value="" selected>--- Chọn phường/xã ---</option>
						</select>
					</div>
					<!-- <div class="form-group">
                            <label for="vertification">Vertification Code <span>*</span></label>
                            <input class="form-control" type="text" placeholder="Nhập mã xác thực" id="vertification" name="vertification" />
                        </div> -->
					<!-- <div class="form-group">
                      <label for="fullname">Họ và tên <span>*</span></label>
                      <input class="form-control" type="text" placeholder="Nhập họ và tên" id="fullname">
                    </div> -->
					<input type="submit" value="Đăng ký" />
					<!-- Vui lòng kiểm tra email của bạn! -->
					<div class="feedback"></div>
				</form>
			</div>
		</div>
	</div>

	<script type="module" src="<c:url value="/assets/js/web/timkiem.js" />"> </script>

</body>
