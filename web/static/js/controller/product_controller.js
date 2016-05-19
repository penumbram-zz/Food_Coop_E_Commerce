'use strict';

App.controller('ProductController', ['$scope', 'ProductService', 'ngDialog', function($scope, ProductService, ngDialog) {
          var self = this;
          self.products=[];
              
          self.getAllProducts = function(){
              ProductService.getAllProducts()
                  .then(
                      function(p) {
                          self.products = p;
                      },
                      function(errResponse){
                          console.error('Error while fetching Products');
                      }
                  );
          };

           self.toggleModal = function(){
               //noinspection JSUnresolvedVariable
               console.log(product.productName);
               //noinspection JSUnresolvedVariable
               console.log(product.productDescription);
            };

          self.getAllProducts();

            $scope.showProducer = function(msg) {
                ngDialog.open({ template: 'popupTmpl', className: 'ngdialog-theme-default', data: msg });
            };

      }]);
