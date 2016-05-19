'use strict';

App.factory('NewsFeedService', ['$http', '$q', function($http, $q){

	return {
		getAllNews: function() {
					return $http.get('http://localhost:8080/news/')
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
