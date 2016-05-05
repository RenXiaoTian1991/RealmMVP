package com.example.admin.realm.Presenter;

import android.app.Activity;
import android.util.Log;

import com.example.admin.realm.Utils.EventBusHelper;
import com.example.admin.realm.View.IMainView;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by admin on 2016/4/26.
 */
public class MianPresenter extends BasePresenter<IMainView> {

    public MianPresenter(Activity mActivity, IMainView mView) {
        super(mActivity, mView);
    }

    public void getDataTask(){
        mView.showDialog();
        Log.e("晓天", "开始请求");
        Observable.timer(4000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Log.e("晓天","发送请求结果");
//                        EventBusHelper.showData();
                        mView.showMainData();
                    }
                });
    }

}
