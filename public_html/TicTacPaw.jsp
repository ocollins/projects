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
    <input type="hidden" name="sq0" id="sq0" value = "">
    <input type="hidden" name="sq1" id="sq1" value = "">
    <input type="hidden" name="sq2" id="sq2" value = "">
    <input type="hidden" name="sq3" id="sq3" value = "">
    <input type="hidden" name="sq4" id="sq4" value = "">
    <input type="hidden" name="sq5" id="sq5" value = "">
    <input type="hidden" name="sq6" id="sq6" value = "">
    <input type="hidden" name="sq7" id="sq7" value = "">
    <input type="hidden" name="sq8" id="sq8" value = "">
</form>

<p class="form_container">
    <!--<input type="button" name="sqbutt" value="" id="sqbutt" onClick="displayValue()"/>-->
    <button type="submit" name="but0" class="tictac" id="but0" value="X" onclick="displayValue0()">${myData.square[0]}</button>
    <button type="submit" name="but1" class="tictac" id="but1" value="X" onclick="displayValue1()">${myData.square[1]}</button>
    <button type="submit" name="but2" class="tictac" id="but2" value="X" onclick="displayValue2()">${myData.square[2]}</button><br>
    <button type="submit" name="but3" class="tictac" id="but3" value="X" onclick="displayValue3()">${myData.square[3]}</button>
    <button type="submit" name="but4" class="tictac" id="but4" value="X" onclick="displayValue4()">${myData.square[4]}</button>
    <button type="submit" name="but5" class="tictac" id="but5" value="X" onclick="displayValue5()">${myData.square[5]}</button><br>
    <button type="submit" name="but6" class="tictac" id="but6" value="X" onclick="displayValue6()">${myData.square[6]}</button>
    <button type="submit" name="but7" class="tictac" id="but7" value="X" onclick="displayValue7()">${myData.square[7]}</button>
    <button type="submit" name="but8" class="tictac" id="but8" value="X" onclick="displayValue8()">${myData.square[8]}</button>
</p>


<p class="instruction"><img src="images/instructions.jpg" alt="Click a box to play"></p>
 
<p class="catdogpic"><img src="images/catdog2.jpg"></p>

<label class="feedback">${myData.message}</label>
<form action="/java112/TicTacPaw" name="reset" id="reset" method="GET">
    <button type="submit" name="butreset" class="butreset" value="R">Start a New Game</button>
</form>

<script>
function displayValue0() {
    document.getElementById("sq0").value = "X";
    document.getElementById("ticform").submit();
}
function displayValue1() {
    document.getElementById("sq1").value = "X";
    document.getElementById("ticform").submit();
}
function displayValue2() {
    document.getElementById("sq2").value = "X";
    document.getElementById("ticform").submit();
}
function displayValue3() {
    document.getElementById("sq3").value = "X";
    document.getElementById("ticform").submit();
}
function displayValue4() {
    document.getElementById("sq4").value = "X";
    document.getElementById("ticform").submit();
}
function displayValue5() {
    document.getElementById("sq5").value = "X";
    document.getElementById("ticform").submit();
}
function displayValue6() {
    document.getElementById("sq6").value = "X";
    document.getElementById("ticform").submit();
}
function displayValue7() {
    document.getElementById("sq7").value = "X";
    document.getElementById("ticform").submit();
}
function displayValue8() {
    document.getElementById("sq8").value = "X";
    document.getElementById("ticform").submit();
}
</script>

<!-- footer -->
<div id="footer">

<!-- end footer -->
</div>
</body>
</html>