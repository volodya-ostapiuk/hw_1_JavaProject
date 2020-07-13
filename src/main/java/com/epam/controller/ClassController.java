package com.epam.controller;

import com.epam.DAO.implementation.ClassDAOImpl;
import com.epam.model.ClassEntity;
import com.epam.view.ServletManagement;

import java.sql.SQLException;
import java.util.List;

public class ClassController {
    private ServletManagement view;
    private String status;

    public ClassController(ServletManagement servletManagement) {
        view = servletManagement;
    }

    public List<ClassEntity> readAll() throws SQLException {
        status = "Reading all Classes";
        updateView();
        return new ClassDAOImpl().readAll();
    }

    public ClassEntity readById(Integer id) throws SQLException {
        status = "Reading Class with id = " + id;
        updateView();
        return new ClassDAOImpl().readById(id);
    }

    public void create(ClassEntity entity) throws SQLException {
        status = "Creating Class: " + entity;
        updateView(new ClassDAOImpl().create(entity));
    }

    public void update(ClassEntity entity) throws SQLException {
        status = "Updating Class: " + entity;
        updateView(new ClassDAOImpl().update(entity));
    }

    public void delete(Integer id) throws SQLException {
        status = "Deleting Class with id = " + id;
        updateView(new ClassDAOImpl().delete(id));
    }

    private void updateView() {
        view.printStatus(status);
    }

    private void updateView(int result) {
        view.printResult(result, status);
    }
}
