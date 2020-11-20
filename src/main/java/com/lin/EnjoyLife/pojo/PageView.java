package com.lin.EnjoyLife.pojo;

public class PageView {
    private Integer pid;
    private String name;
    private Integer count;

    public PageView() {
    }

    public PageView(Integer pid, String name, Integer count) {
        this.pid = pid;
        this.name = name;
        this.count = count;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "pageView{" +
                "pid=" + pid +
                ", name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
