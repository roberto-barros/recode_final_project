
package com.example.recode_final_project.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.recode_final_project.R;
import com.example.recode_final_project.model.Allocation;


import java.util.ArrayList;

public class Allocation_Adapter extends ArrayAdapter<Allocation> {

    private Context context;
    private int layout;
    private ArrayList<Allocation> allocations;

    public void setCourses(ArrayList<Allocation> list) {
        allocations.addAll(list);
    }

    public Allocation_Adapter(@NonNull Context context, int resource, Context context1, int layout, ArrayList<Allocation> allocations) {
        super(context, resource);
        this.context = context1;
        this.layout = layout;
        this.allocations = allocations;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View itemView = LayoutInflater.from(context).inflate(layout, parent, false);

        Allocation allocation = this.allocations.get(position);

        TextView textViewId = itemView.findViewById(R.id.tvIdAllocation);
        textViewId.setText(Integer.toString(allocation.getId()));

        TextView textViewProf = itemView.findViewById(R.id.tvProfAlloc);
        textViewProf.setText(allocation.getAllocationProfessor().getName());

        TextView textViewCourse = itemView.findViewById(R.id.tvCourseAlloc);
        textViewCourse.setText(allocation.getAllocationCourse().getName());

        TextView textViewDay = itemView.findViewById(R.id.tvDayOfWeek);
        textViewDay.setText(allocation.getDayOfWeek().toString());

        TextView textViewStartHour = itemView.findViewById(R.id.tvStartHour);
        textViewStartHour.setText(allocation.getStart().toString());

        TextView textViewEndHour = itemView.findViewById(R.id.tvEndHour);
        textViewEndHour.setText(allocation.getEnd().toString());

        return itemView;
    }

    @Override
    public int getCount() {
        return allocations.size();
    }

}
