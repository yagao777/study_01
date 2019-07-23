package com.example.teach_05;

import android.os.Parcel;
import android.os.Parcelable;

// 除了基本的数据类型(int,float,double,String等)，自定义的类要在Activity之间传递，必须实现序列化的接口Parcelable
public class MyModel implements Parcelable {

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


    protected MyModel(Parcel in) {
        title = in.readString();
        subTitle = in.readString();
        url = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(subTitle);
        dest.writeString(url);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MyModel> CREATOR = new Creator<MyModel>() {
        @Override
        public MyModel createFromParcel(Parcel in) {
            return new MyModel(in);
        }

        @Override
        public MyModel[] newArray(int size) {
            return new MyModel[size];
        }
    };

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
