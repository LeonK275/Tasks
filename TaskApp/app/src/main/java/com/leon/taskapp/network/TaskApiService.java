package com.leon.taskapp.network;

import com.leon.taskapp.model.Task;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TaskApiService {

    @GET("tasks")
    Call<List<Task>> getTasks();



}
