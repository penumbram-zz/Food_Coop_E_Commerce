'use strict';

App.controller('ProductController', ['$scope', 'ProductService', function($scope, ProductService) {
          var self = this;
          self.products=[];
              
          self.getAllProducts = function(){
              ProductService.getAllProducts()
                  .then(
                      function(p) {
                          self.products = p;
                      },
                      function(errResponse){
                          console.error('Error while fetching Currencies');
                      }
                  );
          };

          self.getAllProducts();

      }]);
