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
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <c:if test="${lesson != null}">
                    <form action="updatelesson" method="post">
                </c:if>
                <c:if test="${lesson == null}">
                    <form action="insertlesson" method="post">
                </c:if>
                <caption>
                    <h2>
                        <c:if test="${lesson != null}">Edit Lesson</c:if>
                        <c:if test="${lesson == null}">Add New Lesson</c:if>
                    </h2>
                </caption>
                <c:if test="${lesson != null}">
                    <input type="hidden" name="id" value="<c:out value='${lesson.id}' />" />
                </c:if>
                <fieldset class="form-group">
                    <label>Lesson Class ID</label> <input type="number" value="<c:out value='${lesson.classID}' />"
                    class="form-control" name="classID" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Lesson Room ID</label> <input type="number" value="<c:out value='${lesson.roomID}' />"
                    class="form-control" name="roomID" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Lesson Subject ID</label> <input type="number" value="<c:out value='${lesson.subjectID}' />"
                    class="form-control" name="subjectID" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Lesson Teacher ID</label> <input type="number" value="<c:out value='${lesson.teacherID}' />"
                    class="form-control" name="teacherID" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Lesson Topic</label> <input type="text" value="<c:out value='${lesson.topic}' />"
                    class="form-control" name="topic" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Lesson Homework</label> <input type="text" value="<c:out value='${lesson.homework}' />"
                    class="form-control" name="homework" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Lesson Date</label> <input type="date" value="<c:out value='${lesson.date}' />"
                    class="form-control" name="date" required="required">
                </fieldset>
                <button type="submit" class="btn btn-success">Save</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>