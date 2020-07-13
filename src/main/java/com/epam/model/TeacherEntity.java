package com.epam.model;

import java.sql.Date;

public class TeacherEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private int salary;
    private String category;
    private String birthday;

    public TeacherEntity() {
    }

    public TeacherEntity(String firstName, String lastName, String address, String phone, int salary,
                         String category, String birthday) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.salary = salary;
        this.category = category;
        this.birthday = birthday;
    }

    public TeacherEntity(int id, String firstName, String lastName, String address,
                         String phone, int salary, String category, String birthday) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.salary = salary;
        this.category = category;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "TeacherEntity{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", salary=" + salary +
                ", category='" + category + '\'' +
                ", birthday='" + birthday + '\'' +
                '}';
    }
}
