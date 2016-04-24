/**
 * Created by tolgacaner on 25/04/16.
 */

angular.module('myApp',[]).controller('LoginController',
        ['$scope', 'LoginService',
            function ($scope, LoginService) {
                // reset login status
 //               AuthenticationService.ClearCredentials();
                this.login = function () {
                    $scope.dataLoading = true;
                    /*
                    LoginService.login($scope.username, $scope.password, function(response) {
                        if(response.success) {
                            console.error('Success login');
                        //    AuthenticationService.SetCredentials($scope.username, $scope.password);
                        //    $location.path('/');
                        } else {
                            console.error('Error login');
                            $scope.error = response.message;
                            $scope.dataLoading = false;
                        }
                    });
                    */
                };
            }]);