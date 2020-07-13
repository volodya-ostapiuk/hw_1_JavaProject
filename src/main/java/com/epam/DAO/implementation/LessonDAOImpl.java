package com.epam.DAO.implementation;

import com.epam.DAO.LessonDAO;
import com.epam.model.LessonEntity;
import com.epam.service.ConnectionManager;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonDAOImpl implements LessonDAO {
    private static final String GET_ALL = "select * from lesson";
    private static final String GET_BY_ID = "select * from lesson where lesson_id=?";
    private static final String INSERT = "insert into lesson (class_id, room_id, subject_id, teacher_id, topic, " +
            "homework, date) values (?,?,?,?,?,?,?)";
    private static final String UPDATE = "update lesson set class_id=?, room_id=?, subject_id=?, teacher_id=?, " +
            "topic=?, homework=?, date=? where lesson_id=?";
    private static final String DELETE = "delete from lesson where lesson_id=?";

    @Override
    public List<LessonEntity> readAll() throws SQLException {
        List<LessonEntity> lessons = new ArrayList<>();
        Connection connection = ConnectionManager.getConnection();
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery(GET_ALL)) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("lesson_id");
                    int classID = resultSet.getInt("class_id");
                    int roomID = resultSet.getInt("room_id");
                    int subjectID = resultSet.getInt("subject_id");
                    int teacherID = resultSet.getInt("teacher_id");
                    String topic = resultSet.getString("topic");
                    String homework = resultSet.getString("homework");
                    String date = resultSet.getString("date");
                    LessonEntity lessonEntity = new LessonEntity(id, classID, roomID, subjectID, teacherID,
                            topic, homework, date);
                    lessons.add(lessonEntity);
                }
            }
        }
        return lessons;
    }

    @Override
    public LessonEntity readById(Integer id) throws SQLException {
        LessonEntity lessonEntity = null;
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID)) {
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int classID = resultSet.getInt("class_id");
                    int roomID = resultSet.getInt("room_id");
                    int subjectID = resultSet.getInt("subject_id");
                    int teacherID = resultSet.getInt("teacher_id");
                    String topic = resultSet.getString("topic");
                    String homework = resultSet.getString("homework");
                    String date = resultSet.getString("date");
                    lessonEntity = new LessonEntity(id, classID, roomID, subjectID, teacherID, topic, homework, date);
                }
            }
        }
        return lessonEntity;
    }

    @Override
    public int create(LessonEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setInt(1, entity.getClassID());
            preparedStatement.setInt(2, entity.getRoomID());
            preparedStatement.setInt(3, entity.getSubjectID());
            preparedStatement.setInt(4, entity.getTeacherID());
            preparedStatement.setString(5, entity.getTopic());
            preparedStatement.setString(6, entity.getHomework());
            preparedStatement.setString(7, entity.getDate());
            return preparedStatement.executeUpdate();
        }
    }

    @Override
    public int update(LessonEntity entity) throws SQLException {
        Connection connection = ConnectionManager.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, entity.getClassID());
            preparedStatement.setInt(2, entity.getRoomID());
            preparedStatement.setInt(3, entity.getSubjectID());
            preparedStatement.setInt(4, entity.getTeacherID());
            preparedStatement.setString(5, entity.getTopic());
            preparedStatement.setString(6, entity.getHomework());
            preparedStatement.setString(7, entity.getDate());
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
