<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
</head>
<body>
<%@include file="parts/header.jsp" %>

<div class="container">
    <h1>Создание проекта</h1>
    <form:form action="${pageContext.request.contextPath}/project-save" method="post" modelAttribute="project">
        <div class="form-group">
            <form:label for="inputId" path="id">ID</form:label>
            <form:input type="text" class="form-control"
                        id="inputId"  path="id" aria-describedby="projectId" readonly="true"></form:input>
        </div>
        <div class="form-group">
            <form:label for="inputName" path="name">Имя</form:label>
            <form:input type="text" class="form-control"
                        id="inputName" path="name" name="projectName" aria-describedby="projectName"></form:input>
        </div>
        <div class="d-flex">
            <button type="submit" class="btn btn-success mr-4">Сохранить</button>
            <a class="btn btn-light" href="<c:url value="/project-list"/>" role="button">Отмена</a>
        </div>
    </form:form>
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
</body>
</html>