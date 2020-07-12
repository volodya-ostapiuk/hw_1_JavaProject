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
                <a href="<%=request.getContextPath()%>/listlesson" class="navbar-brand">School by Ostapiuk</a>
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
            <h3 class="text-center">List of Lessons</h3>
            <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/newlesson" class="btn btn-success">Add New Lesson</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
                <tr style="text-align:center">
                    <th>ID</th>
                    <th>Class ID</th>
                    <th>Room ID</th>
                    <th>Subject ID</th>
                    <th>Teacher ID</th>
                    <th>Topic</th>
                    <th>Homework</th>
                    <th>Date</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="lesson" items="${listLesson}">
                <tr style="text-align:center">
                    <td>
                        <c:out value="${lesson.id}" />
                    </td>
                    <td>
                        <c:out value="${lesson.classID}" />
                    </td>
                    <td>
                        <c:out value="${lesson.roomID}" />
                    </td>
                    <td>
                        <c:out value="${lesson.subjectID}" />
                    </td>
                    <td>
                         <c:out value="${lesson.teacherID}" />
                    </td>
                    <td>
                        <c:out value="${lesson.topic}" />
                    </td>
                    <td>
                        <c:out value="${lesson.homework}" />
                    </td>
                    <td>
                        <c:out value="${lesson.date}" />
                    </td>
                    <td>
                        <a href="editlesson?id=<c:out value='${lesson.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;
                        <a href="deletelesson?id=<c:out value='${lesson.id}' />">Delete</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
    </div>
</body>
</html>