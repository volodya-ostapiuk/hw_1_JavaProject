package com.epam.DAO.implementation;

import com.epam.DAO.TeacherDAO;
import com.epam.model.StudentEntity;
import com.epam.model.TeacherEntity;
import com.epam.service.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDAOImpl implements TeacherDAO {
    private static final String GET_ALL = "select * from teacher";
    private static final String GET_BY_ID = "select * from teacher where teacher_id=?";
    private static final String INSERT = "insert into teacher (first_name, last_name, address, phone, " +
            "salary, category, birthday) values (?,?,?,?,?,?,?)";
    private static final String UPDATE = "update teacher set first_name=?, last_name=?, address=?, phone=?, " +
            "salary=?, category=?, birthday=? where teacher_id=?";
    private static final String DELETE = "delete from teacher where teacher_id=?";

    @Override
    public List<TeacherEntity> readAll() throws SQLException {
        List<TeacherEntity> teachers = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("teacher_id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String address = resultSet.getString("address");
                    String phone = resultSet.getString("phone");
                    int salary = resultSet.getInt("salary");
                    String category = resultSet.getString("category");
                    String birthday = resultSet.getString("birthday");
                    TeacherEntity teacherEntity = new TeacherEntity(id, firstName, lastName, address, phone, salary,
                            category, birthday);
                    teachers.add(teacherEntity);
                }
            }
        }
        return teachers;
    }

    @Override
    public TeacherEntity readById(Integer id) throws SQLException {
        TeacherEntity teacherEntity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String address = resultSet.getString("address");
                    String phone = resultSet.getString("phone");
                    int salary = resultSet.getInt("salary");
                    String category = resultSet.getString("category");
                    String birthday = resultSet.getString("birthday");
                    teacherEntity = new TeacherEntity(id, firstName, lastName, address, phone, salary,
                            category, birthday);
                }
            }
        }
        return teacherEntity;
    }

    @Override
    public int create(TeacherEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getAddress());
            preparedStatement.setString(4, entity.getPhone());
            preparedStatement.setInt(5, entity.getSalary());
            preparedStatement.setString(6, entity.getCategory());
            preparedStatement.setString(7, entity.getBirthday());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public int update(TeacherEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getAddress());
            preparedStatement.setString(4, entity.getPhone());
            preparedStatement.setInt(5, entity.getSalary());
            preparedStatement.setString(6, entity.getCategory());
            preparedStatement.setString(7, entity.getBirthday());
            preparedStatement.setInt(8, entity.getId());
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
