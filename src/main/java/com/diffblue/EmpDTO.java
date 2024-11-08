package com.diffblue;

public class EmpDTO {
    int id;
    String name;
    String dept;

    public EmpDTO(int id, String name, String dept) {
        this.id = id;
        this.name = name;
        this.dept = dept;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }
}
