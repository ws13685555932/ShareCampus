package com.wangsheng.sharecampus.ApiService;

import com.wangsheng.sharecampus.ApiServiceBean.PocketServiceRequest.PocketBalanceRequest;
import com.wangsheng.sharecampus.ApiServiceBean.PocketServiceRequest.PocketUpdateRequest;
import com.wangsheng.sharecampus.ApiServiceBean.PocketServiceResponse.PocketBalanceResponse;
import com.wangsheng.sharecampus.ApiServiceBean.PocketServiceResponse.PocketUpdateResponse;
import com.wangsheng.sharecampus.bean.ResponseInfo;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by windows8 on 2017/12/2.
 */

public interface PocketService {
    @POST("/pocket/balance")
    Observable<ResponseInfo<PocketBalanceResponse>> balance(@Body PocketBalanceRequest pocket);

    @POST("/pocket/balance")
    Observable<ResponseInfo<PocketUpdateResponse>> changePass(@Body PocketUpdateRequest pocket);

}
