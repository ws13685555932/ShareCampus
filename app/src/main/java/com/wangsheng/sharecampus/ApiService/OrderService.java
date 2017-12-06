package com.wangsheng.sharecampus.ApiService;

import com.wangsheng.sharecampus.bean.OrderBean;
import com.wangsheng.sharecampus.bean.ResponseInfo;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by windows8 on 2017/12/2.
 */

public interface OrderService {
    @POST("order/insert")
    Observable<ResponseInfo<OrderBean>> insert(@Body OrderBean order);
    @GET("order/queryPublishedOrders")
    Observable<ResponseInfo<OrderBean>> queryPublishedOrders(@Body String receiveId,@Body String orderStatus);
    @GET("order/queryReceivedOrders")
    Observable<ResponseInfo<OrderBean>> queryReceivedOrders(@Body String publisherId);
    @POST("order/updateOrderStatus")
    Observable<ResponseInfo<OrderBean>> updateOrderStatus(@Body OrderBean order);
}
