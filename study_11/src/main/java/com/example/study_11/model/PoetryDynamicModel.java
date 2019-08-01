package com.example.study_11.model;

import android.os.Parcel;
import android.os.Parcelable;


public class PoetryDynamicModel implements Parcelable {

    private String author_header_url;
    private String author_name;
    private String author_content;
    private long time;

    public PoetryDynamicModel(String author_header_url, String author_name, String author_content, long time) {
        this.author_header_url = author_header_url;
        this.author_name = author_name;
        this.author_content = author_content;
        this.time = time;
    }

    protected PoetryDynamicModel(Parcel in) {
        author_header_url = in.readString();
        author_name = in.readString();
        author_content = in.readString();
        time = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(author_header_url);
        dest.writeString(author_name);
        dest.writeString(author_content);
        dest.writeLong(time);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<PoetryDynamicModel> CREATOR = new Creator<PoetryDynamicModel>() {
        @Override
        public PoetryDynamicModel createFromParcel(Parcel in) {
            return new PoetryDynamicModel(in);
        }

        @Override
        public PoetryDynamicModel[] newArray(int size) {
            return new PoetryDynamicModel[size];
        }
    };

    public String getAuthor_header_url() {
        return author_header_url;
    }

    public void setAuthor_header_url(String author_header_url) {
        this.author_header_url = author_header_url;
    }

    public String getAuthor_name() {
        return author_name;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }

    public String getAuthor_content() {
        return author_content;
    }

    public void setAuthor_content(String author_content) {
        this.author_content = author_content;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
