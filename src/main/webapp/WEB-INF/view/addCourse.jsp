<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:if test="${sessionScope.locale == null}">
    <c:set var="locale" value="en_US" scope="session"/>
</c:if>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="pageContent"/>
<c:set var="currentPageCommand" value="/controller?command=mainPageCommand" scope="session" />
<fmt:message key="general.appName" var="appName"/>
<fmt:message key="general.englishCode" var="en"/>
<fmt:message key="general.russianCode" var="ru"/>
<fmt:message key="general.belarusianCode" var="bel"/>
<fmt:message key="general.commitChanges" var="commitChanges"/>
<fmt:message key="general.cancel" var="cancel"/>

<fmt:message key="authorisation.loginLocale" var="loginLocale"/>
<fmt:message key="authorisation.passwordLocale" var="passwordLocale"/>
<fmt:message key="authorisation.signInLocale" var="signInLocale"/>

<fmt:message key="navigation.onlineTraining" var="onlineTraining"/>
<fmt:message key="navigation.mainPageTitle" var="mainPageTitle"/>
<fmt:message key="navigation.mainPageText" var="mainPageText"/>
<fmt:message key="navigation.manageCourses" var="manageCourses"/>
<fmt:message key="navigation.courseCreationForm" var="courseCreationForm"/>
<fmt:message key="navigation.assignTeacher" var="assignTeacher"/>
<fmt:message key="navigation.courseJournalAdmin" var="courseJournalAdmin"/>
<fmt:message key="navigation.manageTasks" var="manageTasks"/>
<fmt:message key="navigation.taskChecking" var="taskChecking"/>
<fmt:message key="navigation.courseJournalTeacher" var="courseJournalTeacher"/>
<fmt:message key="navigation.chooseACourse" var="chooseACourse"/>
<fmt:message key="navigation.taskInformation" var="taskInformation"/>

<fmt:message key="courses" var="courses"/>
<fmt:message key="courses.teacherId" var="teacherId"/>
<fmt:message key="courses.courseTitle" var="courseTitle"/>
<fmt:message key="courses.startDate" var="startDate"/>
<fmt:message key="courses.endDate" var="endDate"/>
<fmt:message key="courses.price" var="price"/>

<html>
<head>
    <title> Online training </title>
    <link rel="stylesheet" href="static/styles/style.css"/>
    <link rel="icon" type="image/x-icon" href="static/resources/studying-blue.png">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
</head>
<body>

<header>
    <ul style="float:right;">
        <li class="dropdown">
            <form method="post" action="controller?command=changeLanguageCommand">
                <button id="language-change">
                    <img src="static/resources/globe.png" width="20" height="20">
                </button>
                <div class="dropdown-content">
                    <button class="lng-content" name="locale" value="en_US">${en}</button>
                    <button class="lng-content" name="locale" value="ru_RU">${ru}</button>
                    <button class="lng-content" name="locale" value="bel_BEL">${bel}</button>
                </div>
            </form>
        </li>

        <li>
            <form method="post" action="controller?command=logOutCommand">
                <button id="logOut">
                    <img src="static/resources/icon-logout.png" width="20" height="20">
                </button>
            </form>
        </li>
    </ul>
    <form method="post" action="controller?command=mainPage">
        <button type="submit" id="logo">
            <img src="static/resources/icon-studying.png" width="40" height="37" style="margin-left:14px;"> Online training
        </button>
    </form>
</header>

<div style="overflow:auto;">
    <div class="menu">
        <div class="btn-group">
            <form method="get" action="controller?">
                <c:choose>
                    <c:when test="${sessionScope.user.role == 'ADMIN'}">
                        <button class="button" name="command" value="manageCoursesPage">${manageCourses}</button>
                        <button class="button" name="command" value="courseJournalAdminPage">${courseJournalAdmin}</button>
                    </c:when>
                    <c:when test="${sessionScope.user.role == 'TEACHER'}">
                        <button class="button" name="command" value="manageTasksPage">${manageTasks}</button>
                        <button class="button" name="command" value="tasksCheckingPage">${taskChecking}</button>
                        <button class="button" name="command" value="courseJournalTeacherPage">${courseJournalTeacher}</button>
                    </c:when>
                    <c:when test="${sessionScope.user.role == 'STUDENT'}">
                        <button class="button" name="command" value="chooseCoursePage">${chooseACourse}</button>
                        <button class="button" name="command" value="taskInformationPage">${taskInformation}</button>
                    </c:when>
                </c:choose>
            </form>
        </div>
    </div>

    <div class="main">
        <h2 style="text-align:center;">${courseCreationForm}</h2>

        <div>
            <form id="courseChanges" class="form-container" method="post"
                  action="controller?command=addCourseCommand">
                <label class="form-row" for="user_id">${teacherId}:</label>
                <input class="form-row" id="user_id" name="user_id" type="text" value="${requestScope.course.teacherId}" required="required"/>
                <label class="form-row" for="course_title">${courseTitle}:</label>
                <input class="form-row" id="course_title" name="course_title" type="text" value="${requestScope.course.courseTitle}" required="required"/>
                <label class="form-row" for="start_date">${startDate}:</label>
                <input class="form-row" id="start_date" name="start_date" type="date" value="${requestScope.course.startDate}" required="required"/>
                <label class="form-row" for="end_date">${endDate}:</label>
                <input class="form-row" id="end_date" name="end_date" type="date" value="${requestScope.course.endDate}" required="required"/>
                <label class="form-row" for="price">${price}:</label>
                <input class="form-row" id="price" name="price" type="text" value="${requestScope.course.price}" required="required"/>

            </form>
            <form method="post" action="controller?command=manageCoursesPage" class="button-container">
                <button type="submit" form="courseChanges" class="button">${commitChanges}</button>
                <button type="submit" class="red-button">${cancel}</button>
            </form>
        </div>

    </div>
</div>

<footer>
    <p>Contact us: +375 29 908 20 20</p>
</footer>

</body>
</html>