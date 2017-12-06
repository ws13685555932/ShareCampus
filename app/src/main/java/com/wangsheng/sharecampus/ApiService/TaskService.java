package com.wangsheng.sharecampus.ApiService;

import com.wangsheng.sharecampus.activity.insertTask.CreateTaskBean;
import com.wangsheng.sharecampus.bean.ResponseInfo;
import com.wangsheng.sharecampus.bean.ResponseInfoList;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by windows8 on 2017/12/2.
 */

public interface TaskService {
    @POST("task/insert")
    Observable<ResponseInfo<CreateTaskBean>> insert(@Body CreateTaskBean task);
    @POST("task/insertWithPic")
    Observable<ResponseInfo<CreateTaskBean>> insertWithPic(@Body CreateTaskBean task);
    @POST("task/edit")
    Observable<ResponseInfo<CreateTaskBean>> edit(@Body CreateTaskBean task);
    @POST("task/delete")
    Observable<ResponseInfo<CreateTaskBean>> delete(@Body CreateTaskBean taskId);
    @GET("task/getTaskByTaskId")
    Observable<ResponseInfo<CreateTaskBean>> getTaskByTaskId(@Body int task);
    @GET("task/getTasks")
    Observable<ResponseInfoList<Object>> getTasks(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize);
    @GET("task/getAllTasks")
    Observable<ResponseInfo<String>> getAllTasks(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize, @Query("publisherId") int publisherId);
    @GET("task/getUncompletedTasks")
    Observable<ResponseInfo<String>> getUncompletedTasks(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize, @Query("publisherId") int publisherId);
    @GET("task/getCompletedTasks")
    Observable<ResponseInfo<String>> getCompletedTasks(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize, @Query("publisherId") int publisherId);
    @GET("task/searchTaskByTitle")
    Observable<ResponseInfo<String>> searchTaskByTitle(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize, @Query("title") String title);
    @GET("task/searchTaskByCategory")
    Observable<ResponseInfo<String>> searchTaskByCategory(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize, @Query("category") int category);
}
