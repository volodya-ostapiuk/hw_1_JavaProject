package com.epam.controller;

import com.epam.DAO.implementation.RoomDAOImpl;
import com.epam.model.RoomEntity;
import com.epam.view.ServletManagement;

import java.sql.SQLException;
import java.util.List;

public class RoomController {
    private ServletManagement view;
    private String status;

    public RoomController(ServletManagement servletManagement) {
        view = servletManagement;
    }

    public List<RoomEntity> readAll() throws SQLException {
        status = "Reading all Rooms";
        updateView();
        return new RoomDAOImpl().readAll();
    }

    public RoomEntity readById(Integer id) throws SQLException {
        status = "Reading Room with id = " + id;
        updateView();
        return new RoomDAOImpl().readById(id);
    }

    public void create(RoomEntity entity) throws SQLException {
        status = "Creating Room: " + entity;
        updateView(new RoomDAOImpl().create(entity));
    }

    public void update(RoomEntity entity) throws SQLException {
        status = "Updating Room: " + entity;
        updateView(new RoomDAOImpl().update(entity));
    }

    public void delete(Integer id) throws SQLException {
        status = "Deleting Room with id = " + id;
        updateView(new RoomDAOImpl().delete(id));
    }

    private void updateView() {
        view.printStatus(status);
    }

    private void updateView(int result) {
        view.printResult(result, status);
    }
}
