<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 4/18/2020
  Time: 5:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Веб програмирование</title>
    <link href="${pageContext.request.contextPath}/style/styles.css" rel="stylesheet">
    <link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" rel="stylesheet">
</head>
<body>

    <h1>Общая информация</h1>
    <p>Автобаза. Диспетчер распределяет Заявки на Рейсы между Водителями, за каждым из которых закреплен свой Автомобиль.
        На Рейс может быть назначен Автомобиль, находящийся в исправном состоянии и характеристики которого соответствуют Заявке.
        Водитель делает отметку о выполнении Рейса и состоянии Автомобиля</p>

    <a href="${pageContext.request.contextPath}/main?action=login" class="btn btn-primary">Войти</a>
    <a href="${pageContext.request.contextPath}/main?action=registration" class="btn btn-primary">Зарегистрироваться</a>
</body>
</html>
