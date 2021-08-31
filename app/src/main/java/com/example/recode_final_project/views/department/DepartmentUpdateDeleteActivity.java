package com.example.recode_final_project.views.department;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recode_final_project.R;
import com.example.recode_final_project.model.Department;
import com.example.recode_final_project.retrofit.RetrofitConfiguration;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartmentUpdateDeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_update_delete);

        EditText departmentId = findViewById(R.id.edDepartmentId);
        EditText departmentName = findViewById(R.id.edDepartmentName);

        Intent intent = getIntent();
        String id = Integer.toString(intent.getIntExtra("ID", 0));

        Call<Department> call = new RetrofitConfiguration().getDepartmentService().getDepartmentById(Integer.parseInt(id));

        call.enqueue(new Callback<Department>() {
            @Override
            public void onResponse(Call<Department> call, Response<Department> response) {
                Department department = response.body();
                departmentId.setText(department.getId());
                departmentName.setText(department.getName());
            }

            @Override
            public void onFailure(Call<Department> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro de conexão", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void updateDepartment(View view) {

    }
}