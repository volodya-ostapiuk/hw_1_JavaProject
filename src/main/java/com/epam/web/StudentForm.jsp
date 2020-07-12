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
                <a href="<%=request.getContextPath()%>/liststudent" class="navbar-brand">School by Ostapiuk</a>
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
                <c:if test="${student != null}">
                    <form action="updatestudent" method="post">
                </c:if>
                <c:if test="${student == null}">
                    <form action="insertstudent" method="post">
                </c:if>
                <caption>
                    <h2>
                        <c:if test="${student != null}">Edit Student</c:if>
                        <c:if test="${student == null}">Add New Student</c:if>
                    </h2>
                </caption>
                <c:if test="${student != null}">
                    <input type="hidden" name="id" value="<c:out value='${student.id}' />" />
                </c:if>
                <fieldset class="form-group">
                    <label>Student First Name</label> <input type="text" value="<c:out value='${student.firstname}' />"
                    class="form-control" name="firstname" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Student Last Name</label> <input type="text" value="<c:out value='${student.lastname}' />"
                    class="form-control" name="lastname" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Student Address</label> <input type="text" value="<c:out value='${student.address}' />"
                    class="form-control" name="address" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Student Birthday</label> <input type="date" value="<c:out value='${student.birthday}' />"
                    class="form-control" name="birthday" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Student Phone</label> <input type="text" value="<c:out value='${student.phone}' />"
                    class="form-control" name="phone" required="required">
                </fieldset>
                <fieldset class="form-group">
                    <label>Student Class ID</label> <input type="number" value="<c:out value='${student.classID}' />"
                    class="form-control" name="classID" required="required">
                </fieldset>
                <button type="submit" class="btn btn-success">Save</button>
                </form>
            </div>
        </div>
    </div>
</body>
</html>