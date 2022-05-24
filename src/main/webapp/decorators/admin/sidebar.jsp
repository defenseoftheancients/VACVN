<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="sidebar">
	<div class="sidebar-brand">
		<div class="sidebar-brand-icon">
			<a href="#"><img
				src="<c:url value="/assets/img/logo-transparent.png"/>" alt="logo" /></a>
		</div>
		<h1 class="sidebar-brand-text">VACCINE VIETNAM</h1>
	</div>
	<div class="sidebar-list">
		<hr />
		<div class="sidebar-dashboard">
			<a class="sidebar-anchor sidebar-anchor_heading" href="#"> <i
				class="fa-solid fa-bolt"></i> <span
				class="sidebar-dashboard-text sidebar-list-text_heading">Thống
					Kê</span>
			</a>
		</div>
		<hr />
		<div class="sidebar-addons">
			<span class="sidebar-listheading">DANH MỤC</span>
			<ul>
				<li><a href="javascript:void(0)"
					class="sidebar-anchor sidebar-anchor_heading sidebar-anchor_dropdrown">
						<i class="fa-solid fa-user"></i> <span
						class="sidebar-list-text sidebar-list-text_heading">Người
							Dùng</span> <i
						class="fa-solid fa-angle-right sidebar-icontoggle_dropdown"></i>
				</a>
					<ul class="sidebar-nested-list sidebar-nested-list_hide">
						<li><a href="javascript:void(0)" class="sidebar-anchor">
								<span class="sidebar-list-text">Số Liệu Thống Kê</span>
						</a></li>
						<!-- <li>
                    <a href="javascript:void(0)"  class="sidebar-anchor">
                      <span class="sidebar-list-text">Student Ranking</span>
                    </a>
                  </li> -->
						<li><a href="<c:url value="/admin/user"/>"
							class="sidebar-anchor"> <span class="sidebar-list-text">Quản
									Lý Người Dùng</span>
						</a></li>
					</ul></li>
				<li><a href="javascript:void(0)"
					class="sidebar-anchor sidebar-anchor_heading sidebar-anchor_dropdrown">
						<i class="fa-solid fa-pills"></i> <span
						class="sidebar-list-text sidebar-list-text_heading">Vaccine</span>
						<i class="fa-solid fa-angle-right sidebar-icontoggle_dropdown"></i>
				</a>
					<ul class="sidebar-nested-list sidebar-nested-list_hide">
						<li><a href="javascript:void(0)" class="sidebar-anchor">
								<span class="sidebar-list-text">Số Liệu Thống Kê</span>
						</a></li>
						<!-- <li>
                    <a href="javascript:void(0)"  class="sidebar-anchor">
                      <span class="sidebar-list-text">Student Ranking</span>
                    </a>
                  </li> -->
						<li><a href="<c:url value="/admin/vaccine"/>"
							class="sidebar-anchor"> <span class="sidebar-list-text">Quản
									Lý Vaccine</span>
						</a></li>
					</ul></li>
				<!-- <li><a href="javascript:void(0)"
					class="sidebar-anchor sidebar-anchor_heading sidebar-anchor_dropdrown">
						<i class="fa-solid fa-user-doctor"></i> <span
						class="sidebar-list-text sidebar-list-text_heading">Bác
							Sĩ</span> <i class="fa-solid fa-angle-right sidebar-icontoggle_dropdown"></i>
				</a>

					<ul class="sidebar-nested-list sidebar-nested-list_hide">
						<li><a href="javascript:void(0)" class="sidebar-anchor">
								<span class="sidebar-list-text">Số Liệu Thống Kê</span>
						</a></li>
						<li>
                    <a href="javascript:void(0)"  class="sidebar-anchor">
                      <span class="sidebar-list-text">Teacher Ranking</span>
                    </a>
                  </li>
						<li><a href="javascript:void(0)" class="sidebar-anchor">
								<span class="sidebar-list-text">Quản Lý Bác Sĩ</span>
						</a></li>
					</ul></li> -->
				<c:if test="${admin.role.id == 1}">
					<li><a href="javascript:void(0)"
						class="sidebar-anchor sidebar-anchor_heading sidebar-anchor_dropdrown">
							<i class="fa-solid fa-syringe"></i> <span
							class="sidebar-list-text sidebar-list-text_heading">Lịch
								Tiêm</span> <i
							class="fa-solid fa-angle-right sidebar-icontoggle_dropdown"></i>
					</a>

						<ul class="sidebar-nested-list sidebar-nested-list_hide">
							<li><a href="javascript:void(0)" class="sidebar-anchor">
									<span class="sidebar-list-text">Số Liệu Thống Kê</span> <!-- <i class="fa-solid fa-angle-right sidebar-icontoggle_dropdown"></i> -->
							</a> <!-- <ul class="sidebar-nested-list sidebar-nested-list_hide">
                      <li>
                        <a href="javascript:void(0)" class="sidebar-anchor">
                          <span class="sidebar-list-text">Function 1</span>
                          <i class="fa-solid fa-angle-right sidebar-icontoggle_dropdown"></i>
                        </a>
                        <ul class="sidebar-nested-list sidebar-nested-list_hide">
                          <li>
                            <a href="#" class="sidebar-anchor">
                              <span class="sidebar-list-text">Function 1</span>
                            </a>
                          </li>
                          <li>
                            <a href="#" class="sidebar-anchor">
                              <span class="sidebar-list-text">Function 2</span>
                            </a>
                          </li>
                          <li>
                            <a href="#" class="sidebar-anchor">
                              <span class="sidebar-list-text">Function 3</span>
                            </a>
                          </li>
                        </ul>
                      </li>
                      <li>
                        <a href="#" class="sidebar-anchor">
                          <span class="sidebar-list-text">Function 2</span>
                        </a>
                      </li>
                      <li>
                        <a href="#" class="sidebar-anchor">
                          <span class="sidebar-list-text">Function 3</span>
                        </a>
                      </li>
                    </ul> --></li>
							<!-- <li>
                    <a href="#" class="sidebar-anchor">
                      <span class="sidebar-list-text">Exam Ranking</span>
                    </a>
                  </li> -->
							<li><a href="<c:url value="/admin/vaccinationschedule"/>"
								class="sidebar-anchor"> <span class="sidebar-list-text">Quản
										Lý Lịch Tiêm</span>
							</a></li>
						</ul></li>
				</c:if>
				<c:if test="${admin.role.id == 1}">
					<li><a href="javascript:void(0)"
						class="sidebar-anchor sidebar-anchor_heading sidebar-anchor_dropdrown">
							<i class="fa-solid fa-user-gear"></i> <span
							class="sidebar-list-text sidebar-list-text_heading">Quản
								trị viên</span> <i
							class="fa-solid fa-angle-right sidebar-icontoggle_dropdown"></i>
					</a>

						<ul class="sidebar-nested-list sidebar-nested-list_hide">
							<li><a href="javascript:void(0)" class="sidebar-anchor">
									<span class="sidebar-list-text">Số Liệu Thống Kê</span>
							</a></li>
							<!-- <li>
                    <a href="javascript:void(0)"  class="sidebar-anchor">
                      <span class="sidebar-list-text">Teacher Ranking</span>
                    </a>
                  </li> -->
							<li><a href="<c:url value="/admin/admin"/>"
								class="sidebar-anchor"> <span class="sidebar-list-text">Quản
										Lý QTV</span>
							</a></li>
						</ul></li>
				</c:if>

				<!-- <li><a href="#" class="sidebar-anchor sidebar-anchor_heading">
						<i class="fa-solid fa-user-gear"></i> <span
						class="sidebar-list-text sidebar-list-text_heading">Admin</span>
				</a>
					<ul class="sidebar-nested-list sidebar-nested-list_hide">
						<li><a href="#" class="sidebar-anchor"> <span
								class="sidebar-list-text">Function 1</span>
						</a></li>
						<li><a href="#" class="sidebar-anchor"> <span
								class="sidebar-list-text">Function 2</span>
						</a></li>
						<li><a href="#" class="sidebar-anchor"> <span
								class="sidebar-list-text">Function 3</span>
						</a></li>
					</ul></li> -->
				<!-- <li>
                <a href="#" class="sidebar-anchor">
                  <i class="bx bx-expand-vertical"></i>
                  <span class="sidebar-dashboard-text">Dashboard</span>
                </a>
              </li> -->
			</ul>
		</div>
		<hr />
		<div class="sidebar-boxbutton">
			<button class="sidebar-btn">
				<i class="fa-solid fa-angle-left"></i>
			</button>
		</div>
	</div>
</div>