package com.epam.DAO.implementation;

import com.epam.DAO.RoomDAO;
import com.epam.model.RoomEntity;
import com.epam.service.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {
    private static final String GET_ALL = "select * from room";
    private static final String GET_BY_ID = "select * from room where room_id=?";
    private static final String INSERT = "insert into room (number, description) values (?,?)";
    private static final String UPDATE = "update room set number=?, description=? where room_id=?";
    private static final String DELETE = "delete from room where room_id=?";

    @Override
    public List<RoomEntity> readAll() throws SQLException {
        List<RoomEntity> rooms = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("room_id");
                    String number = resultSet.getString("number");
                    String description = resultSet.getString("description");
                    RoomEntity roomEntity = new RoomEntity(id, number, description);
                    rooms.add(roomEntity);
                }
            }
        }
        return rooms;
    }

    @Override
    public RoomEntity readById(Integer id) throws SQLException {
        RoomEntity roomEntity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String number = resultSet.getString("number");
                    String description = resultSet.getString("description");
                    roomEntity = new RoomEntity(id, number, description);
                }
            }
        }
        return roomEntity;
    }

    @Override
    public int create(RoomEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, entity.getNumber());
            preparedStatement.setString(2, entity.getDescription());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public int update(RoomEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, entity.getNumber());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setInt(3, entity.getId());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public int delete(Integer id) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, id);
            return preparedStatement.executeUpdate();
        }
    }
}
