package com.wangsheng.sharecampus.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.activity.LocationActivity;
import com.wangsheng.sharecampus.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by windows8 on 2017/10/23.
 */

public class SkillMainFragment extends Fragment {
    @BindView(R.id.ciriv_user_icon)
    CircleImageView icon;
    @BindView(R.id.ll_search)
    LinearLayout llsearch;
    @BindView(R.id.iv_location)
    ImageView ivlocation;
    @BindView(R.id.frame_skill)
    FrameLayout skillmain;
    @BindView(R.id.toolbar)
    Toolbar mainbar;
    @BindView(R.id.toolbar_search)
    Toolbar searchbar;
    @BindView(R.id.image_search)
    ImageView imagesearch;
    @BindView(R.id.edit_search)
    EditText editsearch;
    @BindView(R.id.image_cancel)
    ImageView imagecancel;
    Unbinder unbinder;
    Fragment skillFragment;
    Fragment searchFragment;
    InputMethodManager imm;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_skill_main, container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initEditText();
        return view;

    }
    public void initView(){
        skillFragment = new SkillFragment();
        searchFragment = new SearchFragment();
        SearchFragment.TYPE = "SKILL";
        addFragment(R.id.frame_skill,skillFragment);
        addFragment(R.id.frame_skill,searchFragment);
        hideFragment(searchFragment);
    }
    public void initEditText(){
        imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        editsearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                imagecancel.setVisibility(View.VISIBLE);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        imagecancel.setVisibility(View.GONE);
        editsearch.setHint("搜索大V姓名");
    }
    @OnClick(R.id.ciriv_user_icon)
    public void openDrawer(){
        MainActivity.drawer.openDrawer(Gravity.LEFT,true);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @OnClick({R.id.ll_search,R.id.iv_location,R.id.iv_cancel,R.id.image_cancel})
    public void onclick(final View v){
        switch (v.getId()){
            case R.id.ll_search:
                mainbar.setVisibility(View.GONE);
                searchbar.setVisibility(View.VISIBLE);
                showFragment(searchFragment);
                hideFragment(skillFragment);
                getActivity().getWindow().getDecorView().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                        if (imm != null) {
                            v.requestFocus();
                            imm.showSoftInput(v, 0);
                        }
                    }
                }, 100);
                break;
            case R.id.iv_location:
                Intent location = new Intent(getActivity(), LocationActivity.class);
                startActivity(location);
                break;
            case R.id.iv_cancel:
                mainbar.setVisibility(View.VISIBLE);
                searchbar.setVisibility(View.GONE);
                showFragment(skillFragment);
                hideFragment(searchFragment);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(getActivity().getWindow().getDecorView().getWindowToken(), 0);
                }
                break;
            case R.id.image_cancel:
                editsearch.setText("");
                imagecancel.setVisibility(View.GONE);
                break;
        }
    }
    private void showFragment(Fragment fragment) {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.show(fragment);
        transaction.commit();
    }

    private void hideFragment(Fragment fragment) {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.hide(fragment);
        transaction.commit();
    }

    private void addFragment(int layout, Fragment fragment) {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(layout,fragment);
        transaction.commit();
    }

}
