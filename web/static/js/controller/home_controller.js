'use strict';

function colorOfPermission(user) {
    if (user.permission == roles.member) {
        return 'blue';
    } else if (user.permission == roles.admin) {
        return 'green';
    } else {
        return 'red';
    }
}

App.controller('HomeController', ['$scope', '$rootScope','$location', 'ngDialog','sharedProperties', function($scope,$rootScope,$location, ngDialog,sharedProperties) {
            $rootScope.idSelectedMenuItem = "topmenu_li_home";
            var self = this;

            self.user = sharedProperties.getUser();
            self.color = "red";
            if (!isNull(self.user)) {
                self.color = colorOfPermission(self.user);
            }

            $scope.logout = function() {
                self.user = null;
                sharedProperties.setUser(null);
                $location.path('#/login');
            };
}]);
