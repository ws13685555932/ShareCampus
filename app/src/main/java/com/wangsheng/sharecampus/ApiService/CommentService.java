package com.wangsheng.sharecampus.ApiService;

import com.google.gson.JsonArray;
import com.wangsheng.sharecampus.ApiServiceBean.CommentServiceRequest.CommentDeleteRequest;
import com.wangsheng.sharecampus.ApiServiceBean.CommentServiceRequest.CommentInsertRequest;
import com.wangsheng.sharecampus.ApiServiceBean.CommentServiceRequest.CommentgetTaskRequest;
import com.wangsheng.sharecampus.ApiServiceBean.CommentServiceRequest.CommentgetUserRequest;
import com.wangsheng.sharecampus.ApiServiceBean.CommentServiceResponse.CommentDeleteResponse;
import com.wangsheng.sharecampus.ApiServiceBean.CommentServiceResponse.CommentInsertResponse;
import com.wangsheng.sharecampus.bean.ResponseInfo;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by windows8 on 2017/12/2.
 */

public interface CommentService {
    @POST("comment/insert")
    Observable<ResponseInfo<CommentInsertResponse>> insert(@Body CommentInsertRequest comment);
    @POST("comment/delete")
    Observable<ResponseInfo<CommentDeleteResponse>> delete(@Body CommentDeleteRequest comment);
    @POST("comment/getAllComments")
    Observable<ResponseInfo<JsonArray>> getAllComments(@Body CommentgetUserRequest comment);
    @POST("comment/getTaskComments")
    Observable<ResponseInfo<JsonArray>> getTaskComments(@Body CommentgetTaskRequest comment);
}
