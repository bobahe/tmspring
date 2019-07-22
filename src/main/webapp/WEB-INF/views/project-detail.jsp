<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=utf-8" %>
<!doctype html>
<html lang="ru">
<head>
    <meta charset="utf-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Task-manager Spring</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
          integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.9.0/css/all.min.css">
</head>
<body>
<%@include file="parts/header.jsp" %>

<div class="container">
    <div class="col-12 col-md-8 offset-md-2">
        <h1>Детали проекта</h1>
        <table class="table">
            <tr>
                <td>ID:</td>
                <td>${project.id}</td>
            </tr>
            <tr>
                <td>Название:</td>
                <td>${project.name}</td>
            </tr>
            <tr>
                <td>Описание:</td>
                <td>${project.description}</td>
            </tr>
            <tr>
                <td>Дата начала:</td>
                <td class="dateStart">${project.startDate}</td>
            </tr>
            <tr>
                <td>Дата завершения:</td>
                <td class="dateEnd">${project.endDate}</td>
            </tr>
            <tr>
                <td>Статус:</td>
                <td>${project.status.displayName}</td>
            </tr>
        </table>
        <a class="btn btn-light" href="<c:url value="/project-list"/>" role="button"><i class="fas fa-chevron-circle-left"></i> Назад</a>
    </div>
</div>

<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous">
</script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous">
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous">
</script>
<script>
    $(document).ready(function(){
        var ds = $('.dateStart');
        var dts = new Date(ds.text()).toLocaleDateString();
        ds.text(dts);
        var de = $('.dateEnd');
        var dte = new Date(de.text()).toLocaleDateString();
        de.text(dte);
    });
</script>
</body>
</html>