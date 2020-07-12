package com.epam.controller;

import com.epam.DAO.implementation.SubjectDAOImpl;
import com.epam.model.SubjectEntity;

import java.sql.SQLException;
import java.util.List;

public class SubjectController {
    public List<SubjectEntity> readAll() throws SQLException {
        return new SubjectDAOImpl().readAll();
    }

    public SubjectEntity readById(Integer id) throws SQLException {
        return new SubjectDAOImpl().readById(id);
    }

    public int create(SubjectEntity entity) throws SQLException {
        return new SubjectDAOImpl().create(entity);
    }

    public int update(SubjectEntity entity) throws SQLException {
        return new SubjectDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new SubjectDAOImpl().delete(id);
    }
}
