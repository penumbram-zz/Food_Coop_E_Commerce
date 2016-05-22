'use strict';

App.controller('ProductController', ['$scope', '$rootScope', 'ProductService', 'ngDialog','sharedProperties', function($scope, $rootScope, ProductService, ngDialog,sharedProperties) {
    $rootScope.idSelectedMenuItem = "topmenu_li_product";
    var self = this;
    self.products=[];
    self.producers=[];
    self.product = null;
    self.producer = null;
    self.isSalesSession = false;

    /*
    var user = sharedProperties.getUser();
    if (user.permission == "ADMIN") {
    console.log("User is an Admin, This is a Sale session then");
    self.isSalesSession = true;
    }
    */
    
    self.fetchAllProducts = function(){
        ProductService.getAllProducts()
            .then(
                function(p) {
                    self.products = p.products;
                    self.producers = p.producers;
                },
                function(errResponse){
                    console.error('Error while fetching Products');
                }
            );
    };

    self.createProduct = function(product){
        ProductService.createProduct(product)
            .then(
                self.fetchAllProducts,
                function(errResponse){
                    console.error('Error while creating Product.');
                }
            );
    };

    self.updateProduct = function(product, id){
        console.log("updating product in ASDASD");
        product.producer.id = self.producer.id;
        product.producer.firstName = self.producer.firstName;
        product.producer.lastName = self.producer.lastName;
        console.log(product.producer.firstName + " " + product.producer.lastName);
        ProductService.updateProduct(product, id)
            .then(
                self.fetchAllProducts,
                function(errResponse){
                    console.error('Error while updating Product.');
                }
            );
    };

    self.deleteProduct = function(id){
        ProductService.deleteProduct(id)
            .then(
                self.fetchAllProducts,
                function(errResponse){
                    console.error('Error while deleting Product.');
                }
            );
    };

    self.fetchAllProducts();

    self.submit = function() {
        if(self.product.id==null){
            self.createProduct(self.product);
        }else{
            self.updateProduct(self.product, self.product.id);
            console.log('Product updated with id ', self.product.id);
        }
        self.reset();
    };

    self.edit = function(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.products.length; i++){
            if(self.products[i].id == id) {
                self.product = angular.copy(self.products[i]);
                self.producer = self.product.producer;
                $scope.update(self.producer);
                break;
            }
        }
    };

    self.remove = function(id){
        console.log('id to be deleted', id);
        if(self.product.id === id) {//clean form if the product to be deleted is shown there.
            self.reset();
        }
        self.deleteProduct(id);
    };


    self.reset = function(){
        self.product = null;
        self.producer = null;
        $scope.myForm.$setPristine(); //reset Form
    };

    self.toggleModal = function(){
        //noinspection JSUnresolvedVariable
        console.log(product.productName);
        //noinspection JSUnresolvedVariable
        console.log(product.productDescription);
    };

    self.fetchAllProducts();

    $scope.showProducer = function(msg) {
        ngDialog.open({ template: 'popupTmpl', className: 'ngdialog-theme-default', data: msg });
    };

    $scope.update = function(val)
    {
        self.producer = val;
        $scope.selected = val;
        // use $scope.selectedItem.code and $scope.selectedItem.name here
        // for other stuff ...
    }.bind($scope);
    /*
    $scope.onOffSwitch = function (val) {
    self.isSalesSession = false;
    }
    */

}]);
