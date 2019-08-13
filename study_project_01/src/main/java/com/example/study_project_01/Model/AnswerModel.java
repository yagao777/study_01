package com.example.study_project_01.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class AnswerModel implements Parcelable {
    private String question;
    private long time;

    public AnswerModel(String question, long time) {
        this.question = question;
        this.time = time;
    }

    protected AnswerModel(Parcel in) {
        question = in.readString();
        time = in.readLong();
    }

    public static final Creator<AnswerModel> CREATOR = new Creator<AnswerModel>() {
        @Override
        public AnswerModel createFromParcel(Parcel in) {
            return new AnswerModel(in);
        }

        @Override
        public AnswerModel[] newArray(int size) {
            return new AnswerModel[size];
        }
    };

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(question);
        parcel.writeLong(time);
    }
}
