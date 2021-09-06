package com.example.recode_final_project.views.allocation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import com.example.recode_final_project.R;
import com.example.recode_final_project.model.Professor;
import com.example.recode_final_project.retrofit.RetrofitConfiguration;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class AllocationCreateActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allocation_create);
    }

    public void createAllocation(View view) {

    }

    public void buildProfessorSpinner(){
        Call<List<Professor>> call = new RetrofitConfiguration().getProfessorService().getProfessors();
    }

    public List<String> getListNameProfessors(List<Professor> professors){
        List<String> nameProfessors = new ArrayList<>();
        for (Professor professor : professors) {
            nameProfessors.add(professor.getName());
        }
        return nameProfessors;
    }
}