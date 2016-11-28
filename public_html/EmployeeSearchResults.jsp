<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
 This is Employee Search Results display page
-->
<html xmlns="http://www.w3.org/1999/xhtml">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/employeeStyle.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<h1 align="center">Employee Search Result</h1>
<p>${searchResult.employeeFound}</p>

<c:if test="${searchResult.employeeFound}">
    <p>Found an employee</p>
</c:if>

<div id="container">
    <table class="resulttable">
    <c:if test="${searchResult.employeeFound}">
        <c:forEach var="employee" items="${searchResult.employees.employeeId}">
        <tr><td>Search type </td>
            <td>${searchResult.searchType}</td>
        </tr>
        <tr><td>Search term</td>
            <td>${searchResult.searchTerm}</td>
        </tr>
        </c:forEach>
    </c:if>
    </table>
</div>
<p text-align="center"><a href="/java112">HOME</a></p>
</body>
</html>
