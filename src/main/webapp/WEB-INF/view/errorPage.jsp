<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if test="${sessionScope.locale == null}">
	<c:set var="locale" value="en_US" scope="session"/>
</c:if>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="pageContent"/>
<c:set var="currentPageCommand" value="/controller?command=loginPage" scope="session" />
<fmt:message key="general.appName" var="appName"/>
<fmt:message key="general.englishCode" var="en"/>
<fmt:message key="general.russianCode" var="ru"/>
<fmt:message key="general.belarusianCode" var="bel"/>
<fmt:message key="authorisation.loginLocale" var="loginLocale"/>
<fmt:message key="authorisation.passwordLocale" var="passwordLocale"/>
<fmt:message key="authorisation.signInLocale" var="signInLocale"/>

<html>
<head>
	<title> Online training </title>
	<link rel="stylesheet" href="static/styles/styleLogin.css"/>
	<link rel="icon" type="image/x-icon" href="static/resources/studying-blue.png">
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<header>
	<p><img src="static/resources/icon-studying.png" width="40" height="37" style="margin-left:14px;" align="middle"> Online	training<p/>
</header>

<div style="overflow:auto;">
	<div class="main">
		<h2 style="text-align:center;">ERROR!</h2>
		<div class="container">
			<div style="color:red; font-size:32px">${errorMessage}</div>
			<br>
		</div>
	</div>
</div>

<footer>
	<p>Contact us: +375 29 908 20 20</p>
</footer>

</body>
</html>