package com.example.recode_final_project.views.allocation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.recode_final_project.R;

public class AllocationActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allocation);

        getSupportActionBar().hide();

        getAll();

    }

    public void getAll(){


    }

    public void getAllocationById(View view) {
    }

    public void switchToCreateAllocation(View view) {
    }
}