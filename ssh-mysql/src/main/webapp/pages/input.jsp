<%--
  Created by IntelliJ IDEA.
  User: fantasy
  Date: 2021/4/21
  Time: 20:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>add</title>
</head>
<body>
    <h3>add</h3>
    <br>
    <s:debug></s:debug>

    <br>
    <s:form action="user-insert.action" method="POST">
        <s:textfield name="name" label="Name"/><br>
        <s:textfield name="age" label="Age"/><br>
        <s:select list="#request.regionList" label="Region" name="region.id" listKey="id" listValue="region"/><br>
        <s:submit></s:submit>
    </s:form>
</body>
</html>
