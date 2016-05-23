'use strict';

App.controller('NewsFeedController', ['$scope', '$rootScope', 'NewsService', function($scope, $rootScope, NewsService) {
          var self = this;
          self.newsList=[];
          self.news = null;
          $rootScope.idSelectedMenuItem = "topmenu_li_coop";
          self.fetchAllNews = function(){
              NewsService.getAllNews()
                  .then(
                      function(p) {
                          self.newsList = p;
                      },
                      function(errResponse){
                          console.error('Error while fetching Currencies');
                      }
                  );
          };

    self.createNews = function(news){
        NewsService.createNews(news)
            .then(
                self.fetchAllNews,
                function(errResponse){
                    console.error('Error while creating News.');
                }
            );
    };

    self.updateNews = function(news, id){
        NewsService.updateNews(news, id)
            .then(
                self.fetchAllNews,
                function(errResponse){
                    console.error('Error while updating News.');
                }
            );
    };

    self.deleteNews = function(id){
        NewsService.deleteNews(id)
            .then(
                self.fetchAllNews,
                function(errResponse){
                    console.error('Error while deleting News.');
                }
            );
    };

    self.fetchAllNews();

    self.submit = function() {
        if(self.news.id == null){
            self.createNews(self.news);
        }else{
            self.updateNews(self.news, self.news.id);
            console.log('News updated with id ', self.news.id);
        }
        self.reset();
    };

    self.edit = function(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.newsList.length; i++){
            if(self.newsList[i].id == id) {
                self.news = angular.copy(self.newsList[i]);
                break;
            }
        }
    };

    self.remove = function(id){
        console.log('id to be deleted', id);
        if (!isNull(self.news))
        {
            if(self.news.id === id) {//clean form if the news to be deleted is shown there.
                self.reset();
            }
        }
        self.deleteNews(id);
    };


    self.reset = function(){
        self.news = null;
        self.producer = null;
        $scope.myForm.$setPristine(); //reset Form
    };

           self.toggleModal = function(){
               //noinspection JSUnresolvedVariable
               console.log(n.name);
               //noinspection JSUnresolvedVariable
               console.log(n.description);
            };

          self.fetchAllNews();

      }]);
