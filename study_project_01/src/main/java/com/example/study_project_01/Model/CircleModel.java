package com.example.study_project_01.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class CircleModel implements Parcelable {

    private String content;
    private String url;


    public CircleModel(String content, String url) {
        this.content = content;
        this.url = url;
    }

    protected CircleModel(Parcel in) {
        content = in.readString();
        url = in.readString();
    }

    public static final Creator<CircleModel> CREATOR = new Creator<CircleModel>() {
        @Override
        public CircleModel createFromParcel(Parcel in) {
            return new CircleModel(in);
        }

        @Override
        public CircleModel[] newArray(int size) {
            return new CircleModel[size];
        }
    };

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(content);
        parcel.writeString(url);
    }
}
