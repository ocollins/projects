<!DOCTYPE html>
<%!int fontSize=1;%>
<html>
<%--Home page Index page--%>
    <head>Olena's Index Page</head>
    <body>
        <nav>
            <ul>
                <li><a href="linkingDemo.html">Linking Demo</a></li>
            </ul>
        </nav>
        <p>Testing paragraph</p>
        <%out.println("Your IP address " + request.getRemoteAddr());%>
        <%!int i=34;%>
        <br>
        <%out.println("Variable i= " + i);%>
        <p>
            Today's date: <%= (new java.util.Date()).toLocaleString()%>
        </p>
        <% while(fontSize <= 3) {%>
            <font color="green" size= "<%= fontSize%>">JSP Tutorial</font> 
            <br>
            <%fontSize++;%>   
        <%}%>

        </body>        
</html>