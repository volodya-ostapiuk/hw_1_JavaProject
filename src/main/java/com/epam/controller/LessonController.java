package com.epam.controller;

import com.epam.DAO.implementation.LessonDAOImpl;
import com.epam.model.LessonEntity;
import com.epam.view.ServletManagement;

import java.sql.SQLException;
import java.util.List;

public class LessonController {
    private ServletManagement view;
    private String status;

    public LessonController(ServletManagement servletManagement) {
        view = servletManagement;
    }

    public List<LessonEntity> readAll() throws SQLException {
        status = "Reading all Lessons";
        updateView();
        return new LessonDAOImpl().readAll();
    }

    public LessonEntity readById(Integer id) throws SQLException {
        status = "Reading Lesson with id = " + id;
        updateView();
        return new LessonDAOImpl().readById(id);
    }

    public void create(LessonEntity entity) throws SQLException {
        status = "Creating Lesson: " + entity;
        updateView(new LessonDAOImpl().create(entity));
    }

    public void update(LessonEntity entity) throws SQLException {
        status = "Updating Lesson: " + entity;
        updateView(new LessonDAOImpl().update(entity));
    }

    public void delete(Integer id) throws SQLException {
        status = "Deleting Lesson with id = " + id;
        updateView(new LessonDAOImpl().delete(id));
    }

    private void updateView() {
        view.printStatus(status);
    }

    private void updateView(int result) {
        view.printResult(result, status);
    }
}
