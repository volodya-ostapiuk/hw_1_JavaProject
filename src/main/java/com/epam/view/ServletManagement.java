package com.epam.view;

import com.epam.controller.*;
import com.epam.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

@WebServlet("/")
public class ServletManagement extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ClassController classController;
    private LessonController lessonController;
    private RoomController roomController;
    private StudentController studentController;
    private SubjectController subjectController;
    private TeacherController teacherController;

    public void init() {
        classController = new ClassController();
        lessonController = new LessonController();
        roomController = new RoomController();
        studentController = new StudentController();
        subjectController = new SubjectController();
        teacherController = new TeacherController();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getServletPath();
        try {
            switch (action) {
                case "/newclass":
                    showNewClassForm(req, resp);
                    break;
                case "/newlesson":
                    showNewLessonForm(req, resp);
                    break;
                case "/newroom":
                    showNewRoomForm(req, resp);
                    break;
                case "/newstudent":
                    showNewStudentForm(req, resp);
                    break;
                case "/newsubject":
                    showNewSubjectForm(req, resp);
                    break;
                case "/newteacher":
                    showNewTeacherForm(req, resp);
                    break;
                case "/insertclass":
                    insertClass(req, resp);
                    break;
                case "/insertlesson":
                    insertLesson(req, resp);
                    break;
                case "/insertroom":
                    insertRoom(req, resp);
                    break;
                case "/insertstudent":
                    insertStudent(req, resp);
                    break;
                case "/insertsubject":
                    insertSubject(req, resp);
                    break;
                case "/insertteacher":
                    insertTeacher(req, resp);
                    break;
                case "/deleteclass":
                    deleteClass(req, resp);
                    break;
                case "/deletelesson":
                    deleteLesson(req, resp);
                    break;
                case "/deleteroom":
                    deleteRoom(req, resp);
                    break;
                case "/deletestudent":
                    deleteStudent(req, resp);
                    break;
                case "/deletesubject":
                    deleteSubject(req, resp);
                    break;
                case "/deleteteacher":
                    deleteTeacher(req, resp);
                    break;
                case "/editclass":
                    showEditClassForm(req, resp);
                    break;
                case "/editlesson":
                    showEditLessonForm(req, resp);
                    break;
                case "/editroom":
                    showEditRoomForm(req, resp);
                    break;
                case "/editstudent":
                    showEditStudentForm(req, resp);
                    break;
                case "/editsubject":
                    showEditSubjectForm(req, resp);
                    break;
                case "/editteacher":
                    showEditTeacherForm(req, resp);
                    break;
            }
        } catch (SQLException exp) {
            throw new ServletException(exp);
        }
    }

    private void showNewClassForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("ClassForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void showNewLessonForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("LessonForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void showNewRoomForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("RoomForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void showNewStudentForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("StudentForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void showNewSubjectForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("SubjectForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void showNewTeacherForm(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("TeacherForm.jsp");
        dispatcher.forward(req, resp);
    }

    private void insertClass(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        int teacherID = Integer.parseInt(req.getParameter("teacherID"));
        ClassEntity classEntity = new ClassEntity(name, description, teacherID);
        classController.create(classEntity);
        resp.sendRedirect("listclass");
    }

    private void insertLesson(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        int classID = Integer.parseInt(req.getParameter("classID"));
        int roomID = Integer.parseInt(req.getParameter("roomID"));
        int subjectID = Integer.parseInt(req.getParameter("subjectID"));
        int teacherID = Integer.parseInt(req.getParameter("teacherID"));
        String topic = req.getParameter("topic");
        String homework = req.getParameter("homework");
        String date = req.getParameter("date");
        LessonEntity lessonEntity = new LessonEntity(classID, roomID, subjectID, teacherID, topic, homework, date);
        lessonController.create(lessonEntity);
        resp.sendRedirect("listlesson");
    }

    private void insertRoom(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String number = req.getParameter("number");
        String description = req.getParameter("description");
        RoomEntity roomEntity = new RoomEntity(number, description);
        roomController.create(roomEntity);
        resp.sendRedirect("listroom");
    }

    private void insertStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String address = req.getParameter("address");
        String birthday = req.getParameter("birthday");
        String phone = req.getParameter("phone");
        int classID = Integer.parseInt(req.getParameter("classID"));
        StudentEntity studentEntity = new StudentEntity(firstName, lastName, address, birthday, phone, classID);
        studentController.create(studentEntity);
        resp.sendRedirect("liststudent");
    }

    private void insertSubject(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        SubjectEntity subjectEntity = new SubjectEntity(name, description);
        subjectController.create(subjectEntity);
        resp.sendRedirect("listsubject");
    }

    private void insertTeacher(HttpServletRequest req, HttpServletResponse resp) throws IOException, SQLException {
        String firstName = req.getParameter("firstname");
        String lastName = req.getParameter("lastname");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        int salary = Integer.parseInt(req.getParameter("salary"));
        String category = req.getParameter("category");
        String birthday = req.getParameter("birthday");
        TeacherEntity teacherEntity = new TeacherEntity(firstName, lastName, address, phone, salary,
                category, birthday);
        teacherController.create(teacherEntity);
        resp.sendRedirect("listteacher");
    }

    private void deleteClass(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        classController.delete(id);
        response.sendRedirect("listclass");
    }

    private void deleteLesson(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        lessonController.delete(id);
        response.sendRedirect("listlesson");
    }

    private void deleteRoom(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        roomController.delete(id);
        response.sendRedirect("listroom");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentController.delete(id);
        response.sendRedirect("liststudent");
    }

    private void deleteSubject(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        subjectController.delete(id);
        response.sendRedirect("listsubject");
    }

    private void deleteTeacher(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        teacherController.delete(id);
        response.sendRedirect("listteacher");
    }

    private void showEditClassForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ClassEntity clazz = classController.readById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ClassForm.jsp");
        request.setAttribute("clazz", clazz);
        dispatcher.forward(request, response);
    }

    private void showEditLessonForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        LessonEntity lesson = lessonController.readById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("LessonForm.jsp");
        request.setAttribute("lesson", lesson);
        dispatcher.forward(request, response);
    }

    private void showEditRoomForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        RoomEntity room = roomController.readById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("RoomForm.jsp");
        request.setAttribute("room", room);
        dispatcher.forward(request, response);
    }

    private void showEditStudentForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentEntity student = studentController.readById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("StudentForm.jsp");
        request.setAttribute("student", student);
        dispatcher.forward(request, response);
    }

    private void showEditSubjectForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        SubjectEntity subject = subjectController.readById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("SubjectForm.jsp");
        request.setAttribute("subject", subject);
        dispatcher.forward(request, response);
    }

    private void showEditTeacherForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        TeacherEntity teacher = teacherController.readById(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("TeacherForm.jsp");
        request.setAttribute("teacher", teacher);
        dispatcher.forward(request, response);
    }
}
