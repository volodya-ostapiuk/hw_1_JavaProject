package com.epam.model;

public class SubjectEntity {
    private int id;
    private String name;
    private String description;

    public SubjectEntity() {
    }

    public SubjectEntity(int id, String number, String description) {
        this.id = id;
        this.name = number;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return name;
    }

    public void setNumber(String number) {
        this.name = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
