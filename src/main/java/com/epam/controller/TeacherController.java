package com.epam.controller;

import com.epam.DAO.implementation.TeacherDAOImpl;
import com.epam.model.TeacherEntity;

import java.sql.SQLException;
import java.util.List;

public class TeacherController {
    public List<TeacherEntity> readAll() throws SQLException {
        return new TeacherDAOImpl().readAll();
    }

    public TeacherEntity readById(Integer id) throws SQLException {
        return new TeacherDAOImpl().readById(id);
    }

    public int create(TeacherEntity entity) throws SQLException {
        return new TeacherDAOImpl().create(entity);
    }

    public int update(TeacherEntity entity) throws SQLException {
        return new TeacherDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new TeacherDAOImpl().delete(id);
    }
}
