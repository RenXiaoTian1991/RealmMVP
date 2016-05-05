package com.example.admin.realm.activity;

import android.util.Log;

import com.example.admin.realm.R;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by admin on 2016/4/26.
 */
public class TwoActivity extends BaseActivity {
    @Override
    protected void initView() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.two;
    }

    @Override
    protected void initPresenter() {

    }

    /**
     * 处理主界面的事件.
     *
     * @param event 主界面可处理响应事件
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(ViewEvent event) {
        ViewEvent.EventType type = event.getmType();
        switch (type){
            case twoData:
                Log.e("abc", "未在内存中时发送的数据接收到了");
                break;
        }
    }


}
