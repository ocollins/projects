<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link href="css/employeeStyle.css" rel="stylesheet" type="text/css"/>
</head>

<script>
function check(searchType) {
    document.getElementById("answer").value=browser;
    var input = document.createElement("input");
    input.type = "text";
    document.body.appendChild(input);
}
</script>

<body>

<h1 align="center">Employee Search</h1>

<div id="container">
<form action="/java112/employeeSearchResServlet" name="" id="emplsearch" method="GET">
    <table class="searchtable">
    <tr><td><label for="byId">Search Employee by ID</label></td>
        <td><input type="radio" name="searchType" id="byId" value="I" required></td>
    </tr>
    <tr><td><label for="byId">Search Employee by Last Name</label></td>
        <td><input type="radio" name="searchType" id="byLastName" value="N" required></td>
    </tr>
    <tr><td><label for="termText">Employee ID or Last Name</label></td>
        <td><input type="text" name="searchTerm" id="termText" value = "" required></td>
    </tr>
    <tr><td class="submitButton"><input type="submit" value="Submit"></td></tr>
    </table>
</form>
</div>
</body>
</html>
