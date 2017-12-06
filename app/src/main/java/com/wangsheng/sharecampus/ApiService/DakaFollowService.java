package com.wangsheng.sharecampus.ApiService;

import com.wangsheng.sharecampus.bean.DakaFollowBean;
import com.wangsheng.sharecampus.bean.ResponseInfo;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by windows8 on 2017/12/2.
 */

public interface DakaFollowService {
    @POST("dakaFollow/follow")
    Observable<ResponseInfo<DakaFollowBean>> follow(@Body DakaFollowBean dakafollow);
    @POST("dakaFollow/unfollow")
    Observable<ResponseInfo<DakaFollowBean>> unfollow(@Body DakaFollowBean dakafollow);
    @POST("dakaFollow/getFollowerCount")
    Observable<ResponseInfo<DakaFollowBean>> getFollowerCount(@Body DakaFollowBean dakafollow);
    @POST("dakaFollow/getAllDakaFollows")
    Observable<ResponseInfo<DakaFollowBean>> getAllDakaFollows(@Body DakaFollowBean dakafollow);
}
