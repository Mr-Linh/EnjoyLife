package com.lin.EnjoyLife.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

public class Task {
    private String TaskId;
    private String Category1;
    private String Category2;
    private String Publisher;
    private String PublishTime;
    private Date DeadLine;
    private String Theme;
    private String Content;
    private String Special;
    private String TLevel;
    private Integer Price;
    private String PublisherPhone;
    private Integer TState;
    private String Executor;
    private String ExecutorPhone;
    private String Evaluation;

    public Task() {
    }

    public Task(String taskId, String category1, String category2, String publisher, String publishTime, Date deadLine, String theme, String content, String special, String TLevel, Integer price, String publisherPhone, Integer TState, String executor, String executorPhone, String evaluation) {
        TaskId = taskId;
        Category1 = category1;
        Category2 = category2;
        Publisher = publisher;
        PublishTime = publishTime;
        DeadLine = deadLine;
        Theme = theme;
        Content = content;
        Special = special;
        this.TLevel = TLevel;
        Price = price;
        PublisherPhone = publisherPhone;
        this.TState = TState;
        Executor = executor;
        ExecutorPhone = executorPhone;
        Evaluation = evaluation;
    }

    public String getTaskId() {
        return TaskId;
    }

    public void setTaskId(String taskId) {
        TaskId = taskId;
    }

    public String getCategory1() {
        return Category1;
    }

    public void setCategory1(String category1) {
        Category1 = category1;
    }

    public String getCategory2() {
        return Category2;
    }

    public void setCategory2(String category2) {
        Category2 = category2;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public String getPublishTime() {
        return PublishTime;
    }

    public void setPublishTime(String publishTime) {
        PublishTime = publishTime;
    }

    public Date getDeadLine() {
        return DeadLine;
    }

    public void setDeadLine(Date deadLine) {
        DeadLine = deadLine;
    }

    public String getTheme() {
        return Theme;
    }

    public void setTheme(String theme) {
        Theme = theme;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getSpecial() {
        return Special;
    }

    public void setSpecial(String special) {
        Special = special;
    }

    public String getTLevel() {
        return TLevel;
    }

    public void setTLevel(String TLevel) {
        this.TLevel = TLevel;
    }

    public Integer getPrice() {
        return Price;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public String getPublisherPhone() {
        return PublisherPhone;
    }

    public void setPublisherPhone(String publisherPhone) {
        PublisherPhone = publisherPhone;
    }

    public Integer getTState() {
        return TState;
    }

    public void setTState(Integer TState) {
        this.TState = TState;
    }

    public String getExecutor() {
        return Executor;
    }

    public void setExecutor(String executor) {
        Executor = executor;
    }

    public String getExecutorPhone() {
        return ExecutorPhone;
    }

    public void setExecutorPhone(String executorPhone) {
        ExecutorPhone = executorPhone;
    }

    public String getEvaluation() {
        return Evaluation;
    }

    public void setEvaluation(String evaluation) {
        Evaluation = evaluation;
    }

    @Override
    public String toString() {
        return "Task{" +
                "TaskId='" + TaskId + '\'' +
                ", Category1='" + Category1 + '\'' +
                ", Category2='" + Category2 + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", PublishTime='" + PublishTime + '\'' +
                ", DeadLine=" + DeadLine +
                ", Theme='" + Theme + '\'' +
                ", Content='" + Content + '\'' +
                ", Special='" + Special + '\'' +
                ", TLevel='" + TLevel + '\'' +
                ", Price=" + Price +
                ", PublisherPhone='" + PublisherPhone + '\'' +
                ", TState=" + TState +
                ", Executor='" + Executor + '\'' +
                ", ExecutorPhone='" + ExecutorPhone + '\'' +
                ", Evaluation='" + Evaluation + '\'' +
                '}';
    }
}
