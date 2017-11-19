package com.wangsheng.sharecampus.ApiService;

import com.wangsheng.sharecampus.bean.ResponseInfo;
import com.wangsheng.sharecampus.bean.UserRequest;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by windows8 on 2017/11/15.
 */

public interface UserService {
    @POST("user/login")
    Observable<ResponseInfo<UserRequest>> login(@Body UserRequest user);

    @POST("user/register")
    Observable<ResponseInfo<UserRequest>> register(@Body UserRequest user);
}
