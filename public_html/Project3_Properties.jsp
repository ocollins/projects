<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <link href="style.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<div id="container">
    <!-- header -->
    <div id="header">

    <div id="logo"><a href="#">Project 3 Properties</a></div>
</div>

<div id="menu">
<ul>
<li><a href="#">Home</a></li>
<li><a href="#">About Us</a></li>
<li><a href="#">Services</a></li>
<li><a href="#">Portfolio</a></li>
</ul>
</div>

<h1 class="project3Properties">${myProject3Properties.getProperty("application.name")}</h1>

<table class="propertiesTable">
    <tr><td><strong>Author </strong></td>
    <td>${myProject3Properties.getProperty("author")}</td></tr>

    <tr><td><strong>Email </strong></td>
    <td>${myProject3Properties.getProperty("author.email.address")}</td></tr>

    <tr><td><strong>Course </strong></td>
    <td>${myProject3Properties.getProperty("course.title")}</td></tr>

    <tr><td><strong>Meeting Days </strong></td>
    <td>${myProject3Properties.getProperty("course.meeting")}</td></tr>

    <tr><td><strong>Instuctor </strong></td>
    <td>${myProject3Properties.getProperty("instructor.name")}</td></tr>

    <tr><td><strong>Project Description </strong></td>
    <td>${myProject3Properties.getProperty("project.description1")}</td></tr>

    <tr><td></td>
    <td>${myProject3Properties.getProperty("project.description2")}</td></tr>

    <tr><td></td>
    <td>${myProject3Properties.getProperty("project.description3")}</td></tr>

    <tr><td></td>
    <td>${myProject3Properties.getProperty("project.description4")}</td></tr>

    <tr><td></td>
    <td>${myProject3Properties.getProperty("project.description5")}</td></tr>

    <tr><td></td>
    <td>${myProject3Properties.getProperty("project.description6")}</td></tr>

    <tr><td></td>
    <td>${myProject3Properties.getProperty("project.description7")}</td></tr>

    <tr><td></td>
    <td>${myProject3Properties.getProperty("project.description8")}</td></tr>
</table>

<p><a href="/java112">HOME</a></p>

<!-- footer -->
<div id="footer">

<div id="footer_left">&copy; Copyright 2009 Your Website</div>

<div id="footer_right">
<!-- Please do not change or delete these links. Read the license! Thanks. :-) -->
Design by <a href="http://www.designity.org/">Free Web Design Community</a>, 
Courtesy <a href="http://www.openwebdesign.org" target="_blank">OWD</a>, Thanks to 
<a href="http://www.ecommercewebsites.com.au/" target="_blank">Web Design</a>
</div>

</div>
<!-- end footer -->
</div>
</body>
</html>