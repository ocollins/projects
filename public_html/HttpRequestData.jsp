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

    <div id="logo"><a href="#">HTTP Request Data</a></div>
</div>

<div id="menu">
<ul>
<li><a href="#">Home</a></li>
<li><a href="#">About Us</a></li>
<li><a href="#">Services</a></li>
<li><a href="#">Portfolio</a></li>
</ul>
</div>

<ul class = "requestData">
<li><strong>Remote computer name</strong> 
    <span>${HttpRequstData.remoteComputerName}</span></li>

<li><strong>Remote computer address</strong>
    <span>${HttpRequstData.remoteComputerAddress}</span></li>

<li><strong>HTTP method of the request</strong>
    <span>${HttpRequstData.httpMethod}</span> </li>

<li><strong>Request URI</strong>
    <span>${HttpRequstData.requestURI}</span></li>

<li><strong>Request URL</strong>
    <span>${HttpRequstData.requestURL}</span> </li>

<li><strong>Protocol of the request</strong>
    <span>${HttpRequstData.protocol}</span> </li>

<li><strong>Server name</strong>
    <span>${HttpRequstData.serverName}</span> </li>

<li><strong>Server port</strong>
    <span>${HttpRequstData.serverPort}</span> </li>

<li><strong>Current Locale</strong>
    <span>${HttpRequstData.currLocale}</span> </li>

<li><strong>Query String</strong>
    <span>${HttpRequstData.queryString}</span></li>

<li><strong>Query parameter</strong>
    <span>${HttpRequstData.queryParam}</span> </li>

<li><strong>User-Agent</strong>
    <span>${HttpRequstData.userAgent}</span> </li>

</ul>

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