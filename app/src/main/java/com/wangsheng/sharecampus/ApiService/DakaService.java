package com.wangsheng.sharecampus.ApiService;

import com.wangsheng.sharecampus.bean.DakaBean;
import com.wangsheng.sharecampus.bean.ResponseInfo;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by windows8 on 2017/12/2.
 */

public interface DakaService {
    @POST("daka/insert")
    Observable<ResponseInfo<DakaBean>> insert(@Body DakaBean daka);

    @POST("daka/delete")
    Observable<ResponseInfo<DakaBean>> delete(@Body DakaBean daka);

    @POST("daka/update")
    Observable<ResponseInfo<DakaBean>> update(@Body DakaBean daka);

    @GET("daka/info")
    Observable<ResponseInfo<DakaBean>> info(@Body String dakaId);
}
