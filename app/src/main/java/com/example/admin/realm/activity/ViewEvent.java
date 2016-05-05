package com.example.admin.realm.activity;

import android.os.Bundle;

/**
 * Created by admin on 2016/4/26.
 */
public class ViewEvent {
    private EventType mType;
    private Bundle args;

    public EventType getmType() {
        return mType;
    }

    public void setmType(EventType mType) {
        this.mType = mType;
    }

    public Bundle getArgs() {
        return args;
    }

    public void setArgs(Bundle args) {
        this.args = args;
    }

    public ViewEvent(EventType mType, Bundle args) {
        this.mType = mType;
        this.args = args;
    }

    public enum EventType{
       showData,
        twoData
    }
}
