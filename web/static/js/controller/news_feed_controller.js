'use strict';

App.controller('NewsFeedController', ['$scope', '$rootScope', 'NewsFeedService', function($scope, $rootScope, NewsFeedService) {
          var self = this;
          self.news=[];
          $rootScope.idSelectedMenuItem = "topmenu_li_coop";
          self.getAllNews = function(){
              NewsFeedService.getAllNews()
                  .then(
                      function(p) {
                          self.news = p;
                      },
                      function(errResponse){
                          console.error('Error while fetching Currencies');
                      }
                  );
          };

           self.toggleModal = function(){
               //noinspection JSUnresolvedVariable
               console.log(n.name);
               //noinspection JSUnresolvedVariable
               console.log(n.description);
            };

          self.getAllNews();

      }]);
