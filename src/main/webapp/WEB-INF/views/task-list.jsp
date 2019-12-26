<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
<body style="position: relative;">
<%@include file="parts/headerTaskActive.jsp" %>

<div class="container">
    <h1>Список задач</h1>
    <table class="table table-striped table-sm shadow rounded">
        <thead class="thead-dark">
        <th scope="col">№</th>
        <th scope="col">Проект</th>
        <th scope="col">ID</th>
        <th scope="col">Имя</th>
        <th scope="col">Описание</th>
        <th scope="col" class="text-center">Просмотр</th>
        <th scope="col" class="text-center">Редактирование</th>
        <th scope="col" class="text-center">Удаление</th>
        </thead>
        <tbody>
        <c:forEach var="task" items="${tasks}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${task.project.name}</td>
                <td>${task.id}</td>
                <td>${task.name}</td>
                <td>${task.description}</td>
                <td class="text-center">
                    <a href="<c:url value="/task-detail/${task.id}"/>"><i class="far fa-eye text-info"></i></a>
                </td>
                <td class="text-center">
                    <a href="<c:url value="/task-edit/${task.id}"/>"><i class="far fa-edit text-primary"></i></a>
                </td>
                <td class="text-center">
                    <a href="<c:url value="/task-delete/${task.id}"/>"><i class="far fa-trash-alt text-danger"></i></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="d-flex">
        <a class="btn btn-success mr-3"
           href="<c:url value="/task-create"/>" role="button">
            <i class="fas fa-folder-plus"></i> Добавить задачу
        </a>
        <a class="btn btn-light" href="<c:url value="/task-list"/>" role="button">
            <i class="fas fa-sync"></i> Обновить
        </a>
    </div>
</div>

<div class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-delay="5000"
     style="position: absolute; top: 30px; right: 30px; width: 400px;">
    <div class="toast-header bg-danger">
        <strong class="mr-auto text-white">Ошибочка вышла</strong>
        <small class="text-white">только что</small>
        <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
    </div>
    <div class="toast-body">
        ${error}
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous">
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous">
</script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous">
</script>
    <c:if test="${fn:length(error) > 0}">
        <script lang="JavaScript">
            $(document).ready(function(){
                $(".toast").toast('show');
            });
        </script>
    </c:if>
</body>
</html>