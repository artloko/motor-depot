<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Веб програмирование</title>
    <link href="${pageContext.request.contextPath}/style/styles.css" rel="stylesheet">
    <link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" rel="stylesheet">
</head>
<body>
<h1>Вариант 8, Лобко Артем</h1>
<p>
    Автобаза. Диспетчер распределяет Заявки на Рейсы между Водителями, за каждым из которых закреплен свой Автомобиль.
    На Рейс может быть назначен Автомобиль, находящийся в исправном состоянии и характеристики которого соответствуют Заявке.
    Водитель делает отметку о выполнении Рейса и состоянии Автомобиля
</p>
<p>
    Последний заход: ${cookie['lastEnterTime'].getValue()}
<p>
<p>
    Количество посещений: ${cookie['usageCount'].getValue()}
</p>

<p
<c:if test="${sessionScope['user'].getTypeString() == 'guest'}">
    style="color:red"
</c:if>
>Пользователь: ${sessionScope['user'].getLogin()}<p>

<ul>
    <li>
        <a href="${pageContext.request.contextPath}/main?action=trips">Вывести список рейсов</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/main?action=tripsById">Вывести информацию обо всех рейсах заданного водителя</a>
    </li>
    <li>
        <a href="${pageContext.request.contextPath}/main?action=autos">Вывести список автомобилей, находящихся в ремонте</a>
    </li>
    <c:if test="${sessionScope['user'].getTypeString() == 'client' || sessionScope['user'].getTypeString() == 'admin'}">
        <li>
            <a href="${pageContext.request.contextPath}/main?action=setDriver">Назначить водителя на рейс</a>
        </li>
    </c:if>
    <c:if test="${sessionScope['user'].getTypeString() == 'admin'}">
        <li>
            <a href="${pageContext.request.contextPath}/main?action=setCarStatus">Поставить автомобиль на ремонт</a>
        </li>
    </c:if>
</ul>

<div class="page-form">
    <form id="logout-form" action="${pageContext.request.contextPath}/main">
    </form>
</div>

<script src="${pageContext.request.contextPath}/script/script.js"></script>

</body>
</html>