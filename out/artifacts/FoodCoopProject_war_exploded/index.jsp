<%--
  Created by IntelliJ IDEA.
  User: tolgacaner
  Date: 31/03/16
  Time: 23:45
  To change this template use File | Settings | File Templates.
--%>
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
