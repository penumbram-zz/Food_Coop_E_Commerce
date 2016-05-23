'use strict';

App.factory('NewsService', ['$http', '$q', function($http, $q){

	return {
		getAllNews: function() {
			return $http.get('http://localhost:8080/news/')
				.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error('Error while fetching newss');
						return $q.reject(errResponse);
					}
				);
		},createNews: function(news){
			return $http.post('http://localhost:8080/news/', news)
				.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error('Error while creating news');
						return $q.reject(errResponse);
					}
				);
		},

		updateNews: function(news, id){
			console.log("updateNews is GETTING CALLED HERE");
			return $http.put('http://localhost:8080/news/'+id, news)
				.then(
					function(response){
						console.log(response);
						return response.data;
					},
					function(errResponse){
						console.error('Error while updating news');
						return $q.reject(errResponse);
					}
				);
		},

		deleteNews: function(id){
			return $http.delete('http://localhost:8080/news/'+id)
				.then(
					function(response){
						return response.data;
					},
					function(errResponse){
						console.error('Error while deleting news');
						return $q.reject(errResponse);
					}
				);
		}
	};

}]);
