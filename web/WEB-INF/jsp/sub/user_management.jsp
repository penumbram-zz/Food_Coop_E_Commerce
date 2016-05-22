<style>
    .username.ng-valid {
        background-color: lightgreen;
    }
    .username.ng-dirty.ng-invalid-required {
        background-color: red;
    }
    .username.ng-dirty.ng-invalid-minlength {
        background-color: yellow;
    }

    .email.ng-valid {
        background-color: lightgreen;
    }
    .email.ng-dirty.ng-invalid-required {
        background-color: red;
    }
    .email.ng-dirty.ng-invalid-email {
        background-color: yellow;
    }

</style>
      <div class="generic-container">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Administrator Panel </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.user.id" />

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">First Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.firstName" name="uname" class="username form-control input-sm" placeholder="Enter name" required ng-minlength="3"/>
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
                              <label class="col-md-2 control-lable" for="file">Last Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.lastName" class="form-control input-sm" placeholder="Enter surname"/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Password</label>
                              <div class="col-md-7">
                                  <input type="password" ng-model="ctrl.user.password" name="password" class="password form-control input-sm" placeholder="Enter password" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.email.$error.required">This is a required field</span>
                                      <span ng-show="myForm.email.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">E - Mail</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.email" name="email" class="email form-control input-sm" placeholder="Type here..." required/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Address Line 1</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.addressLine1" name="address_line_1" class="form-control input-sm" placeholder="Type here..." required/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Address Line 2</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.addressLine2" name="address_line_2" class="form-control input-sm" placeholder="Type here..." required/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">City</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.city" name="city" class="form-control input-sm" placeholder="Type here..." />
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Phone Number</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.phoneNumber" name="phone_number" class="form-control input-sm" placeholder="Type here..."/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">About</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.about" name="about" class="form-control input-sm" placeholder="Type here..."/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="file">Permission</label>
                              <div class="col-md-7">
                                  <input type="radio" ng-model="ctrl.user.permission" name="permission" value="MEMBER" checked/>Member<br>
                                  <input type="radio" ng-model="ctrl.user.permission" name="permission" value="ADMIN" checked/>Admin<br>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>


                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Users </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>Name</th>
                              <th>Surname</th>
                              <th>E-mail</th>
                              <th>Password</th>
                              <th>Address Line 1</th>
                              <th>Address Line 2</th>
                              <th>City</th>
                              <th>Phone Number</th>
                              <th>About</th>
                              <th>Action</th>
                              <th>Type</th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.users">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.firstName"></span></td>
                              <td><span ng-bind="u.lastName"></span></td>
                              <td><span ng-bind="u.email"></span></td>
                              <td><span ng-bind="u.password"></span></td>
                              <td><span ng-bind="u.addressLine1"></span></td>
                              <td><span ng-bind="u.addressLine2"></span></td>
                              <td><span ng-bind="u.city"></span></td>
                              <td><span ng-bind="u.phoneNumber"></span></td>
                              <td><span ng-bind="u.about"></span></td>
                              <td><span ng-bind="u.permission"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
