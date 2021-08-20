package com.example.recode_final_project.views;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.recode_final_project.R;
import com.example.recode_final_project.model.Department;
import com.example.recode_final_project.utils.Department_Adapter;

import java.util.ArrayList;

public class InteractiveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interactive);

        ListView listDep = (ListView) findViewById(R.id.lvDep);
        ArrayAdapter adapter = new Department_Adapter(this, addDepartments());
        listDep.setAdapter(adapter);

    }


    private ArrayList<Department> addDepartments(){
        ArrayList<Department> departments = new ArrayList<Department>();

        Department department = new Department(1, "Departamento de Física");
            departments.add(department);
        department = new Department(2, "Departamento de Matemática");
        departments.add(department);
        department = new Department(3, "Departamento de Português");
        departments.add(department);
        department = new Department(4, "Departamento de Química");
        departments.add(department);

        return departments;
    }

}