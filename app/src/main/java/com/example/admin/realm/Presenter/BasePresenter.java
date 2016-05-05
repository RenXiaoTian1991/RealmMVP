package com.example.admin.realm.Presenter;


import android.app.Activity;

import com.example.admin.realm.View.IBaseView;

/**
 * Created by admin on 2016/4/26.
 */
public class BasePresenter<V extends IBaseView> {

    public Activity mActivity;
    public V mView;

    public BasePresenter(Activity mActivity, V mView) {
        this.mActivity = mActivity;
        this.mView = mView;
    }

    /*
    此方法主要是在合适的时机子类做一些初始化操作
     */
    public void onCreat(){}

    /*
    绑定操作视图操作对象到控制层
     */
    public void attachView(V mView){
        this.mView = mView;
    }

    /*
    释放view对象，防止产生内存泄漏
     */
    public void destroyView(){
        this.mView = null;
    }

}
