package com.lin.EnjoyLife.pojo;

public class Manager {
    private String ManagerId;
    private String MPassword;
    private String Owner;
    private String MState;

    public Manager() {
    }

    public Manager(String managerId, String MPassword, String owner, String MState) {
        ManagerId = managerId;
        this.MPassword = MPassword;
        Owner = owner;
        this.MState = MState;
    }

    public String getManagerId() {
        return ManagerId;
    }

    public void setManagerId(String managerId) {
        ManagerId = managerId;
    }

    public String getMPassword() {
        return MPassword;
    }

    public void setMPassword(String MPassword) {
        this.MPassword = MPassword;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getMState() {
        return MState;
    }

    public void setMState(String MState) {
        this.MState = MState;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "ManagerId='" + ManagerId + '\'' +
                ", MPassword='" + MPassword + '\'' +
                ", Owner='" + Owner + '\'' +
                ", MState='" + MState + '\'' +
                '}';
    }
}
