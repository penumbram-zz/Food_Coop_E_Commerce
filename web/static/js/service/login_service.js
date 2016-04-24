/**
 * Created by tolgacaner on 25/04/16.
 */

'use strict';

App.factory('LoginService', ['$http', '$q', function($http, $q){

    return {
        login: function(email,pw) {
            return $http.get('http://localhost:8080/login?email='+email+'&password='+pw)
                .then(
                    function(response){
                        return response.data;
                    },
                    function(errResponse){
                        console.error('Error while fetching users');
                        return $q.reject(errResponse);
                    }
                );
        }
    };

}]);