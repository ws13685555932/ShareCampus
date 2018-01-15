package com.wangsheng.sharecampus.ApiService;

import com.google.gson.JsonObject;
import com.wangsheng.sharecampus.ApiServiceBean.UserServiceRequset.UserChangepassRequest;
import com.wangsheng.sharecampus.ApiServiceBean.UserServiceRequset.UserLoginRequest;
import com.wangsheng.sharecampus.ApiServiceBean.UserServiceRequset.UserRegisterRequest;
import com.wangsheng.sharecampus.ApiServiceBean.UserServiceResponse.UserChangepassResponse;
import com.wangsheng.sharecampus.ApiServiceBean.UserServiceResponse.UserEditResponse;
import com.wangsheng.sharecampus.ApiServiceBean.UserServiceResponse.UserLoginResponse;
import com.wangsheng.sharecampus.ApiServiceBean.UserServiceResponse.UserRegisterResponse;
import com.wangsheng.sharecampus.ApiServiceBean.UserServiceRequset.UserEditRequest;
import com.wangsheng.sharecampus.ApiServiceBean.UserServiceRequset.UserInfoRequset;
import com.wangsheng.sharecampus.bean.ResponseInfo;
import com.wangsheng.sharecampus.bean.UserRequest;

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
    Observable<ResponseInfo<UserLoginResponse>> login(@Body UserLoginRequest user);

    @POST("user/register")
    Observable<ResponseInfo<UserRegisterResponse>> register(@Body UserRegisterRequest user);

    @POST("user/info")
    Observable<ResponseInfo<JsonObject>> info(@Body UserInfoRequset userName);

    @POST("user/edit")
    Observable<ResponseInfo<UserEditResponse>> edit(@Body UserEditRequest user);

    @POST("user/changePass")
    Observable<ResponseInfo<UserChangepassResponse>> changePass(@Body UserChangepassRequest user);

    @GET("user/check")
    Observable<ResponseInfo<UserRequest>> check(@Query("userName") String userName);

    @POST("user/infoById")
    Observable<ResponseInfo<JsonObject>> infoById(@Body UserInfoRequset userId);
}
