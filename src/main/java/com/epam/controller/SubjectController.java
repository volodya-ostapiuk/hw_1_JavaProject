package com.epam.controller;

import com.epam.DAO.implementation.SubjectDAOImpl;
import com.epam.model.SubjectEntity;
import com.epam.view.ServletManagement;

import java.sql.SQLException;
import java.util.List;

public class SubjectController {
    private ServletManagement view;
    private String status;

    public SubjectController(ServletManagement servletManagement) {
        view = servletManagement;
    }

    public List<SubjectEntity> readAll() throws SQLException {
        status = "Reading all Subjects";
        updateView();
        return new SubjectDAOImpl().readAll();
    }

    public SubjectEntity readById(Integer id) throws SQLException {
        status = "Reading Subject with id = " + id;
        updateView();
        return new SubjectDAOImpl().readById(id);
    }

    public void create(SubjectEntity entity) throws SQLException {
        status = "Creating Subject: " + entity;
        updateView(new SubjectDAOImpl().create(entity));
    }

    public void update(SubjectEntity entity) throws SQLException {
        status = "Updating Subject: " + entity;
        updateView(new SubjectDAOImpl().update(entity));
    }

    public void delete(Integer id) throws SQLException {
        status = "Deleting Subject with id = " + id;
        updateView(new SubjectDAOImpl().delete(id));
    }

    private void updateView() {
        view.printStatus(status);
    }

    private void updateView(int result) {
        view.printResult(result, status);
    }
}
