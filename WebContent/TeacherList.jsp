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
                <a href="<%=request.getContextPath()%>/listteacher" class="navbar-brand">School by Ostapiuk</a>
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
            <h3 class="text-center">List of Teachers</h3>
            <hr>
        <div class="container text-left">
            <a href="<%=request.getContextPath()%>/newteacher" class="btn btn-success">Add New Teacher</a>
        </div>
        <br>
        <table class="table table-bordered">
            <thead>
                <tr style="text-align:center">
                    <th>ID</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Address</th>
                    <th>Phone</th>
                    <th>Salary</th>
                    <th>Category</th>
                    <th>Birthday</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="teacher" items="${listTeacher}">
                <tr style="text-align:center">
                    <td>
                        <c:out value="${teacher.id}" />
                    </td>
                    <td>
                        <c:out value="${teacher.firstname}" />
                    </td>
                    <td>
                        <c:out value="${teacher.lastname}" />
                    </td>
                    <td>
                        <c:out value="${teacher.address}" />
                    </td>
                    <td>
                        <c:out value="${teacher.phone}" />
                    </td>
                    <td>
                        <c:out value="${teacher.salary}" />
                    </td>
                    <td>
                        <c:out value="${teacher.category}" />
                    </td>
                    <td>
                        <c:out value="${teacher.birthday}" />
                    </td>
                    <td>
                        <a href="editteacher?id=<c:out value='${teacher.id}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;
                        <a href="deleteteacher?id=<c:out value='${teacher.id}' />">Delete</a>
                    </td>
                </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>
    </div>
</body>
</html>