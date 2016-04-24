<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>Welcome to Food-Coop</title>
      <link rel="shortcut icon" href="data:image/x-icon;," type="image/x-icon">
      <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
      <link rel="stylesheet" href="/static/css/cssmenu.css">
  </head>
  <body ng-app="myApp">
  <div ng-app ng-controller="TopMenuCtrl">
      <div id='cssmenu'>
          <ul>
              <li ng-class="{active: opt.id === idSelectedMenuItem, last: opt.id == 'topmenu_li_contact'}" ng-repeat="opt in opts" ng-click="setItemSelected(opt.id)">
                  <a href='#'><span>{{ opt.text }}</span></a>
              </li>
          </ul>
      </div>
      <div ng-switch on="idSelectedMenuItem">
          <div ng-switch-when="topmenu_li_home">
              <div style="width: 300px;" ng-controller="LoginController as ctrl">
                  <div class="login">
                      <h1>Login</h1>
                      <form name="form" ng-submit="ctrl.login()" role="form">
                          <div class="form-group">
                              <label for="username">Username</label>
                              <i class="fa fa-key"></i>
                              <input type="text" name="username" id="username" class="form-control" ng-model="username" required />
                              <span ng-show="form.username.$dirty && form.username.$error.required" class="help-block">Username is required</span>
                          </div>
                          <div class="form-group">
                              <label for="password">Password</label>
                              <i class="fa fa-lock"></i>
                              <input type="password" name="password" id="password" class="form-control" ng-model="password" required />
                              <span ng-show="form.password.$dirty && form.password.$error.required" class="help-block">Password is required</span>
                          </div>
                          <div class="form-actions">
                              <button type="submit" ng-disabled="form.$invalid || dataLoading" class="btn btn-danger">Login</button>
                          </div>
                      </form>
                  </div>
              </div>
          </div>
          <div ng-switch-when="topmenu_li_product"><h1>Product Div</h1></div>
          <div ng-switch-when="topmenu_li_coop"><h1>Co-Op Div</h1></div>
          <div ng-switch-when="topmenu_li_contact"><h1>Contact Div</h1></div>
      </div>
  </div>
  <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
  <script src="<c:url value='/static/js/app.js' />"></script>
  <script src="<c:url value='/static/js/controller/top_menu_controller.js' />"></script>
  <script src="<c:url value='/static/js/controller/login_controller.js' />"></script>
  </body>
</html>