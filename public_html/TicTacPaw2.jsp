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
        <button type="submit" name="sq0" class="tictac" value=" " 
                onclick="displayValue0()">${myData.square[0]}</button>
        <button type="submit" name="sq1" class="tictac" value=" " 
                onclick="displayValue1()">${myData.square[1]}</button>
        <button type="submit" name="sq2" class="tictac" value=" " 
                onclick="displayValue2()">${myData.square[2]}</button><br>
        <button type="submit" name="sq3" class="tictac" value=" " 
                onclick="displayValue3()">${myData.square[3]}</button>
        <button type="submit" name="sq4" class="tictac" value=" " 
                onclick="displayValue4()">${myData.square[4]}</button>
        <button type="submit" name="sq5" class="tictac" value=" " 
                onclick="displayValue5()">${myData.square[5]}</button><br>
        <button type="submit" name="sq6" class="tictac" value=" " 
                onclick="displayValue6()">${myData.square[6]}</button>
        <button type="submit" name="sq7" class="tictac" value=" " 
                onclick="displayValue7()">${myData.square[7]}</button>
        <button type="submit" name="sq8" class="tictac" value=" " 
                onclick="displayValue8()">${myData.square[8]}</button>
  </p>
</form>

<p class="instruction"><img src="images/instructions.jpg" alt="Click a box to play"></p>
 
<p class="catdogpic"><img src="images/catdog2.jpg"></p>

<label class="feedback">${myData.message}</label>

<script>
function displayValue0() {
    document.getElementById("sq0").value = "X";
}
function displayValue1() {
    document.getElementById("sq1").value = "X";
}
function displayValue2() {
    document.getElementById("sq2").value = "X";
}
function displayValue3() {
    document.getElementById("sq3").value = "X";
}
function displayValue4() {
    document.getElementById("sq4").value = "X";
}
function displayValue5() {
    document.getElementById("sq5").value = "X";
}
function displayValue6() {
    document.getElementById("sq6").value = "X";
}
function displayValue7() {
    document.getElementById("sq7").value = "X";
}
function displayValue8() {
    document.getElementById("sq8").value = "X";
}
</script>

<!-- footer -->
<div id="footer">

<!-- end footer -->
</div>
</body>
</html>