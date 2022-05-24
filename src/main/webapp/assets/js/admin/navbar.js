const navbar = document.querySelector('.navbar');
const navbarToggleSideBarBtn = navbar.querySelector('.navbar-togglesidebar_mobile');
const navbarToggleBoxSearch = navbar.querySelector('.navbar-boxsearchtoggle_mobile');
const navbarAdmin = navbar.querySelector('.navbar-admin');
const navbarLogout = navbar.querySelector('.navbar-logout');
const sideBar = document.querySelector('.sidebar');
const navBarFormSearch = navbar.querySelector('.navbar-form');


navbarToggleSideBarBtn.addEventListener('click',  (event) => {
    sideBar.classList.toggle('sidebar_showmobile');
});
navbarToggleBoxSearch.addEventListener('click', (event) => {
    navBarFormSearch.classList.toggle('navbar-form_show');
    console.log(navBarFormSearch);
});
navbarAdmin.addEventListener('click', (event) => {
    navbarLogout.classList.toggle('active');
});