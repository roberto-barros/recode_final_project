package com.example.recode_final_project.views;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recode_final_project.R;
import com.example.recode_final_project.adapter.Department_Adapter;
import com.example.recode_final_project.model.Department;
import com.example.recode_final_project.retrofit.RetrofitConfiguration;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.department_activity);

        ListView listView = findViewById(R.id.lvDep);

        listView.setAdapter(new Department_Adapter(this, R.layout.department_item_list, ));

    }

    public void getAllDepartments(){

        Call<List<Department>> call = new RetrofitConfiguration().getDepartmentService().getDepartments();

        call.enqueue(new Callback<List<Department>>() {
            @Override
            public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {

                List<Department> departments = response.body();

                for (Department department : departments){

                }

            }

            @Override
            public void onFailure(Call<List<Department>> call, Throwable t) {

            }
        });

    }


}