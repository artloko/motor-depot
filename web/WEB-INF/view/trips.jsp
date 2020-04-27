<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="mytag" uri="/WEB-INF/tld/tableList.tld" %>
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
    <script src="${pageContext.request.contextPath}/script/script.js"></script>
</head>
<body>

<h1><fmt:message key="index.trips"/></h1>

<div class="page-form">
    <form id="trips-form" action="${pageContext.request.contextPath}/main">
    </form>
</div>
<mytag:tripsTableTag/>

<!--

<c:if test="${!empty tripsList}">
    <div class="page-table">
        <table class="table">
            <thead>
            <tr>
                <th scope="col">id</th>
                <th scope="col">from</th>
                <th scope="col">to</th>
                <th scope="col">trip status</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${tripsList}" var="trip">

                <tr>
                    <td scope="col">${trip.getId()}</td>
                    <td scope="col">${trip.getFrom()}</td>
                    <td scope="col">${trip.getTo()}</td>
                    <td scope="col">${trip.getTripStatus()}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</c:if>-->

<a href="${pageContext.request.contextPath}/main?action=home"><fmt:message key="app.home"/></a>

<script>
    dom("${userLocale.language}").initPage();
</script>

</body>
</html>