<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<!--

-->
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Tic Tac Paws</title>
    <link href="css/pawsStyle.css" rel="stylesheet" type="text/css"/>
</head>

<body>
<div id="container">
    <!-- header -->
<div id="header">
</div>
</div>


<h1 class="pageHeader"><img src="images/header.PNG" alt="Tic Tac Paws"></h1>

<form action="/java112/TicTacPawsServlet" method="GET">
<p class="form_container">
<INPUT TYPE="button" NAME="sqr1" class="tictac" value="     " onClick="value ='1'">
<INPUT TYPE="button" NAME="sqr2" class="tictac" value="     " onClick="value ='1'">
<INPUT TYPE="button" NAME="sqr3" class="tictac" value="     " onClick="value ='1'"><br />
<INPUT TYPE="button" NAME="sqr4" class="tictac" value="     " onClick="value ='1'">
<INPUT TYPE="button" NAME="sqr5" class="tictac" value="     " onClick="value ='1'">
<INPUT TYPE="button" NAME="sqr6" class="tictac" value="     " onClick="value ='1'"><br />
<INPUT TYPE="button" NAME="sqr7" class="tictac" value="     " onClick="value ='1'">
<INPUT TYPE="button" NAME="sqr8" class="tictac" value="     " onClick="value ='1'">
<INPUT TYPE="button" NAME="sqr9" class="tictac" value="     " onClick="value ='1'">
</p>
</form>

<p class="instruction"><img src="images/instructions.jpg" alt="Click a box to play"></p>
 
<p class="catdogpic"><img src="images/catdog2.jpg"></p>

<label class="feedback">${ticTac.message}</label>


<!-- footer -->
<div id="footer">

<!-- end footer -->
</div>
</body>
</html>