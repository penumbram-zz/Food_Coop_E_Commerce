'use strict';

App.controller("TopMenuCtrl",function ($scope) {

    $scope.opts = [
        {value: 1, text: "Home" ,id: "topmenu_li_home"},
        {value: 2, text: "Products", id: "topmenu_li_product"},
        {value: 3, text: "Co-Op", id: "topmenu_li_coop" },
        {value: 4, text: "Contact",id: "topmenu_li_contact" }
    ];

    $scope.idSelectedMenuItem = $scope.opts[0].id;

    $scope.setItemSelected = function(optId) {
        console.log("selected:" + optId);
        $scope.idSelectedMenuItem = optId;
    }
});