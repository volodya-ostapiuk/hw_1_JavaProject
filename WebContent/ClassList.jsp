<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>School</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
    integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: purple">
            <div>
                <a href="<%=request.getContextPath()%>/listclass" class="navbar-brand">School by Ostapiuk</a>
            </div>
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/listclass" class="nav-link">Classes</a></li>
            </ul>
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/listlesson" class="nav-link">Lesson</a></li>
            </ul>
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/listroom" class="nav-link">Room</a></li>
            </ul>
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/liststudent" class="nav-link">Student</a></li>
            </ul>
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/listsubject" class="nav-link">Subject</a></li>
            </ul>
            <ul class="navbar-nav">
                <li><a href="<%=request.getContextPath()%>/listteacher" class="nav-link">Teacher</a></li>
            </ul>
        </nav>
    </header>
    <br>
    <div class="row">
        <div class="container">
            <h3 class="text-center">List of Classes</h3>
            <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/newclass" class="btn btn-success">Add New Class</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
                <tr style="text-align:center">
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Teacher ID</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="clazz" items="${listClass}">
                <tr style="text-align:center">
                    <td>
                        <c:out value="${clazz.id}" />
                    </td>
                    <td>
                        <c:out value="${clazz.name}" />
                    </td>
                    <td>
                        <c:out value="${clazz.description}" />
                    </td>
                    <td>
                         <c:out value="${clazz.teacherID}" />
                    </td>
                    <td>
                        <a href="editclass?id=<c:out value='${clazz.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;
                        <a href="deleteclass?id=<c:out value='${clazz.id}' />">Delete</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
    </div>
</body>
</html>