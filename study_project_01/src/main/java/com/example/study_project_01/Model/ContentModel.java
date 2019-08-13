package com.example.study_project_01.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class ContentModel implements Parcelable {
    private String url;
    private String content;
    private long time;

    protected ContentModel(Parcel in) {
        url = in.readString();
        content = in.readString();
        time = in.readLong();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(url);
        dest.writeString(content);
        dest.writeLong(time);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<ContentModel> CREATOR = new Creator<ContentModel>() {
        @Override
        public ContentModel createFromParcel(Parcel in) {
            return new ContentModel(in);
        }

        @Override
        public ContentModel[] newArray(int size) {
            return new ContentModel[size];
        }
    };

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public ContentModel(String url, String content, long time) {
        this.url = url;
        this.content = content;
        this.time = time;
    }
}
