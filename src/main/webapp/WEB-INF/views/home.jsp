<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

    <h1>Spring MVC Download File Example</h1>

    <a href="<c:url value='/download/a'/>">Download file via servlet response.</a><br/>
    <a href="<c:url value='/download/b'/>">Download file via http entity.</a><br/>
    <a href="<c:url value='/download/c'/>">Download file via file system resource.</a><br/>
</body>
</html>
