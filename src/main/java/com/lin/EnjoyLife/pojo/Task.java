package com.lin.EnjoyLife.pojo;

import java.sql.Date;

public class Task {
    private String Task;
    private String Category1;
    private String Category2;
    private String Publisher;
    private Date PublishTime;
    private Date DeadLine;
    private String Theme;
    private String Content;
    private String Special;
    private String TLevel;
    private Integer Price;
    private String PublisherPhone;
    private String Executor;
    private String ExecutorPhone;
    private String Evaluation;

    public Task() {
    }

    public Task(String task, String category1, String category2, String publisher, Date publishTime, Date deadLine, String theme, String content, String special, String TLevel, Integer price, String publisherPhone, String executor, String executorPhone, String evaluation) {
        Task = task;
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
        Executor = executor;
        ExecutorPhone = executorPhone;
        Evaluation = evaluation;
    }

    public String getTask() {
        return Task;
    }

    public void setTask(String task) {
        Task = task;
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

    public Date getPublishTime() {
        return PublishTime;
    }

    public void setPublishTime(Date publishTime) {
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
                "Task='" + Task + '\'' +
                ", Category1='" + Category1 + '\'' +
                ", Category2='" + Category2 + '\'' +
                ", Publisher='" + Publisher + '\'' +
                ", PublishTime=" + PublishTime +
                ", DeadLine=" + DeadLine +
                ", Theme='" + Theme + '\'' +
                ", Content='" + Content + '\'' +
                ", Special='" + Special + '\'' +
                ", TLevel='" + TLevel + '\'' +
                ", Price=" + Price +
                ", PublisherPhone='" + PublisherPhone + '\'' +
                ", Executor='" + Executor + '\'' +
                ", ExecutorPhone='" + ExecutorPhone + '\'' +
                ", Evaluation='" + Evaluation + '\'' +
                '}';
    }
}
