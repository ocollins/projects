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

<form action="/java112/TicTacPaw" name="tic" id="ticform" method="GET">
    <p class="form_container">
<input type="button" name="sq0" value="" id="sq0" onClick="displayValue()"/>
        <button type="submit" name="sq00" class="tictac" id="sq00" value="X" onclick="displayValue()">${myData.square[0]}</button>
        <button type="submit" name="sq1" class="tictac" value="X"></button>
        <button type="submit" name="sq2" class="tictac" value="X"></button><br>
        <button type="submit" name="sq3" class="tictac" value="X"></button>
        <button type="submit" name="sq4" class="tictac" value="X"></button>
        <button type="submit" name="sq5" class="tictac" value="X"></button><br>
        <button type="submit" name="sq6" class="tictac" value="X"></button>
        <button type="submit" name="sq7" class="tictac" value="X"></button>
        <button type="submit" name="sq8" class="tictac" value="X"></button>
</p>
</form>

<p class="instruction"><img src="images/instructions.jpg" alt="Click a box to play"></p>
 
<p class="catdogpic"><img src="images/catdog2.jpg"></p>

<label class="feedback">${myData.message}</label>
<script>
function displayValue() {
    document.getElementById("sq0").value = "X";
    document.getElementById("ticform").submit();
    document.getElementById("sq0").value = ${myData.square[0]};
}
</script>

<!-- footer -->
<div id="footer">

<!-- end footer -->
</div>
</body>
</html>