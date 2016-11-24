<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <!--This is JSTL Lab Unit 4
        Author: Olena Collins
    -->
    <title>Unit 4 JSTL lab</title>

</head>

<body>
    <h1>Unit 4 JSTL Lab</h1>
    <c:set var="name" value="Buddy" scope="session"/>
    <p>"The name is " ${name}</p>

    <p>Testing loop</p>
    <p>The name from the servlet ${names.get(1)}</p>
    <c:out value="ArrayList size ${names.size()}"/>

    <table>
    <c:forEach var="name" items="${names}">
        <tr><td>${name}</td></tr>
    </c:forEach>
    </table>

    <c:out value="${'Trying c:out tag'}"/>

    <c:set var="age" value="40" scope="session"/>
    <p>"The age is" ${age}<p/>
    <c:if test="${age > 39}">
        <p>YOu are old!!</p>
    </c:if>

    <c:set var="grade" value="68" scope="session"/>
    <c:choose>
        <c:when test="${grade > 90}">Your grade is A</c:when>
        <c:when test="${grade > 80}">Your grade is B</c:when>
        <c:otherwise>OO! Failing!!</c:otherwise>
    </c:choose>


</body>
</html>