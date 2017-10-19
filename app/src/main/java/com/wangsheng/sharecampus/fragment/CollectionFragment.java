package com.wangsheng.sharecampus.fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wangsheng.sharecampus.bean.Person;
import com.wangsheng.sharecampus.bean.Task;
import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.adapter.CollectionPageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by windows8 on 2017/10/1.
 */

public class CollectionFragment extends LazyFragment {
    @BindView(R.id.iv_recycle)RecyclerView recyclerView;
    CollectionPageAdapter collectionPageAdapter;
    Unbinder unbinder;
    public int type = 0;//该界面显示为收藏任务还是收藏人，人0，任务1
    private List<Object> list = new ArrayList<Object>();
    private GridLayoutManager mLayoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collection,container,false);
        unbinder = ButterKnife.bind(this,view);
        return view;
    }
    @Override
    protected void onFragmentFirstVisible() {
        new ConstactAsyncTask().execute("");
    }
    private class ConstactAsyncTask extends AsyncTask<String, String, List<Object>> {

        @Override
        protected List<Object> doInBackground(String... params) {
            // TODO Auto-generated method stub
            list = new ArrayList<Object>();
            if(type == 1){
                Task task1 = new Task();
                task1.setTaskTitle("第一个任务");
                list.add(task1);
                list.add(task1);
                list.add(task1);
            }
            else{
                Person person = new Person();
                person.setPersonName("云一逸");
                list.add(person);
                Person person2 = new Person();
                person2.setPersonName("云二逸");
                list.add(person2);
                Person person3 = new Person();
                person3.setPersonName("云三逸");
                list.add(person3);
                Person person4 = new Person();
                person4.setPersonName("云四逸");
                list.add(person4);
            }
            return list;
        }
        @Override
        protected void onPostExecute(List<Object> result) {
            super.onPostExecute(result);
            mLayoutManager=new GridLayoutManager(getActivity(),1,GridLayoutManager.VERTICAL,false);//设置为一个1列的纵向网格布局
            recyclerView.setLayoutManager(mLayoutManager);
            collectionPageAdapter = new CollectionPageAdapter(getActivity(),result,type);
            recyclerView.setAdapter(collectionPageAdapter);
        }
    }
}
