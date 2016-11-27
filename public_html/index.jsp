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

<div id="slogan">Index Page</div>

<div id="logo"><a href="#">Text File Analyzer</a></div>

</div>

<!--include menu, which is stored in the jsp directory-->
<c:import url="jsp/Menu.jsp"/>
<!--end header -->
<!-- main -->
<div id="main">

<div id="text">
<h1>Welcome</h1>

<h2>Unit 2</h2>
    <p><a href="/java112/properties">Properties Servlet</a></p>
    <p><a href="/java112/trivial">Trivial Servlet</a></p>
    <p><a href="/java112/first112">First 112 Servlet</a></p>

<h2>Unit 3</h2>
    <p><a href="myFirstJSP.jsp">Lab 1 First JSP</a></p>
    <p><a href="expressions.jsp">Team Presentation Expressions</a></p>
    <p><a href="testFunction.jsp">Test Function</a></p>
    <p><a href="Lab23JSP.jsp">Lab 23 JSP</a></p>
    <p><a href="/java112/lab33">Lab 33 Servlet</a></p>
    <p><a href="/java112/mvc-demo">Mvc Demo Lab</a></p>
    <p><a href="/java112/httpServlet?queryParameter=TestQP">HTTP Request Data</a></p>
    <p><a href="/java112/project3-properties">Project 3 Properties</a></p>
    <p><a href="/java112/TicTacPaw">MVC Team challenge</a></p>
    <p><a href="/java112/TicTacDiagram.jsp">MVC Team challenge Diagram</a></p>
<h2>Unit 4</h2>
    <p><a href="/java112/employeeSearchDispServlet">Employee Search</a></p>
    <p><a href="/java112/addEmplDispServlet">Add New Employee</a></p>    
    <!--<p><a href="jsp/jstl_lab1.jsp">JSTL Lab</a></p>--> 
    <p><a href="/java112/JSTLLab1Servlet">JSTL Lab</a></p> 


</div>
<!-- end main -->
<!-- footer -->
<c:import url="jsp/Footer.jsp"/>

<!-- end footer -->
</div>
</body>
</html>
