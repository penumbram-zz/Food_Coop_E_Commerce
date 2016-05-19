/**
 * Created by tolgacaner on 25/04/16.
 */

App.controller('LoginController', ['$scope', '$location', 'LoginService', 'sharedProperties', function ($scope,$location, LoginService, sharedProperties) {
            var self = this;
            self.user= {username:'',password:'',first_name:'',last_name:''};
            self.success = null;

    self.login = function(user){
        console.log("Logging in");
        console.log("username: " + user.username);
        console.log("password: " + user.password);
        LoginService.login(user.username, user.password)
                    .then(
                        function (response) {
                            if (response.id === null || response.id === undefined) {
                                self.success = false;
                                console.log("login failure");
                            } else {
                                console.log(response.id);
                                sharedProperties.setUser(response);
                                self.success = true;
                                self.user.first_name = response.firstName;
                                self.user.last_name = response.lastName;
                                console.log("login success");
                                $location.path("/home");
                            }
                        },
                        function (errResponse) {
                            console.error('Error while logging in.');
                        }
                    );

            };
}]);


