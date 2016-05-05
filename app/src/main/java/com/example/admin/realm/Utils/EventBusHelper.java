package com.example.admin.realm.Utils;

import android.os.Bundle;

import com.example.admin.realm.activity.ViewEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by admin on 2016/4/26.
 */
public class EventBusHelper {
    private EventBusHelper() {
    }

    public static void showData(){
        Bundle bundle = new Bundle();
        EventBus.getDefault().post(new ViewEvent(ViewEvent.EventType.showData,bundle));
    }

    public static void toTwoData(){
        Bundle bundle = new Bundle();
        EventBus.getDefault().post(new ViewEvent(ViewEvent.EventType.twoData,bundle));
    }
}
