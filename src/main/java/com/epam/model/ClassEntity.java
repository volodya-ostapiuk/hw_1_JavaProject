package com.epam.model;

public class ClassEntity {
    private int id;
    private String name;
    private String description;
    private int teacherID;

    public ClassEntity() {
    }

    public ClassEntity(String name, String description, int teacherID) {
        super();
        this.name = name;
        this.description = description;
        this.teacherID = teacherID;
    }

    public ClassEntity(int id, String name, String description, int teacherID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.teacherID = teacherID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTeacherID() {
        return teacherID;
    }

    public void setTeacherID(int teacherID) {
        this.teacherID = teacherID;
    }

    @Override
    public String toString() {
        return "ClassEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", teacherID=" + teacherID +
                '}';
    }
}
