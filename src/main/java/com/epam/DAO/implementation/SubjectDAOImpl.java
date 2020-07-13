package com.epam.DAO.implementation;

import com.epam.DAO.SubjectDAO;
import com.epam.model.RoomEntity;
import com.epam.model.SubjectEntity;
import com.epam.service.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubjectDAOImpl implements SubjectDAO {
    private static final String GET_ALL = "select * from subject";
    private static final String GET_BY_ID = "select * from subject where subject_id=?";
    private static final String INSERT = "insert into subject (name, description) values (?,?)";
    private static final String UPDATE = "update subject set name=?, description=? where subject_id=?";
    private static final String DELETE = "delete from subject where subject_id=?";

    @Override
    public List<SubjectEntity> readAll() throws SQLException {
        List<SubjectEntity> subjects = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("subject_id");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    SubjectEntity subjectEntity = new SubjectEntity(id, name, description);
                    subjects.add(subjectEntity);
                }
            }
        }
        return subjects;
    }

    @Override
    public SubjectEntity readById(Integer id) throws SQLException {
        SubjectEntity subjectEntity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    subjectEntity = new SubjectEntity(id, name, description);
                }
            }
        }
        return subjectEntity;
    }

    @Override
    public int create(SubjectEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getDescription());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public int update(SubjectEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, entity.getName());
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
