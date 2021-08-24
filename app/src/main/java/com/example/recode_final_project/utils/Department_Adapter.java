package com.example.recode_final_project.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.recode_final_project.R;
import com.example.recode_final_project.model.Department;

import java.util.List;

public class Department_Adapter extends ArrayAdapter<Department> {

    private Context context;
    private List<Department> departments;

    public Department_Adapter(Context context, List<Department> departments) {
        super(context, R.layout.department_item_list, departments);
        this.context = context;
        this.departments = departments;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.department_item_list, parent,false);

        TextView depId = (TextView) rowView.findViewById(R.id.tvIdDep);
        depId.setText(departments.get(position).getId());

        TextView depName = (TextView) rowView.findViewById(R.id.tvNameDep);
        depName.setText(departments.get(position).getName());

        return rowView;
    }
}
