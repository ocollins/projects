<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
-->
<html xmlns="http://www.w3.org/1999/xhtml">
<!--include head element, which is stored in jsp directory-->
<c:import url="jsp/Head.jsp"/>

<body>
<div id="container">
<!-- header -->
<div id="header">

<div id="slogan">Unit 4 Session lab</div>

<div id="logo"><a href="#">Unit 4 Session Lab</a></div>

</div>

<!--include menu, which is stored in the jsp directory-->
<c:import url="jsp/Menu.jsp"/>
<!--end header -->
<!-- main -->
<div id="main">

<div id="text">
<h1>Session Lab</h1>

<p>Session Counter: ${project4SessionCounter}</p>

<p class="home"><a href="/java112">HOME</a></p>
</div>
<!-- end main -->
<!-- footer -->
<c:import url="jsp/Footer.jsp"/>

<!-- end footer -->
</div>
</body>
</html>
