package com.example.recode_final_project.views;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recode_final_project.R;
import com.example.recode_final_project.adapter.Department_Adapter;
import com.example.recode_final_project.model.Department;
import com.example.recode_final_project.retrofit.RetrofitConfiguration;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DepartmentActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.department_activity);

        getSupportActionBar().hide();

        getAll();

        listView = findViewById(R.id.lvDepartment);

    }

    public void getDepartmentById(View view) {

        EditText editText = findViewById(R.id.edDepartment);

        if(!editText.getText().toString().equals("") && !editText.getText().toString().equals(null)){
            int idDepartment = Integer.parseInt(editText.getText().toString());

            editText.setText("");

            Call<Department> call = new RetrofitConfiguration().getDepartmentService().getDepartmentById(idDepartment);

            call.enqueue(new Callback<Department>() {
                @Override
                public void onResponse(Call<Department> call, Response<Department> response) {
                    Department department = response.body();

                    ArrayList<Department> list = new ArrayList<>();

                    list.add(department);

                    listView.setAdapter(new Department_Adapter(DepartmentActivity.this, R.layout.department_item_list, list));

                    Toast.makeText(getApplicationContext(), "Departamento encontrado", Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<Department> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Erro!", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public void getAll() {

        Call<List<Department>> call = new RetrofitConfiguration().getDepartmentService().getDepartments();

        call.enqueue(new Callback<List<Department>>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {

                List<Department> departments = response.body();

                listView.setAdapter(new Department_Adapter(DepartmentActivity.this, R.layout.department_item_list, (ArrayList<Department>) departments));

                Toast.makeText(getApplicationContext(), "Busca Realizada", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<Department>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void switchToCreate(View view) {

        Intent intent = new Intent(this, CreateDepartmentActivity.class);
        startActivity(intent);

    }

    public void switchToUpdate(View view){
        TextView textView = findViewById(R.id.tvIdDep);
        int idDepartment = Integer.parseInt(textView.getText().toString());

        Intent intent = new Intent(this, DepartmentUpdateActivity.class);
        intent.putExtra("idDep", idDepartment);
        startActivity(intent);

    }
}