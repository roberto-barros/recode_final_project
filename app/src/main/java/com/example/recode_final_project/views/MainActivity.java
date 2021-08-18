package com.example.recode_final_project.views;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.recode_final_project.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openDepartment(View view) {

        Intent messenger = new Intent(this, DepartmentActivity.class);
        messenger.putExtra("switchView", "");

        startActivity(messenger);
    }

    public void openProfessor(View view) {

        Intent messenger = new Intent(this, ProfessorActivity.class);
        messenger.putExtra("switchView", "");

        startActivity(messenger);
    }

    public void openCourse(View view) {

        Intent messenger = new Intent(this, CourseActivity.class);
        messenger.putExtra("switchView", "");

        startActivity(messenger);
    }

    public void openAllocation(View view) {

        Intent messenger = new Intent(this, AllocationActivity.class);
        messenger.putExtra("switchView", "");

        startActivity(messenger);
    }
}