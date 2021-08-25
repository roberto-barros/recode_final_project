package com.example.recode_final_project.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.recode_final_project.R;
import com.example.recode_final_project.adapter.Department_Adapter;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDepartment(View view) {

        Intent intent = new Intent(this, DepartmentActivity.class);
        startActivity(intent);
    }

    public void openProfessor(View view) {

        Intent messenger = new Intent(this, DepartmentActivity.class);
        messenger.putExtra("switchView", "");

        startActivity(messenger);
    }

    public void openCourse(View view) {

        Intent messenger = new Intent(this, DepartmentActivity.class);
        messenger.putExtra("switchView", "");

        startActivity(messenger);
    }

    public void openAllocation(View view) {

        Intent messenger = new Intent(this, DepartmentActivity.class);
        messenger.putExtra("switchView", "");

        startActivity(messenger);
    }
}