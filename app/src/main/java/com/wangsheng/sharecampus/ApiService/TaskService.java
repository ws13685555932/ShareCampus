package com.wangsheng.sharecampus.ApiService;

import com.google.gson.JsonArray;
import com.wangsheng.sharecampus.ApiServiceBean.TaskServiceRequest.TaskCreatetaskRequest;
import com.wangsheng.sharecampus.ApiServiceBean.TaskServiceRequest.TaskDeleteRequest;
import com.wangsheng.sharecampus.ApiServiceBean.TaskServiceRequest.TaskEditRequest;
import com.wangsheng.sharecampus.ApiServiceBean.TaskServiceRequest.TaskSearchByCategoryRequest;
import com.wangsheng.sharecampus.ApiServiceBean.TaskServiceRequest.TaskSearchByTitleRequest;
import com.wangsheng.sharecampus.ApiServiceBean.TaskServiceRequest.TaskgetUserTaskRequest;
import com.wangsheng.sharecampus.ApiServiceBean.TaskServiceResponse.TaskCreatetaskResponse;
import com.wangsheng.sharecampus.ApiServiceBean.TaskServiceResponse.TaskgetTaskResponse;
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
    Observable<ResponseInfo<TaskCreatetaskResponse>> insert(@Body TaskCreatetaskRequest task);
    @POST("task/insertWithPic")
    Observable<ResponseInfo<TaskCreatetaskResponse>> insertWithPic(@Body TaskCreatetaskRequest task);
    @POST("task/edit")
    Observable<ResponseInfo<TaskEditRequest>> edit(@Body TaskEditRequest task);
    @POST("task/delete")
    Observable<ResponseInfo<TaskDeleteRequest>> delete(@Body TaskDeleteRequest taskId);
    @GET("task/getTaskByTaskId")
    Observable<ResponseInfo<TaskgetTaskResponse>> getTaskByTaskId(@Query("taskId") int task);
    @GET("task/getTasks")
    Observable<ResponseInfoList<JsonArray>> getTasks(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize);
    @POST("task/getAllTasks")
    Observable<ResponseInfoList<JsonArray>> getAllTasks(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize, @Body TaskgetUserTaskRequest publisherId);
    @POST("task/getUncompletedTasks")
    Observable<ResponseInfoList<JsonArray>> getUncompletedTasks(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize, @Body TaskgetUserTaskRequest publisherId);
    @POST("task/getCompletedTasks")
    Observable<ResponseInfoList<JsonArray>> getCompletedTasks(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize, @Body TaskgetUserTaskRequest publisherId);
    @POST("task/searchTaskByTitle")
    Observable<ResponseInfoList<JsonArray>> searchTaskByTitle(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize, @Body TaskSearchByTitleRequest title);
    @POST("task/searchTaskByCategory")
    Observable<ResponseInfoList<JsonArray>> searchTaskByCategory(@Query("pageNo") int pageNo, @Query("pageSize") int pageSize, @Body TaskSearchByCategoryRequest categoty);
}
