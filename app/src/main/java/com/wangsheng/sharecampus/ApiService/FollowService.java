package com.wangsheng.sharecampus.ApiService;

import com.wangsheng.sharecampus.bean.FollowBean;
import com.wangsheng.sharecampus.bean.ResponseInfo;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by windows8 on 2017/12/2.
 */

public interface FollowService {
    @POST("follow/insert")
    Observable<ResponseInfo<FollowBean>> insert(@Body FollowBean comment);
    @POST("follow/delete")
    Observable<ResponseInfo<FollowBean>> delete(@Body FollowBean comment);
    @GET("follow/getAllCollects")
    Observable<ResponseInfo<FollowBean>> getAllCollects(@Body String pageNo, @Body String pageSize);
}
