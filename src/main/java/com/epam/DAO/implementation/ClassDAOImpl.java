package com.epam.DAO.implementation;

import com.epam.DAO.ClassDAO;
import com.epam.model.ClassEntity;
import com.epam.service.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassDAOImpl implements ClassDAO {
    private static final String GET_ALL = "select * from class";
    private static final String GET_BY_ID = "select * from class where class_id=?";
    private static final String INSERT = "insert into class (name, description, teacher_id) values (?,?,?)";
    private static final String UPDATE = "update class set name=?, description=?, teacher_id=? where class_id=?";
    private static final String DELETE = "delete from class where class_id=?";

    @Override
    public List<ClassEntity> readAll() throws SQLException {
        List<ClassEntity> classes = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("class_id");
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    int teacherID = resultSet.getInt("teacher_id");
                    ClassEntity classEntity = new ClassEntity(id, name, description, teacherID);
                    classes.add(classEntity);
                }
            }
        }
        return classes;
    }

    @Override
    public ClassEntity readById(Integer id) throws SQLException {
        ClassEntity classEntity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String name = resultSet.getString("name");
                    String description = resultSet.getString("description");
                    int teacherID = resultSet.getInt("teacher_id");
                    classEntity = new ClassEntity(id, name, description, teacherID);
                }
            }
        }
        return classEntity;
    }

    @Override
    public int create(ClassEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setInt(3, entity.getTeacherID());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public int update(ClassEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setInt(3, entity.getTeacherID());
            preparedStatement.setInt(4, entity.getId());
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
