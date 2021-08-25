package com.example.recode_final_project.views;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.recode_final_project.R;
import com.example.recode_final_project.model.Course;
import com.example.recode_final_project.retrofit.RetrofitConfiguration;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseActivity extends AppCompatActivity {

    private Course course=   new Course();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        //getAll(calling);
    }

    //Metodo que encapsula a requisiçao ( aula 5 1:54) nao entendi o pq de criar outro metodo "pegar todos"
    private void getAll(Call<List<Course>> calling) {
        calling.enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {

                List <Course>  course =  response.body();
                for (Course courseMap :course) {

                    Log.d(">> Courses", courseMap.getName());

                    TextView textView = findViewById(R.id.textview);
                    textView.append(courseMap.getName() + "\n ");

                }

                Toast.makeText(getApplicationContext(),"Sucesso", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Erro", Toast.LENGTH_LONG).show();

            }
        });
    }

    private void getById(View view) {

        EditText editText = findViewById(R.id.edBuscar);
        int id = Integer.parseInt(editText.getText().toString());

        Call<Course> calling = new RetrofitConfiguration().getCourseService().getCourseById(id);

        calling.enqueue(new Callback<Course>() {
            @Override
            public void onResponse(Call<Course> call, Response<Course> response) {
                Course course = response.body();
                TextView textview = findViewById(R.id.textView);
                textview.setText(course.getName());

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









}
