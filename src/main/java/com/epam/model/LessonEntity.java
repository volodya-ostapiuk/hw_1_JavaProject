package com.epam.model;

public class LessonEntity {
    private int id;
    private int classID;
    private int roomID;
    private int subjectID;
    private int teacherID;
    private String topic;
    private String homework;
    private String date;

    public LessonEntity() {
    }

    public LessonEntity(int classID, int roomID, int subjectID, int teacherID, String topic,
                        String homework, String date) {
        super();
        this.classID = classID;
        this.roomID = roomID;
        this.subjectID = subjectID;
        this.teacherID = teacherID;
        this.topic = topic;
        this.homework = homework;
        this.date = date;
    }

    public LessonEntity(int id, int classID, int roomID, int subjectID,
                        int teacherID, String topic, String homework, String date) {
        this.id = id;
        this.classID = classID;
        this.roomID = roomID;
        this.subjectID = subjectID;
        this.teacherID = teacherID;
        this.topic = topic;
        this.homework = homework;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClassID() {
        return classID;
    }

    public void setClassID(int classID) {
        this.classID = classID;
    }

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public int getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(int subjectID) {
        this.subjectID = subjectID;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "LessonEntity{" +
                "id=" + id +
                ", classID=" + classID +
                ", roomID=" + roomID +
                ", subjectID=" + subjectID +
                ", teacherID=" + teacherID +
                ", topic='" + topic + '\'' +
                ", homework='" + homework + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
