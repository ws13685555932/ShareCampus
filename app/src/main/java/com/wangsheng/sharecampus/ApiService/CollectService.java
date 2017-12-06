package com.wangsheng.sharecampus.ApiService;

import com.wangsheng.sharecampus.bean.CollectBean;
import com.wangsheng.sharecampus.bean.ResponseInfo;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by windows8 on 2017/12/2.
 */

public interface CollectService {
    @POST("collect/insert")
    Observable<ResponseInfo<CollectBean>> insert(@Body CollectBean comment);
    @POST("collect/delete")
    Observable<ResponseInfo<CollectBean>> delete(@Body CollectBean comment);
    @GET("collect/getAllCollects")
    Observable<ResponseInfo<CollectBean>> getAllCollects(@Body String pageNo,@Body String pageSize);
}
