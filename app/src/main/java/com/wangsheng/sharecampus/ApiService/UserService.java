package com.wangsheng.sharecampus.ApiService;

import com.wangsheng.sharecampus.activity.changepass.ChangepassBean;
import com.wangsheng.sharecampus.activity.editinfo.EditInfoBean;
import com.wangsheng.sharecampus.activity.myinfo.infoBean;
import com.wangsheng.sharecampus.activity.register.RegisterBean;
import com.wangsheng.sharecampus.bean.ResponseInfo;
import com.wangsheng.sharecampus.bean.UserRequest;
import com.wangsheng.sharecampus.dialog.login.LoginBean;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by windows8 on 2017/11/15.
 */

public interface UserService {
    @POST("user/login")
    Observable<ResponseInfo<LoginBean>> login(@Body LoginBean user);

    @POST("user/register")
    Observable<ResponseInfo<RegisterBean>> register(@Body RegisterBean user);

    @POST("user/info")
    Observable<ResponseInfo<Object>> info(@Body infoBean userName);

    @POST("user/edit")
    Observable<ResponseInfo<EditInfoBean>> edit(@Body EditInfoBean user);

    @POST("user/changePass")
    Observable<ResponseInfo<ChangepassBean>> changePass(@Body ChangepassBean user);

    @GET("user/check")
    Observable<ResponseInfo<UserRequest>> check(@Query("userName") String userName);

}
