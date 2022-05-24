import * as sideBar from './sidebar.js';
import * as navBar from './navbar.js';

document.addEventListener('readystatechange', function (event) {
    if(event.target.readyState === 'complete')
        sideBar.setUpSidebarAnchorDropdown();
        sideBar.setUpSideBarButtonToggle();
})
