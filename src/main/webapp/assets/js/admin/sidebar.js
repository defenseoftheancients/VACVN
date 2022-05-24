"use strict"
const sideBar = document.querySelector('.sidebar');
const sidebarAnchorDropdown = sideBar.querySelectorAll('.sidebar-anchor_dropdrown');
const sidebarButtonToggle = sideBar.querySelector('.sidebar-btn');

export function setUpSidebarAnchorDropdown() {
    sidebarAnchorDropdown.forEach((item)=>item.addEventListener('click', (event) => {
        const clickedElement = event.target;
        const iconToggle = clickedElement.getElementsByClassName('sidebar-icontoggle_dropdown').item(0);
        const nestedList = clickedElement.nextElementSibling;
       
        if(window.getComputedStyle(sideBar).width !== "220px") {
            if(nestedList.classList.contains('sidebar-nested-list_hide')) {
                sidebarAnchorDropdown.forEach(item=> {
                    item.nextElementSibling.classList.add('sidebar-nested-list_hide');
                    const anotherIconToggle = item.getElementsByClassName('sidebar-icontoggle_dropdown').item(0);
                    anotherIconToggle.classList.remove('fa-angle-down');
                    anotherIconToggle.classList.add('fa-angle-right');          
                });
                nestedList.classList.remove('sidebar-nested-list_hide');
            }
            else {
                nestedList.classList.add('sidebar-nested-list_hide');
            }
        }
        else 
            nestedList.classList.toggle('sidebar-nested-list_hide');
        iconToggle.classList.toggle('fa-angle-down');
        iconToggle.classList.toggle('fa-angle-right');
        
    }, false));
};
function toggleSidebarAnchorDropdown() {
    
}
export function setUpSideBarButtonToggle() {
    sidebarButtonToggle.addEventListener('click', (event) => {
        const sidebarBrand = sideBar.querySelector('.sidebar-brand');
        const sidebarBrandText = sideBar.querySelector('.sidebar-brand-text');
        const sideBarListHeading = sideBar.querySelectorAll('.sidebar-listheading');
        const sideBarAnchorHeading = sideBar.querySelectorAll('.sidebar-anchor_heading');
        const iconButtonToggle = sidebarButtonToggle.querySelector('i');
      
        //opening
        if(window.getComputedStyle(sideBar).width === "220px") {
            sideBar.classList.add('sidebar_sprink');
            sidebarBrand.classList.add('sidebar-brand_sprink');
            sidebarBrandText.classList.add('sidebar-brand-text_sprink');
            sideBarListHeading.forEach(item=>item.classList.add('sidebar-listheading_sprink'));
            

            // const sideBarfilteredAnchor = [...sideBarAnchor].filter(item=>{
            //     return item.querySelector('.sidebar-list-text_heading') !== null;
            // });
            sidebarAnchorDropdown.forEach(item=>{
                const nestedList = item.nextElementSibling;
                const iconToggle = item.getElementsByClassName('sidebar-icontoggle_dropdown').item(0);
                iconToggle.classList.remove('fa-angle-down');
                iconToggle.classList.add('fa-angle-right');    
                nestedList.classList.add('sidebar-nested-list_hide');
                nestedList.classList.add('sidebar-nested-list_sprink'); 
            });
            toggleSideBarAnchorHeadingShow(sideBarAnchorHeading);

        }
        //closing
        else {
            sideBar.classList.remove('sidebar_sprink');
            sidebarBrand.classList.remove('sidebar-brand_sprink');
            sidebarBrandText.classList.remove('sidebar-brand-text_sprink');
            sideBarListHeading.forEach(item=>item.classList.remove('sidebar-listheading_sprink'));
            sidebarAnchorDropdown.forEach(item=>{
                item.nextElementSibling.classList.remove('sidebar-nested-list_sprink'); 
            });
            toggleSideBarAnchorHeadingShow(sideBarAnchorHeading);
        }
        iconButtonToggle.classList.toggle('fa-angle-left');
        iconButtonToggle.classList.toggle('fa-angle-right');
    });
};

function toggleSideBarAnchorHeadingShow(sideBarAnchorHeading) {
    sideBarAnchorHeading.forEach(item=>{
        const iconToggle = item.querySelector('.sidebar-icontoggle_dropdown');
        if(iconToggle !== null) {
            iconToggle.classList.toggle('sidebar-icontoggle_dropdown_sprink');
        }
        item.classList.toggle('sidebar-anchor_heading_hide');
    });
}