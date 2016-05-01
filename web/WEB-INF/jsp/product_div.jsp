<div ng-switch-when="topmenu_li_product" ng-controller="ProductController as pCtrl">
    <h1>Products</h1>
    <div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Product Name</th>
                <th>Product Description</th>
                <th>Photo Url</th>
                <th>Price</th>
                <th>Sell Unit</th>
                <th>Quantity</th>
                <th>Info</th>
            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="p in pCtrl.products" ng-click="console.log('clicked product');">
                <td><span ng-bind="p.productName"></span></td>
                <td><span ng-bind="p.productDescription"></span></td>
                <td><img style="height:100px; width:auto;" ng-src="{{p.photoUrl}}"></td>
                <td><span ng-bind="p.price"></span></td>
                <td><span ng-bind="p.sellUnit"></span></td>
                <td><span ng-bind="p.quantity"></span></td>
                <td><span><a ng-click="toggleModal()">i</a></span></td>
            </tr>
            </tbody>
        </table>
    </div>
</div>