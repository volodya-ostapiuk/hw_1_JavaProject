package com.epam.controller;

import com.epam.DAO.implementation.TeacherDAOImpl;
import com.epam.model.TeacherEntity;
import com.epam.view.ServletManagement;

import java.sql.SQLException;
import java.util.List;

public class TeacherController {
    private ServletManagement view;
    private String status;

    public TeacherController(ServletManagement servletManagement) {
        view = servletManagement;
    }

    public List<TeacherEntity> readAll() throws SQLException {
        status = "Reading all Teachers";
        updateView();
        return new TeacherDAOImpl().readAll();
    }

    public TeacherEntity readById(Integer id) throws SQLException {
        status = "Reading Teacher with id = " + id;
        updateView();
        return new TeacherDAOImpl().readById(id);
    }

    public void create(TeacherEntity entity) throws SQLException {
        status = "Creating Teacher: " + entity;
        updateView(new TeacherDAOImpl().create(entity));
    }

    public void update(TeacherEntity entity) throws SQLException {
        status = "Updating Teacher: " + entity;
        updateView(new TeacherDAOImpl().update(entity));
    }

    public void delete(Integer id) throws SQLException {
        status = "Deleting Teacher with id = " + id;
        updateView(new TeacherDAOImpl().delete(id));
    }

    private void updateView() {
        view.printStatus(status);
    }

    private void updateView(int result) {
        view.printResult(result, status);
    }
}
