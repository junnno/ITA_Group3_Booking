<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="en">
<head>

<spring:url value="/app.js" var="mainJs" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Integ</title>
<script src="http://cdn.sencha.com/ext/gpl/4.2.1/ext-all.js"></script>
<script src="http://cdn.sencha.com/ext/gpl/4.2.1/ext-theme-neptune.js"></script>
<script src="<c:url value='/extjs/ext-debug.js' />" type="text/javascript"></script>
<link rel="stylesheet"
	href="http://cdn.sencha.com/ext/gpl/4.2.1/packages/ext-theme-neptune/build/resources/ext-theme-neptune-all.css">
<script src="${mainJs}"></script>
</head>
<body></body>
</html>