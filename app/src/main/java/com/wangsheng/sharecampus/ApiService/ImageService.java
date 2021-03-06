package com.wangsheng.sharecampus.ApiService;

import com.wangsheng.sharecampus.bean.ResponseInfo;
import com.wangsheng.sharecampus.bean.UserRequest;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by windows8 on 2017/12/2.
 */

public interface ImageService {
    @POST("/image/upload")
    Observable<ResponseInfo<UserRequest>> changePass(@Body UserRequest user);
}
