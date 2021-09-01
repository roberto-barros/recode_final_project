package com.example.recode_final_project.views.professor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.recode_final_project.R;
import com.example.recode_final_project.model.Professor;
import com.example.recode_final_project.retrofit.RetrofitConfiguration;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfessorUpdateDeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor_update_delete);

        getSupportActionBar().hide();

        EditText professorId = findViewById(R.id.edProfessorId);
        professorId.setEnabled(false);
        EditText professorName = findViewById(R.id.edProfessorName);
        EditText professorDep = findViewById(R.id.edDepProfessor);
        EditText professorCpf = findViewById(R.id.edCpfProfessor);

        Intent intent = getIntent();
        int idProfessor = intent.getIntExtra("ID_PROFESSOR", 0);

        Call<Professor> call = new RetrofitConfiguration().getProfessorService().getProfessorById(idProfessor);

        call.enqueue(new Callback<Professor>() {
            @Override
            public void onResponse(Call<Professor> call, Response<Professor> response) {
                Professor professor = response.body();
                professorId.setText(Integer.toString(professor.getId()));
                professorName.setText(professor.getName());
                professorDep.setText((professor.getDepartment().getName()));
                professorCpf.setText(professor.getCpf());
            }

            @Override
            public void onFailure(Call<Professor> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro!", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void deleteProfessor(View view) {


    }
}