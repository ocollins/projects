<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/employeeStyle.css" rel="stylesheet" type="text/css"/>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>

<h1 align="center">Add Employee</h1>

<div id="container">

<c:if test="${not empty feedbackMessage}">
    <p align="center" class="fmessage">${feedbackMessage}</p>
</c:if>

<form action="/java112/addNewEmplServlet" name="" id="empladd" method="POST">
    <c:if test="${empty feedbackMessage}">
    <table class="addtable" id="addtable">
        <tr><td>Employee First Name</td>
            <td><input type="text" name="fname" id="fName" value="" required></td>
        </tr>
        <tr><td>Employee Last Name</td>
            <td><input type="text" name="lname" id="lName" value="" required></td>
        </tr>
        <tr><td>Social Security Number</td>
            <td><input type="text" name="ssn" id="ssn" value="" required></td>
        </tr>
        <tr><td>Department</td>
            <td><input type="text" name="department" id="dept" value="" required></td>
        </tr>
        <tr><td>Room Number</td>
            <td><input type="text" name="room" id="room" value="" required></td>
        </tr>
        <tr><td>Phone Number</td>
            <td><input type="text" name="phone" id="phone" value="" required></td>
        </tr>
        <tr class="submitButton"><td ><input type="submit" value="Submit"></td></tr>
    </table>
    </c:if>
</form>
<p class="home"><a href="/java112">HOME</a></p>
</div>

</body>
</html>
