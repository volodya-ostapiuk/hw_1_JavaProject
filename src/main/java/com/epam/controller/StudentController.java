package com.epam.controller;

import com.epam.DAO.implementation.StudentDAOImpl;
import com.epam.model.StudentEntity;

import java.sql.SQLException;
import java.util.List;

public class StudentController {
    public List<StudentEntity> readAll() throws SQLException {
        return new StudentDAOImpl().readAll();
    }

    public StudentEntity readById(Integer id) throws SQLException {
        return new StudentDAOImpl().readById(id);
    }

    public int create(StudentEntity entity) throws SQLException {
        return new StudentDAOImpl().create(entity);
    }

    public int update(StudentEntity entity) throws SQLException {
        return new StudentDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new StudentDAOImpl().delete(id);
    }
}
