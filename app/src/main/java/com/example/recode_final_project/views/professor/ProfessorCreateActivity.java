package com.example.recode_final_project.views.professor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.recode_final_project.R;
import com.example.recode_final_project.model.Department;
import com.example.recode_final_project.model.Professor;
import com.example.recode_final_project.retrofit.RetrofitConfiguration;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfessorCreateActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_create);

        getSupportActionBar().hide();

        buildSpinner();

    }

    public void createProfessor(View view) {

        EditText editTextName = findViewById(R.id.edNameProfessor);
        String nameProfessor = editTextName.getText().toString();

        EditText editTextProfCPF = findViewById(R.id.edProfessorCPF);
        String profCPF = editTextProfCPF.getText().toString();

        Spinner spinnerDepProf = findViewById(R.id.spinnerProfessorDep);
        String profDep = spinnerDepProf.toString();
        Department department = new Department();
        department.setName(profDep);

        Professor newProfessor = new Professor();
        newProfessor.setName(nameProfessor);
        newProfessor.setCpf(profCPF);
        newProfessor.setDepartment(department);

        Call<Professor> call = new RetrofitConfiguration().getProfessorService().createProfessor(newProfessor);

        if(!nameProfessor.equals("") && !nameProfessor.equals(null) && !profCPF.equals("") && !profCPF.equals(null) && !profDep.equals("") && !profDep.equals(null)){
            call.enqueue(new Callback<Professor>() {
                @Override
                public void onResponse(Call<Professor> call, Response<Professor> response) {
                    if(response.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Professor Cadastrado!", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(getApplicationContext(), "Requisição Falhou!", Toast.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onFailure(Call<Professor> call, Throwable t) {
                    Toast.makeText(getApplicationContext(), "Erro no cadastro!", Toast.LENGTH_SHORT).show();

                }
            });

            finish();

        }else{
            Toast.makeText(getApplicationContext(), "Informação obrigatória não digitada", Toast.LENGTH_SHORT).show();
        }

    }

    public void buildSpinner(){


        Call<List<Department>> call = new RetrofitConfiguration().getDepartmentService().getDepartments();

        call.enqueue(new Callback<List<Department>>() {
            @Override
            public void onResponse(Call<List<Department>> call, Response<List<Department>> response) {
                List<Department> departments = response.body();



                ArrayAdapter<Department> adapter = new ArrayAdapter<>(ProfessorCreateActivity.this, android.R.layout.simple_spinner_dropdown_item, departments);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinner = findViewById(R.id.spinnerProfessorDep);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });

            }

            @Override
            public void onFailure(Call<List<Department>> call, Throwable t) {

            }
        });
    }
}