package com.example.employeeapp.model;

public class Department {
    private int id;
    private String name;

    // Getters & setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Department{" +
               "id=" + id +
               ", name='" + name + '\'' +
               '}';
    }
}
