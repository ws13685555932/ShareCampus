package com.wangsheng.sharecampus.dialog;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wangsheng.sharecampus.ApiService.UserService;
import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.bean.ResponseInfo;
import com.wangsheng.sharecampus.bean.UserRequest;
import com.wangsheng.sharecampus.util.HttpManager;
import com.wangsheng.sharecampus.util.HttpObserver;
import com.wangsheng.sharecampus.util.RxSchedulersHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.reactivex.Observable;


/**
 * Created by windows8 on 2017/11/15.
 */

public class LoginDialog extends DialogFragment {
    public static final String TAG = "LoginDialog";
    @BindView(R.id.login_button_login)
    Button login;
    @BindView(R.id.login_edittext_password)
    EditText etpassword;
    @BindView(R.id.login_edittext_phone)
    EditText etphone;
    @BindView(R.id.login_textview_forget)
    TextView ttforget;
    @BindView(R.id.login_textview_register)
    TextView ttregister;
    Unbinder unbinder;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        View view = inflater.inflate(R.layout.dialog_login, container, false);
        ButterKnife.bind(this,view);
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @OnClick({R.id.login_textview_register,R.id.login_textview_forget,R.id.login_button_login})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.login_button_login:
                String password = etpassword.getText().toString();
                String phone = etphone.getText().toString();
                if(password.length()==0){
                    Toast.makeText(getActivity(),"密码不能为空",Toast.LENGTH_SHORT).show();
                }else if(phone.length()==0){
                    Toast.makeText(getActivity(),"手机号不能为空",Toast.LENGTH_SHORT).show();
                }else{
                    signin(phone,password);
                }
                break;
            case R.id.login_textview_register:

                break;
            case R.id.login_textview_forget:

                break;
        }
    }
    private void signin(String phone,String password){
        UserService userService = HttpManager.getInstance().createService(UserService.class);
        UserRequest userRequest = new UserRequest();
        userRequest.setUserName(phone);
        userRequest.setUserPass(password);
        Observable<ResponseInfo<UserRequest>> call = userService.login(userRequest);
        call.compose(RxSchedulersHelper.<ResponseInfo<UserRequest>>io_main())
                .subscribe(new HttpObserver<UserRequest>() {
                    @Override
                    public void onSuccess(UserRequest userLogin) {
                        Toast.makeText(getActivity(),"登陆成功",Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onFailed(String message) {
                        Toast.makeText(getActivity(),"登陆失败"+message,Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
