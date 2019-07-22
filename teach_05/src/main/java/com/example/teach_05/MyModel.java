package com.example.teach_05;

public class MyModel {

    //======================这部分手写======================
    private String title;
    private String subTitle;
    private String url;
    //============================================

    // 同时按command+N   在弹出框中选择Constructor
    // 按住Command，选中所有的变量，按ok， 能够自动生成下边的构造方法
    public MyModel(String title, String subTitle, String url) {
        this.title = title;
        this.subTitle = subTitle;
        this.url = url;
    }

    //===========================================
    // 同时按command+N   在弹出框中选择Getter and Setter
    // 按住Command，选中所有的变量，按ok， 能够自动生成下边的方法


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
