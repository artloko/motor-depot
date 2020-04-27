<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${userLocale}"/>
<fmt:setBundle basename="locale"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="app.title"/></title>
    <link href="${pageContext.request.contextPath}/style/styles.css" rel="stylesheet">
    <link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/script/script.js"></script>
</head>
<body>
<h1><fmt:message key="app.author.info"/></h1>
<p><fmt:message key="info.general.description"/>
</p>
<p>
    <fmt:message key="index.last.enter"/> ${cookie['lastEnterTime'].getValue()}
<p>
<p>
    <fmt:message key="index.enter.number"/> ${cookie['usageCount'].getValue()}
</p>

<p
<c:if test="${sessionScope['user'].getTypeString() == 'guest'}">
    style="color:red"
</c:if>
<fmt:message key="index.user"/> ${sessionScope['user'].getLogin()}<p>

<ul>
    <li>
        <a href="${pageContext.request.contextPath}/main?action=trips"><fmt:message key="index.trips"/></a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/main?action=tripsById"><fmt:message key="index.trips.by.id"/></a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/main?action=autos"><fmt:message key="index.autos"/></a>
    </li>
    <c:if test="${sessionScope['user'].getTypeString() == 'client' || sessionScope['user'].getTypeString() == 'admin'}">
        <li>
            <a href="${pageContext.request.contextPath}/main?action=setDriver"><fmt:message key="index.set.driver"/></a>
        </li>
    </c:if>
    <c:if test="${sessionScope['user'].getTypeString() == 'admin'}">
        <li>
            <a href="${pageContext.request.contextPath}/main?action=setCarStatus"><fmt:message key="index.set.car.status"/></a>
        </li>
    </c:if>
</ul>

<div class="page-form">
    <form id="logout-form" action="${pageContext.request.contextPath}/main">
    </form>
</div>

<script>
    dom("${userLocale.language}").initPage();
</script>

</body>
</html>