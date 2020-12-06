<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>Ten User: ${User.userName }</h1>

<c:forEach items="${ Images}" var="item">
	<p>${ item.imageId}</p>
</c:forEach>
</body>
</html>