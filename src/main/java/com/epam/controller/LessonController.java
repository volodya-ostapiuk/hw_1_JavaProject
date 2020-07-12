package com.epam.controller;

import com.epam.DAO.implementation.LessonDAOImpl;
import com.epam.model.LessonEntity;

import java.sql.SQLException;
import java.util.List;

public class LessonController {
    public List<LessonEntity> readAll() throws SQLException {
        return new LessonDAOImpl().readAll();
    }

    public LessonEntity readById(Integer id) throws SQLException {
        return new LessonDAOImpl().readById(id);
    }

    public int create(LessonEntity entity) throws SQLException {
        return new LessonDAOImpl().create(entity);
    }

    public int update(LessonEntity entity) throws SQLException {
        return new LessonDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new LessonDAOImpl().delete(id);
    }
}
