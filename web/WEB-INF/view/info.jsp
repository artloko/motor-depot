<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 4/18/2020
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${userLocale}"/>
<fmt:setBundle basename="locale"/>
<html>
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="app.title"/></title>
    <link href="${pageContext.request.contextPath}/style/styles.css" rel="stylesheet">
    <link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" rel="stylesheet">
</head>
<body>

<%@include file="header.jsp" %>
    <h1><fmt:message key="info.general.title"/></h1>
    <p><fmt:message key="info.general.description"/></p>

    <a href="${pageContext.request.contextPath}/main?action=login" class="btn btn-primary"><fmt:message key="app.log.in"/></a>
    <a href="${pageContext.request.contextPath}/main?action=registration" class="btn btn-primary"><fmt:message key="app.registration"/></a>
</body>
</html>
