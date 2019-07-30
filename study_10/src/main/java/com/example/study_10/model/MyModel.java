package com.example.study_10.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MyModel implements Parcelable {
    private String title;
    private String subTitle;
    private String url;
    private long time;

    public MyModel(String title, String subTitle, String url, long time) {
        this.title = title;
        this.subTitle = subTitle;
        this.url = url;
        this.time = time;
    }

    protected MyModel(Parcel in) {
        title = in.readString();
        subTitle = in.readString();
        url = in.readString();
        time = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(subTitle);
        dest.writeString(url);
        dest.writeLong(time);
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

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}