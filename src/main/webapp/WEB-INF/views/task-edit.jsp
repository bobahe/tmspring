<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<%@include file="parts/headerTaskActive.jsp" %>

<div class="container">
    <div class="col-12 col-md-8 offset-md-2">
        <h1>Редактирование Задачи</h1>
        <form:form action="${pageContext.request.contextPath}/task-save" method="post" modelAttribute="task">
            <div class="form-group">
                <form:label for="inputId" path="id">ID</form:label>
                <form:input type="text" class="form-control"
                            id="inputId" path="id" aria-describedby="projectId" readonly="true"></form:input>
            </div>
            <div class="form-group">
                <form:label path="projectId">Проект:</form:label>
                <form:select path="projectId">
                    <c:forEach var="project" items="${projects}">
                        <c:if test="${project.id == task.projectId}">
                            <form:option value="${project.id}" label="${project.name}" selected="selected"/>
                        </c:if>
                        <c:if test="${project.id != task.projectId}">
                            <form:option value="${project.id}" label="${project.name}"/>
                        </c:if>
                    </c:forEach>
                </form:select>
            </div>
            <div class="form-group">
                <form:label for="inputName" path="name">Имя</form:label>
                <form:input type="text" class="form-control"
                            id="inputName" path="name" aria-describedby="projectName"></form:input>
            </div>
            <div class="form-group">
                <form:label for="inputDescription" path="description">Описание</form:label>
                <form:input type="text" class="form-control"
                            id="inputDescription" path="description" aria-describedby="projectDescription"></form:input>
            </div>
            <div class="form-group">
                <form:label for="inputStartDate" path="startDate">Дата начала:</form:label>
                <form:input type="date" class="form-control"
                            id="inputStartDate" path="startDate" aria-describedby="projectStartDate"></form:input>
            </div>
            <div class="form-group">
                <form:label for="inputEndDate" path="endDate">Дата завершения:</form:label>
                <form:input type="date" class="form-control"
                            id="inputEndDate" path="endDate" aria-describedby="projectEndDate"></form:input>
            </div>
            <div class="form-group">
                <form:label for="inputStatus" path="status">Статус:</form:label>
                <form:select path="status">
                    <form:options items="${statuses}" itemLabel="displayName"/>
                </form:select>
            </div>
            <div class="d-flex">
                <button type="submit" class="btn btn-success mr-4"><i class="far fa-save"></i> Сохранить</button>
                <a class="btn btn-light" href="<c:url value="/project-list"/>" role="button">
                    <i class="fas fa-chevron-circle-left"></i> Назад
                </a>
            </div>
        </form:form>
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
</body>
</html>