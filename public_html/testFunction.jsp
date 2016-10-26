<!DOCTYPE html>
<html>
<body>
<%--JSP comments--%>
<%! int a = 2;%>
<%! String testS = "Coco";%>
<%! public int testMethod() {
        int x = 55;
        return x;
}%>

<button onclick="myFunction()">Click me</button>

<p id="demo"></p>

<%
    out.println("Your IP address is " + request.getRemoteAddr());
%>

<p>A function is triggered when the button is clicked. The function outputs some text in a p element with id="demo".</p>

<%= "The value of variable a is " + a %>
<br>
<%= "The value of a test string is " + testS%>
<br>
<%= "Testing method " + testMethod()%>

<script>
function myFunction() {
    document.getElementById("demo").innerHTML = "Hello World";
}
</script>

</body>
</html>