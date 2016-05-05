package com.example.admin.realm.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.realm.Presenter.BasePresenter;
import com.example.admin.realm.View.IBaseView;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by admin on 2016/4/26.
 */
public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements IBaseView {

    protected P mPreaenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        initPresenter();
        checkPresenterIsNull();
        EventBus.getDefault().register(this);
        mPreaenter.attachView(this);
        initView();
    }

    private void checkPresenterIsNull() {
        if(mPreaenter == null){
            throw new IllegalStateException("主控制器不能为空，请检查代码");
        }
    }


    protected abstract void initView();

    protected abstract int getLayoutId();

    protected abstract void initPresenter();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPreaenter.destroyView();
        EventBus.getDefault().unregister(this);
    }
}
