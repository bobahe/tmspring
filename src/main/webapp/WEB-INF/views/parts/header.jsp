<%--
  Created by IntelliJ IDEA.
  User: bobah
  Date: 2019-07-19
  Time: 23:51
--%>
<%@ page contentType="text/html; charset=utf-8" %>

<header>
    <div class="navbar navbar-dark bg-dark shadow-sm mb-4">
        <div class="container d-flex justify-content-between">
            <a href="<c:url value="/"/>" class="navbar-brand d-flex align-items-center">
                <strong>Task-manager Spring</strong>
            </a>
            <ul class="navbar-nav mr-auto flex-row">
                <li class="nav-item active mr-3">
                    <a class="nav-link" href="<c:url value="/project-list"/>">Проекты <span
                            class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item mr-3">
                    <a class="nav-link" href="#">Задачи</a>
                </li>
            </ul>
        </div>
    </div>
</header>
