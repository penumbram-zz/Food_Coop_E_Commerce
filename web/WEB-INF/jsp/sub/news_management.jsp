<div class="generic-container">
    <div class="panel panel-default">
        <div class="panel-heading"><span class="lead">News Management Panel </span></div>
        <div class="formcontainer">
            <form ng-submit="nCtrl.submit()" name="myForm" class="form-horizontal">
                <input type="hidden" ng-model="nCtrl.news.id" />

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="file">Name</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="nCtrl.news.name" name="name" class="username form-control input-sm" placeholder="Enter name" required ng-minlength="3"/>
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
                            <input type="text" ng-model="nCtrl.news.description" class="form-control input-sm" placeholder="Enter surname"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group col-md-12">
                        <label class="col-md-2 control-lable" for="file">Photo Url</label>
                        <div class="col-md-7">
                            <input type="text" ng-model="nCtrl.news.photoUrl" name="photo_url" class="form-control input-sm" placeholder="Type here..." required/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-actions floatRight">
                        <input type="submit"  value="{{!nCtrl.news.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                        <button type="button" ng-click="nCtrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Newss </span></div>
        <div class="tablecontainer">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>ID.</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Photo Url</th>
                </tr>
                </thead>
                <tbody>
                <tr ng-repeat="p in nCtrl.newsList">
                    <td><span ng-bind="p.id"></span></td>
                    <td><span ng-bind="p.name"></span></td>
                    <td><span ng-bind="p.description"></span></td>
                    <td><span ng-bind="p.photoUrl"></span></td>
                    <td>
                        <button type="button" ng-click="nCtrl.edit(p.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="nCtrl.remove(p.id)" class="btn btn-danger custom-width">Remove</button>
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>