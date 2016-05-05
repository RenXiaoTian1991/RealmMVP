package com.example.admin.realm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.example.admin.realm.Model.Dog;
import com.example.admin.realm.Presenter.MianPresenter;
import com.example.admin.realm.R;
import com.example.admin.realm.Utils.EventBusHelper;
import com.example.admin.realm.View.IMainView;
import com.litesuits.android.async.SimpleTask;
import com.litesuits.android.async.TaskExecutor;
import com.zhy.base.adapter.ViewHolder;
import com.zhy.base.adapter.recyclerview.CommonAdapter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends BaseActivity<MianPresenter> implements IMainView,View.OnClickListener{

    private Realm realm;
    private RecyclerView listView;
    private RealmResults<Dog> query;
    private ProgressBar progressBar;
    private Button btn_get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        TestTask();

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        listView = (RecyclerView) findViewById(R.id.listview);
        progressBar = (ProgressBar) findViewById(R.id.progress);
        btn_get = (Button) findViewById(R.id.btn_get);
        btn_get.setOnClickListener(this);
        setSupportActionBar(toolbar);
        EventBusHelper.toTwoData();
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
            case showData:
                Log.e("abc","接收到了任务");
                showMainData();
                break;
        }
    }


        @Override
    protected void initPresenter() {
        mPreaenter = new MianPresenter(this,this);
    }


    private void TestTask() {
        SimpleTask<String> task1 = new SimpleTask<String>() {
            @Override
            protected String doInBackground() {
                SystemClock.sleep(1500);
                return null;
            }

            @Override
            protected void onPostExecute(String o) {

                super.onPostExecute(o);
                Log.e("晓天", "task1执行完成");
            }
        };

        SimpleTask<String> task2 = new SimpleTask<String>() {
            @Override
            protected String doInBackground() {
                SystemClock.sleep(1500);
                return null;
            }

            @Override
            protected void onPostExecute(String o) {

                super.onPostExecute(o);
                Log.e("晓天", "task2执行完成");
            }
        };
        SimpleTask<String> task3 = new SimpleTask<String>() {
            @Override
            protected String doInBackground() {
                SystemClock.sleep(1500);
                return null;
            }

            @Override
            protected void onPostExecute(String o) {

                super.onPostExecute(o);
                Log.e("晓天", "task3执行完成");
            }
        };

        TaskExecutor.newCyclicBarrierExecutor().put(task1).put(task2).start(task3);
    }

    private void initListView() {
        listView.setVisibility(View.VISIBLE);
        listView.setLayoutManager(new LinearLayoutManager(this));
        listView.setAdapter(new CommonAdapter<Dog>(this, R.layout.item_dog, query) {
            @Override
            public void convert(ViewHolder holder, Dog s) {
                holder.setText(R.id.txt_age, String.valueOf(s.getAge()));
                holder.setText(R.id.txt_name, s.getName());
            }
        });
    }


    private void initRealm() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this).build();
        realm = Realm.getInstance(realmConfiguration);

        query = realm.where(Dog.class)
//                .greaterThan("age",4)
                .findAll();
        if (!(query.size() > 0)) {
            initData();
        }
    }


    private void initData() {
        realm.beginTransaction();
        for (int i = 0; i < 10; i++) {
            Dog dog = realm.createObject(Dog.class);
            dog.setName("晓天");
            dog.setAge(i);
        }
        realm.commitTransaction();
    }


    @Override
    public void showDialog() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideDialog() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showMainData() {
        hideDialog();
        btn_get.setVisibility(View.GONE);
        initRealm();
        initListView();
    }

    @Override
    public void onClick(View v) {
//        mPreaenter.getDataTask();
        Intent intent = new Intent(MainActivity.this,TwoActivity.class);
        startActivity(intent);
    }
}

