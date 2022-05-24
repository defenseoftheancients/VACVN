<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../common/base.jspf"%>


<head>
<meta charset="UTF-8">
<title>Tra cứu</title>
<link rel="stylesheet"
	href="<c:url value="/assets/css/web/tracuu.css" />" />
</head>
<body>
	

	<div class="thantrang">
		<h2 class="thantrang__tieude">Tra cứu tiêm chủng</h2>
		<!-- <div class="thantrang__tracuu">
               <form action="#">
               
                    <div class="thantrang__CCCD-form ">
                        <label for="">Căn cước công dân <span>*</span> </label>
                        <div class="thantrang__input">
                            <input type="text" class="input__id" placeholder="Vui lòng điền đầy đủ 12 số">
                            <i class="input__icon fa-solid fa-circle-exclamation "></i>
                        </div>
                        <span class="thantrang__thongbao ">Số căn cước công dân không hợp lệ!</span>
                    </div>
                   
               </form>
            </div> -->
		<div class="thantrang__ghichu">
			Ghi chú: Nếu bạn đã tiêm nhưng chưa được ghi nhận, hãy liên hệ với cơ
			sở tiêm và đề nghị cập nhật thông tin lên <br>Nền tảng tiêm
			chủng để có thể nhận được Chứng nhận tiêm
		</div>
		<div class="thantrang__nuttracuu" id="myBtn">
			<i class="fa-solid fa-magnifying-glass"></i> Tra cứu
		</div>
		<div class="thantrang__ketqua">
			<!-- <div class="bang">
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
                                    <td>Hoàng Anh Tuấn</td>
                                    <td>23/03/2001</td>
                                    <td>Nam</td>
                                    <td class="bang__diachi">
                                        <span>Phường Quang Trung</span>, <span>Thành Phố Uông Bí</span>, <span>Tỉnh
                                            Quảng Ninh</span>
                                    </td>
                                   
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
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
                                <tr>
                                    <td>1</td>
                                    <td>Astra Zeneca</td>
                                    <td>17/02/2021</td>
                                    <td class="bang__diachi">
                                        <span>Phường Quang Trung</span>, <span>Thành Phố Uông Bí</span>, <span>Tỉnh
                                            Quảng Ninh</span>
                                    </td>
                                    
                                </tr>
                                <tr>
                                    <td>2</td>
                                    <td>Pfizer</td>
                                    <td>18/02/2021</td>
                                    <td class="bang__diachi">
                                        <span>Phường Quang Trung</span>, <span>Thành Phố Uông Bí</span>, <span>Tỉnh
                                            Quảng Ninh</span>
                                    </td>
                                  
                                </tr>
                                <tr>
                                    <td>3</td>
                                    <td>Vero Cell</td>
                                    <td>19/02/2021</td>
                                    <td class="bang__diachi">
                                        <span>Phường Quang Trung</span>, <span>Thành Phố Uông Bí</span>, <span>Tỉnh
                                            Quảng Ninh</span>
                                    </td>
                                   
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="bang">
                    <h3 class="bang__tieude">Lịch tiêm</h3>
                    <div class="bang__noidung">
                        <table>
                            <tr>
                                <th>Ngày tiêm</th>
                                <th>Nơi tiêm</th>
                                <th>Tên thuốc</th>
                            </tr>
                            <tbody>
                                <tr>
                                    <td>14/04/2022</td>
                                    <td class="bang__diachi">
                                        <span>Tỉnh Cao Bằng</span>, <span>Huyện Bảo Lâm</span>, <span> Xã Thái Học</span>
                                    </td>        
                                    <td>Pfizer</td>    
                                </tr>        
                            </tbody>
                        </table>
                    </div>
                </div> -->
		</div>
		<div id="myModal" class="modal">
			<!-- Modal content -->
			<div class="modal-box">
				<span class="close">&times;</span>
				<div class="modal-content">
					<h3 class="modal-heading">Mẫu tra cứu</h3>
					<form action="#" id="form-userquery">
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
						<input type="submit" value="Tra cứu" />
						<!-- Vui lòng kiểm tra email của bạn! -->
						<div class="feedback"></div>
					</form>
				</div>
			</div>
		</div>
		<script type="module" src="<c:url value="/assets/js/web/tracuu.js" />"> </script>
</body>
