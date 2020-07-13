package com.epam.model;

public class RoomEntity {
    private int id;
    private String number;
    private String description;

    public RoomEntity() {
    }

    public RoomEntity(String number, String description) {
        super();
        this.number = number;
        this.description = description;
    }

    public RoomEntity(int id, String number, String description) {
        this.id = id;
        this.number = number;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RoomEntity{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
