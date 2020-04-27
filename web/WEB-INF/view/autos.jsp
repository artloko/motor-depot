<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="UTF-8"/>
<fmt:setLocale value="${userLocale}"/>
<fmt:setBundle basename="locale"/>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title><fmt:message key="app.title"/></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/styles.css">
    <link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" rel="stylesheet">
</head>
<body>

<h1><fmt:message key="index.autos"/></h1>

<div class="page-form">
    <form id="autos-form" action="${pageContext.request.contextPath}/main">
    </form>
</div>

<c:if test="${!empty brokenCarsList}">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">id</th>
            <th scope="col">firm</th>
            <th scope="col">model</th>
            <th scope="col">gearbox type</th>
            <th scope="col">year</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${brokenCarsList}" var="car">
            <tr>
                <td scope="col">${car.getId()}</td>
                <td scope="col">${car.getFirm()}</td>
                <td scope="col">${car.getModel()}</td>
                <td scope="col">${car.getGearboxType()}</td>
                <td scope="col">${car.getYear()}</td>
            </tr>
        </c:forEach>
        <tr>
        </tr>
        </tbody>
    </table>
</c:if>

<a href="${pageContext.request.contextPath}/main?action=home"><fmt:message key="app.home"/></a>


</body>
</html>