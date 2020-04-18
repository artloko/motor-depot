<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Веб програмирование</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/styles.css">
    <link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" rel="stylesheet">
</head>
<body>

<h1>Вывести информацию обо всех рейсах заданного водителя</h1>

<div class="page-form">
    <form id="trips-by-driver-form" action="${pageContext.request.contextPath}/main" method="POST">
    </form>
</div>

<c:if test="${!empty tripsByIdList}">
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
            <c:forEach items="${tripsByIdList}" var="trip">

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
</c:if>

<a href="${pageContext.request.contextPath}/main?action=home"> На главную</a>

<script src="${pageContext.request.contextPath}/script/script.js"></script>

</body>
</html>