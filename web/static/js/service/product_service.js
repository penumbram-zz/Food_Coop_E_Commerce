'use strict';

App.factory('ProductService', ['$http', '$q', function($http, $q){

	return {
		getAllProducts: function() {
					return $http.get('http://localhost:8080/product/')
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
