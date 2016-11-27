<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/employeeStyle.css" rel="stylesheet" type="text/css"/>
</head>

<body>

<h1 align="center">Add Employee</h1>


<div id="container">
<form action="/java112/addNewEmplServlet" name="" id="empladd" method="POST">
    <table class="addtable">
    <tr><td>Add Employee feedback message</td></tr>
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
    <tr><td><a href="/java112">HOME</a></td></tr>
    </table>
</form>
</div>

</body>
</html>
