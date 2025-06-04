package com.leon.taskapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.leon.taskapp.model.Task;
import com.leon.taskapp.network.ApiClient;
import com.leon.taskapp.network.TaskApiService;

import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TaskApiService taskApiService = ApiClient.getTaskService();
        taskApiService.getTasks().enqueue(new retrofit2.Callback<List<Task>>() {
            @Override
            public void onResponse(Call<List<Task>> call, Response<List<Task>> response) {

            }

            @Override
            public void onFailure(Call<List<Task>> call, Throwable t) {

            }
        });

        Log.d;
    }
}