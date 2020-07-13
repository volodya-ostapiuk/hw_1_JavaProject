package com.epam.controller;

import com.epam.DAO.implementation.StudentDAOImpl;
import com.epam.model.StudentEntity;
import com.epam.view.ServletManagement;

import java.sql.SQLException;
import java.util.List;

public class StudentController {
    private ServletManagement view;
    private String status;

    public StudentController(ServletManagement servletManagement) {
        view = servletManagement;
    }

    public List<StudentEntity> readAll() throws SQLException {
        status = "Reading all Students";
        updateView();
        return new StudentDAOImpl().readAll();
    }

    public StudentEntity readById(Integer id) throws SQLException {
        status = "Reading Student with id = " + id;
        updateView();
        return new StudentDAOImpl().readById(id);
    }

    public void create(StudentEntity entity) throws SQLException {
        status = "Creating Student: " + entity;
        updateView(new StudentDAOImpl().create(entity));
    }

    public void update(StudentEntity entity) throws SQLException {
        status = "Updating Student: " + entity;
        updateView(new StudentDAOImpl().update(entity));
    }

    public void delete(Integer id) throws SQLException {
        status = "Deleting Student with id = " + id;
        updateView(new StudentDAOImpl().delete(id));
    }

    private void updateView() {
        view.printStatus(status);
    }

    private void updateView(int result) {
        view.printResult(result, status);
    }
}
