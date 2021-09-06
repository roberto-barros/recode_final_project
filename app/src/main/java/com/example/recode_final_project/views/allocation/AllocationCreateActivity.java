package com.example.recode_final_project.views.allocation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.recode_final_project.R;
import com.example.recode_final_project.model.Course;
import com.example.recode_final_project.model.Department;
import com.example.recode_final_project.model.Professor;
import com.example.recode_final_project.retrofit.RetrofitConfiguration;
import com.example.recode_final_project.views.professor.ProfessorCreateActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AllocationCreateActivity extends AppCompatActivity {

    private Spinner spinner;
    Course newCourse = new Course();
    Professor newProfessor = new Professor();
    String hours[] = {"00:00+0000", "01:00+0000", "02:00+0000", "03:00+0000", "04:00+0000", "05:00+0000"
            , "06:00+0000", "07:00+0000", "08:00+0000", "09:00+0000", "10:00+0000", "11:00+0000"
            , "12:00+0000", "13:00+0000", "14:00+0000", "15:00+0000", "16:00+0000", "17:00+0000"
            , "18:00+0000", "19:00+0000", "20:00+0000", "21:00+0000", "22:00+0000", "23:00+0000", "23:59+0000"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allocation_create);

        getSupportActionBar().hide();

        buildProfessorSpinner();

        buildCourseSpinner();

        buildDayOfWeekSpinner();

        buildStartHourSpinner();

        buildEndHourSpinner();
    }

    public void createAllocation(View view) {


    }

    public void buildProfessorSpinner(){
        Call<List<Professor>> call = new RetrofitConfiguration().getProfessorService().getProfessors();

        call.enqueue(new Callback<List<Professor>>() {
            @Override
            public void onResponse(Call<List<Professor>> call, Response<List<Professor>> response) {
                List<Professor> professors = response.body();

                List<String> nameProfessors = getListNameProfessors(professors);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllocationCreateActivity.this, android.R.layout.simple_spinner_dropdown_item, nameProfessors);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinner = findViewById(R.id.spProfessor);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                        String selectedItemText = adapterView.getItemAtPosition(position).toString();

                        for (Professor professor : professors) {
                            if (selectedItemText.equals(professor.getName())){
                                newProfessor.setId(professor.getId());
                                newProfessor.setName(professor.getName());
                                newProfessor.setCpf(professor.getCpf());
                            }
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }

            @Override
            public void onFailure(Call<List<Professor>> call, Throwable t) {

            }
        });
    }

    public List<String> getListNameProfessors(List<Professor> professors){
        List<String> nameProfessors = new ArrayList<>();
        for (Professor professor : professors) {
            nameProfessors.add(professor.getName());
        }
        return nameProfessors;
    }

    public void buildCourseSpinner(){

        Call<List<Course>> call = new RetrofitConfiguration().getCourseService().getCourses();

        call.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                List<Course> courses = response.body();

                List<String> nameCourses = getListNameCourses(courses);

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(AllocationCreateActivity.this, android.R.layout.simple_spinner_dropdown_item, nameCourses);
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

                spinner = findViewById(R.id.spCourse);
                spinner.setAdapter(adapter);

                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                        String selectedItemText = adapterView.getItemAtPosition(position).toString();

                        for (Course course : courses) {
                            if(selectedItemText.equals(course.getName())){
                                newCourse.setId(course.getId());
                                newCourse.setName(course.getName());
                            }
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {

            }
        });
    }

    public List<String> getListNameCourses(List<Course> courses){
        List<String> nameCourses = new ArrayList<>();
        for (Course course : courses) {
            nameCourses.add(course.getName());
        }
        return nameCourses;
    }

    public void buildDayOfWeekSpinner(){
        String dayOfWeek[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(AllocationCreateActivity.this, android.R.layout.simple_spinner_dropdown_item, dayOfWeek);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner = findViewById(R.id.spDayOfWeek);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String dayOfWeek = adapterView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void buildStartHourSpinner(){

        ArrayAdapter<String> adapter = new ArrayAdapter<>(AllocationCreateActivity.this, android.R.layout.simple_spinner_dropdown_item, hours);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner = findViewById(R.id.spStartHour);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String startHour = adapterView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void buildEndHourSpinner(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(AllocationCreateActivity.this, android.R.layout.simple_spinner_dropdown_item, hours);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner = findViewById(R.id.spEndHour);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
                String endHour = adapterView.getItemAtPosition(position).toString();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}