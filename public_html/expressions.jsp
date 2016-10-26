<!DOCTYPE html>
<html>
<head>
<title>Expression Presentation</title>
</head>
<link href="expressions.css" rel="stylesheet" type="text/css"/>

<body bgcolor="#ccddff ">

<h1>JSP Expressions</h1>

<ul>
    <li>Used to insert values directly into the output</li>
    <li>Evaluated and sent to the client each time the page is requested</li>
    <li>Evaluation is performed at runtime</li>
</ul>

<hr>

<h2><strong>Syntax</strong></h2>
<p> &lt;%= Java Value %&gt; </p>
<p>No semicolon to end the expression!!</p>


<hr>

<h2><strong>Example 1</strong></h2>
<p> &lt;%= new java.util.Date() %&gt;</p>

<button onclick="myFunction1()">Run</button>
<p id="ex1" class = "example1"><%= new java.util.Date() %></p>

<hr>

<h2><strong>Example 2</strong></h2>
<p>&lt;%= Math.random()%&gt;</p>
<button onclick="myFunction2()">Run</button>
<p id="ex2" class="example2"><%= Math.random()%></p>

<hr>

<h2><strong>JSP Translator</strong></h2>
<p>JSP Expressions become print(or write) statements in the servlet that results from the JSP page.</p>
<p>Whereas HTML becomes print statments with double quotes, JSP expressions</p>
<p>become print statements with no quotes.</p>
<button onclick="myFunction3()">Run</button>
<p id="sDisp" class="servletDisplay">
    <span>public void <strong>_jspService</strong>(HttpServletRequest request,
    HttpServletResponse response)</span> <br>
    <span class="sp1">ServletException, IOException { </span><br>
    <span>...</span> <br><br>
    <span>response.setContentType("text/html");</span> <br>
    <span>HttpSession session = request.getSession();</span> <br>
    <span>JspWriter out = response.getWriter(); </span><br>
    <span><strong>out.println(Math.random());</strong></span><br><br>
    <span>...</strong><br>
}</p>

<p>5.Explain best practices</p>
<p>6.Explain any drawback to the concept, i.e., what shouldn&apos;t it be used for?</p>


<script>
function myFunction1() {
    document.getElementById("ex1").style.display = "block";
}

function myFunction2() {
    document.getElementById("ex2").style.display = "block";
}

function myFunction3() {
    document.getElementById("sDisp").style.display = "block";
}
</script>

</body>
</html>