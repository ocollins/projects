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

<c:choose>
 <c:when test="${searchResult.employeeFound}">
  <div id="container">
   <table class="resulttable">
    <th>Employee ID</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>SSN</th>
    <th>Department</th>
    <th>Room Number</th>
    <th>Phone Number</th>
    <c:forEach var="employee" items="${searchResult.employees}">
     <tr class="displayresults"><td>${employee.employeeId}</td>
                                <td>${employee.firstName}</td>
                                <td>${employee.lastName}</td>
                                <td>${employee.socNumber}</td>
                                <td>${employee.department}</td>
                                <td>${employee.room}</td>
                                <td>${employee.phone}</td>
     </tr>
    </c:forEach>
   </table>
  </div>
 </c:when>
 <c:otherwise>
    <h2 class="noemployeemessage">No Employee found</h2>
 </c:otherwise>   
</c:choose>

<p class="home"><a href="/java112">HOME</a></p>
</body>
</html>
