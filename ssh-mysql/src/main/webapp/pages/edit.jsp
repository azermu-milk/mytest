<%--
  Created by IntelliJ IDEA.
  User: fantasy
  Date: 2021/4/22
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>edit</title>
</head>
<body>
<br>
<s:debug></s:debug>
    <s:form action="user-update.action" method="POST">
        <s:hidden name="id"></s:hidden>
        <s:textfield name="name" label="Name"/><br>
        <s:textfield name="age" label="Age"/><br>
        <s:select list="#request.regionList" label="Region" name="region.id" listKey="id" listValue="region"/><br>
        <s:submit></s:submit>
    </s:form>
</body>
</html>
