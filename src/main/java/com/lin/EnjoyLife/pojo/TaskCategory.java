package com.lin.EnjoyLife.pojo;

public class TaskCategory {
    private int value;
    private String name;

    public TaskCategory() {
    }

    public TaskCategory(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TaskCategory{" +
                "value=" + value +
                ", name='" + name + '\'' +
                '}';
    }
}
