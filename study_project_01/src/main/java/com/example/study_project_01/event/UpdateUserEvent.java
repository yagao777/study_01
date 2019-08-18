package com.example.study_project_01.event;

import org.greenrobot.eventbus.EventBus;

public class UpdateUserEvent {
    public String userName;

    public UpdateUserEvent(String userName) {
        this.userName = userName;
    }

    public static void sendEvent(UpdateUserEvent event) {
        EventBus.getDefault().post(event);
    }
}
