<div class="generic-container">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">Product Management Panel </span></div>
        <div class="formcontainer">
            <form ng-submit="pmCtrl.submit()" name="myForm" class="form-horizontal">
                <input type="hidden" ng-model="pmCtrl.product.id" />

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="file">Name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="pmCtrl.product.productName" name="productName" class="username form-control input-sm" placeholder="Enter name" required ng-minlength="3"/>
                            <div class="has-error" ng-show="myForm.$dirty">
                                <span ng-show="myForm.uname.$error.required">This is a required field</span>
                                <span ng-show="myForm.uname.$error.minlength">Minimum length required is 3</span>
                                <span ng-show="myForm.uname.$invalid">This field is invalid </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="file">Description</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="pmCtrl.product.productDescription" class="form-control input-sm" placeholder="Enter surname"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="file">Photo Url</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="pmCtrl.product.photoUrl" name="photo_url" class="form-control input-sm" placeholder="Type here..." required/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="file">Price</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="pmCtrl.product.price" name="price" class="form-control input-sm" placeholder="Type here..." required/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="file">Quantity</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="pmCtrl.product.quantity" name="quantity" class="form-control input-sm" placeholder="Type here..." />
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="file">Sell Unit</label>
                        <div class="col-md-7">
                            <input type="radio" ng-model="pmCtrl.product.sellUnit" name="sellUnit" value="KG" checked/>By Kg<br>
                            <input type="radio" ng-model="pmCtrl.product.sellUnit" name="sellUnit" value="PIECE" checked/>By Piece<br>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="file">Producer</label>
                        <div class="col-md-7">
                            <select ng-model="selected" ng-options='producer as (producer.firstName + " " + producer.lastName) for producer in pmCtrl.producers' ng-change="update(producer)"><!--ng-repeat="producer in pmCtrl.producers"-->
                               <!-- <option ng-selected="pmCtrl.producer.id == producer.id" >{{producer.firstName}} {{producer.lastName}}</option>-->
                            </select>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit"  value="{{!pmCtrl.product.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                        <button type="button" ng-click="pmCtrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Products </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID.</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Photo Url</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Sell Unit</th>
                    <th>Producer</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="p in pmCtrl.products">
                    <td><span ng-bind="p.id"></span></td>
                    <td><span ng-bind="p.productName"></span></td>
                    <td><span ng-bind="p.productDescription"></span></td>
                    <td><span ng-bind="p.photoUrl"></span></td>
                    <td><span ng-bind="p.price"></span></td>
                    <td><span ng-bind="p.quantity"></span></td>
                    <td><span ng-bind="p.sellUnit"></span></td>
                    <td><span>{{p.producer.firstName}} {{p.producer.lastName}}</span></td>
                    <td>
                        <button type="button" ng-click="pmCtrl.edit(p.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="pmCtrl.remove(p.id)" class="btn btn-danger custom-width">Remove</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
