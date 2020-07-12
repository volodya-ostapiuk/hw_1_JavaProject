package com.epam.controller;

import com.epam.DAO.implementation.RoomDAOImpl;
import com.epam.model.RoomEntity;

import java.sql.SQLException;
import java.util.List;

public class StudentController {
    public List<RoomEntity> readAll() throws SQLException {
        return new RoomDAOImpl().readAll();
    }

    public RoomEntity readById(Integer id) throws SQLException {
        return new RoomDAOImpl().readById(id);
    }

    public int create(RoomEntity entity) throws SQLException {
        return new RoomDAOImpl().create(entity);
    }

    public int update(RoomEntity entity) throws SQLException {
        return new RoomDAOImpl().update(entity);
    }

    public int delete(Integer id) throws SQLException {
        return new RoomDAOImpl().delete(id);
    }
}
