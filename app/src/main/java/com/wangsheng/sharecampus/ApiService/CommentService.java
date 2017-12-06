package com.wangsheng.sharecampus.ApiService;

import com.wangsheng.sharecampus.bean.CommentBean;
import com.wangsheng.sharecampus.bean.ResponseInfo;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by windows8 on 2017/12/2.
 */

public interface CommentService {
    @POST("comment/insert")
    Observable<ResponseInfo<CommentBean>> insert(@Body CommentBean comment);
    @POST("comment/delete")
    Observable<ResponseInfo<CommentBean>> delete(@Body CommentBean comment);
    @POST("comment/getAllComments")
    Observable<ResponseInfo<CommentBean>> getAllComments(@Body CommentBean comment);
    @POST("comment/getTaskComments")
    Observable<ResponseInfo<CommentBean>> getTaskComments(@Body CommentBean comment);
}
