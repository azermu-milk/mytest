<%--
  Created by IntelliJ IDEA.
  User: fantasy
  Date: 2021/4/21
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>list</title>
</head>
<body>
    <table cellpadding="10" cellspacing="0" border="2">
        <thead>
            <tr>
                <td>ID</td>
                <td>Name</td>
                <td>Age</td>
                <td>Region</td>
                <td>Edit</td>
                <td>Delete</td>
            </tr>
        </thead>
        <tbody>
            <s:iterator value="#request.useraList">
                <tr>
                    <td>${id}</td>
                    <td>${name}</td>
                    <td>${age}</td>
                    <td>${region.region}</td>
                    <td><a href="user-edit.action?id=${id}">Edit</a> </td>
                    <td><a href="user-delete.action?id=${id}">Delete</a> </td>
                </tr>
            </s:iterator>
        </tbody>
    </table>
</body>
</html>
