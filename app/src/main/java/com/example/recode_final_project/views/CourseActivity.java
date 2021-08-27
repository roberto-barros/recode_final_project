package com.example.recode_final_project.views;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.recode_final_project.R;
import com.example.recode_final_project.model.Course;
import com.example.recode_final_project.retrofit.RetrofitConfiguration;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
    }


    private void getAll(Call<List<Course>> calling) {
        calling.enqueue(new Callback<List<Course>>() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {

                List <Course> courses =  response.body();
                for (Course courseMap : courses) {

                    TextView textView = findViewById(R.id.textView);

                    textView.append(courseMap.getName() + " \n");

                    Log.d(">> Courses", courseMap.getName());
                }

                Toast.makeText(getApplicationContext(),"Sucesso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Erro", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void executarRequest(View view) {

        EditText editText = findViewById(R.id.edBuscar);
        int id = Integer.parseInt(editText.getText().toString());

        Call<Course> calling = new RetrofitConfiguration().getCourseService().getCourseById(id);

        calling.enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                Course course = response.body();
                TextView textView = findViewById(R.id.textView);
                textView.setText(course.getName());

            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Erro", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void pegarTodos(View view){

        Call<List<Course>> calling = new RetrofitConfiguration().getCourseService().getAllCourses();
        getAll(calling);

    }

    private void createRequest(View view){
        EditText edTela = findViewById(R.id.edBuscar);
        String valor = edTela.getText().toString();
        TextView textView = findViewById(R.id.textView);

        Course course = new Course();
        course.setName(valor);
        Call<Course> calling = new RetrofitConfiguration().getCourseService().create(course);

        calling.enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                if ( response.isSuccessful()){

                    TextView textView = findViewById(R.id.textView);
                    textView.setText("Curso cadastrado");

                }

            }

            @Override
            public void onFailure(Call<Course> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Erro", Toast.LENGTH_LONG).show();

            }
        });

    }







}
