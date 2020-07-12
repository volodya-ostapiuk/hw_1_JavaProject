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
    <div class="container col-md-5">
        <div class="card">
            <div class="card-body">
                <c:if test="${clazz != null}">
                    <form action="updateclass" method="post">
                </c:if>
                <c:if test="${clazz == null}">
                    <form action="insertclass" method="post">
                </c:if>
                <caption>
                    <h2>
                        <c:if test="${clazz != null}">Edit Class</c:if>
                        <c:if test="${clazz == null}">Add New Class</c:if>
                    </h2>
                </caption>
                <c:if test="${clazz != null}">
                    <input type="hidden" name="id" value="<c:out value='${clazz.id}' />" />
                </c:if>
                <fieldset class="form-group">
                    <label>Class Name</label> <input type="text" value="<c:out value='${clazz.name}' />"
                    class="form-control" name="name" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Class Description</label> <input type="text" value="<c:out value='${clazz.description}' />"
                    class="form-control" name="description" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Class Teacher ID</label> <input type="number" value="<c:out value='${clazz.teacherID}' />"
                    class="form-control" name="teacherID" required="required">
                </fieldset>
                <button type="submit" class="btn btn-success">Save</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>