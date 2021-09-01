package com.example.recode_final_project.views.professor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.recode_final_project.R;
import com.example.recode_final_project.adapter.Professor_Adapter;
import com.example.recode_final_project.model.Professor;
import com.example.recode_final_project.retrofit.RetrofitConfiguration;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfessorActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_professor);

        getSupportActionBar().hide();

        listView = findViewById(R.id.lvProfessor);

        getAll();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAll();
    }

    public void getAll(){

        Call<List<Professor>> call = new RetrofitConfiguration().getProfessorService().getProfessors();

        call.enqueue(new Callback<List<Professor>>() {
            @Override
            public void onResponse(Call<List<Professor>> call, Response<List<Professor>> response) {

                List<Professor> professors = response.body();

                listView.setAdapter(new Professor_Adapter(ProfessorActivity.this, R.layout.professor_item_list, (ArrayList<Professor>) professors));

                Toast.makeText(getApplicationContext(), "Busca Realizada", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<List<Professor>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Erro!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}