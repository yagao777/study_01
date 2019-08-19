package com.example.study_project_01.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class MessageModel implements Parcelable {
    private String name;
    private String introduce;
    private long birth;

    private int userId;

    public MessageModel() {
    }

    protected MessageModel(Parcel in) {
        name = in.readString();
        introduce = in.readString();
        birth = in.readLong();
        userId = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(introduce);
        dest.writeLong(birth);
        dest.writeInt(userId);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<MessageModel> CREATOR = new Creator<MessageModel>() {
        @Override
        public MessageModel createFromParcel(Parcel in) {
            return new MessageModel(in);
        }

        @Override
        public MessageModel[] newArray(int size) {
            return new MessageModel[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public long getBirth() {
        return birth;
    }

    public void setBirth(long birth) {
        this.birth = birth;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
