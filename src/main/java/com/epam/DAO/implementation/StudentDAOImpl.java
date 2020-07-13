package com.epam.DAO.implementation;

import com.epam.DAO.StudentDAO;
import com.epam.model.StudentEntity;
import com.epam.service.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {
    private static final String GET_ALL = "select * from student";
    private static final String GET_BY_ID = "select * from student where student_id=?";
    private static final String INSERT = "insert into student (first_name, last_name, address, birthday, " +
            "phone, class_id) values (?,?,?,?,?,?)";
    private static final String UPDATE = "update student set first_name=?, last_name=?, address=?, birthday=?, " +
            "phone=?, class_id=? where student_id=?";
    private static final String DELETE = "delete from student where student_id=?";

    @Override
    public List<StudentEntity> readAll() throws SQLException {
        List<StudentEntity> students = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("student_id");
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String address = resultSet.getString("address");
                    String birthday = resultSet.getString("birthday");
                    String phone = resultSet.getString("phone");
                    int classID = resultSet.getInt("class_id");
                    StudentEntity studentEntity = new StudentEntity(id, firstName, lastName, address, birthday,
                            phone, classID);
                    students.add(studentEntity);
                }
            }
        }
        return students;
    }

    @Override
    public StudentEntity readById(Integer id) throws SQLException {
        StudentEntity studentEntity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String firstName = resultSet.getString("first_name");
                    String lastName = resultSet.getString("last_name");
                    String address = resultSet.getString("address");
                    String birthday = resultSet.getString("birthday");
                    String phone = resultSet.getString("phone");
                    int classID = resultSet.getInt("class_id");
                    studentEntity = new StudentEntity(id, firstName, lastName, address, birthday, phone, classID);
                }
            }
        }
        return studentEntity;
    }

    @Override
    public int create(StudentEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getAddress());
            preparedStatement.setString(4, entity.getBirthday());
            preparedStatement.setString(5, entity.getPhone());
            preparedStatement.setInt(6, entity.getClassID());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public int update(StudentEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getAddress());
            preparedStatement.setString(4, entity.getBirthday());
            preparedStatement.setString(5, entity.getPhone());
            preparedStatement.setInt(6, entity.getClassID());
            preparedStatement.setInt(7, entity.getId());
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
