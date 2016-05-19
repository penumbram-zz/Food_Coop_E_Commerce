<%--
  Created by IntelliJ IDEA.
  User: tolgacaner
  Date: 31/03/16
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>

<%--
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*,java.util.*" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    // New location to be redirected
    String site = new String("/FoodCoopApp");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
  %>
  </body>
</html>
--%>

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
    <div ng-controller="TopMenuCtrl">
      <div id='cssmenu'>
        <ul>
          <li ng-class="{active: opt.id === idSelectedMenuItem, last: opt.id == 'topmenu_li_contact'}" ng-repeat="opt in opts" ng-click="setItemSelected(opt.id)">
            <a ng-href="{{opt.href}}"><span>{{ opt.text }}</span></a>
          </li>
        </ul>
      </div>
    </div>
    <div ng-view></div>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
    <script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/controller/top_menu_controller.js' />"></script>
    <script src="<c:url value='/static/js/service/login_service.js' />"></script>
    <script src="<c:url value='/static/js/controller/login_controller.js' />"></script>
    <script src="<c:url value='/static/js/service/product_service.js' />"></script>
    <script src="<c:url value='/static/js/controller/product_controller.js' />"></script>
    <script src="<c:url value='/static/js/service/news_feed_service.js' />"></script>
    <script src="<c:url value='/static/js/controller/news_feed_controller.js' />"></script>
  </body>
</html>