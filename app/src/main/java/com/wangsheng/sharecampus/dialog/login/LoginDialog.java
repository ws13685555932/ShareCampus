package com.wangsheng.sharecampus.dialog.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.wangsheng.sharecampus.ApiService.UserService;
import com.wangsheng.sharecampus.R;
import com.wangsheng.sharecampus.activity.MainActivity;
import com.wangsheng.sharecampus.activity.changepass.ChangepassActivity;
import com.wangsheng.sharecampus.activity.register.RegisterActivity;
import com.wangsheng.sharecampus.bean.ResponseInfo;
import com.wangsheng.sharecampus.util.HttpManager;
import com.wangsheng.sharecampus.util.HttpObserver;
import com.wangsheng.sharecampus.util.RxSchedulersHelper;
import com.wangsheng.sharecampus.util.SharedUtil;

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
    @BindView(R.id.login_image_back)
    ImageView back;
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
        unbinder = ButterKnife.bind(this,view);
        return view;
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
    @OnClick({R.id.login_textview_register,R.id.login_textview_forget,R.id.login_button_login,R.id.login_image_back})
    public void onClick(View v){
        switch (v.getId()){
            case R.id.login_image_back:
                dismiss();
                break;
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
                Intent register = new Intent(getActivity(), RegisterActivity.class);
                startActivity(register);
                dismiss();
                break;
            case R.id.login_textview_forget:
                Intent forget = new Intent(getActivity(), ChangepassActivity.class);
                startActivity(forget);
                break;
        }
    }
    private void signin(final String phone,final String password){
        UserService userService = HttpManager.getInstance().createService(UserService.class);
        LoginBean loginbean = new LoginBean();
        loginbean.setUserName(phone);
        loginbean.setUserPass(password);
        Observable<ResponseInfo<LoginBean>> call = userService.login(loginbean);
        call.compose(RxSchedulersHelper.<ResponseInfo<LoginBean>>io_main())
                .subscribe(new HttpObserver<LoginBean>() {
                    @Override
                    public void onSuccess(LoginBean userLogin) {
                        SharedUtil.saveParam("islogin","1");
                        SharedUtil.saveParam("userName",phone);
                        SharedUtil.saveParam("userPass",password);
                        MainActivity.getMainActivity().refreshLogin();

                        dismiss();
                    }
                    @Override
                    public void onFailed(String message) {
                        Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
                    }
                });
    }

}
