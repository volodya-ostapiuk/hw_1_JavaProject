package com.epam.controller;

import com.epam.DAO.implementation.ClassDAOImpl;
import com.epam.model.ClassEntity;

import java.sql.SQLException;
import java.util.List;

public class ClassController {
    public List<ClassEntity> readAll() throws SQLException {
        return new ClassDAOImpl().readAll();
    }

    public ClassEntity readById(Integer id) throws SQLException {
        return new ClassDAOImpl().readById(id);
    }

    public int create(ClassEntity entity) throws SQLException {
        return new ClassDAOImpl().create(entity);
    }

    public int update(ClassEntity entity) throws SQLException {
        return new ClassDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new ClassDAOImpl().delete(id);
    }
}
