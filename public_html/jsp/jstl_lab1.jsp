<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <!--This is JSTL Lab Unit 4
        Author: Olena Collins
    -->
    <title>Unit 4 JSTL lab</title>

</head>

<c:set var="name" value="Buddy" scope="session"/>
<body>
    <h1>Unit 4 JSTL Lab</h1>
    
    <p>"The name is " ${name}</p>


</body>
</html>