package com.example.recyclerviewdemo;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    ArrayList<Student> students;
    Drawable icon;

    public CustomAdapter(ArrayList<Student> students, Drawable icon){
        this.students = students;
        this.icon = icon;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView firstName;
        TextView lastName;
        ImageView myImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            firstName = itemView.findViewById(R.id.tvFirstName);
            lastName = itemView.findViewById(R.id.tvLastName);
            myImage = itemView.findViewById(R.id.myicon);
        }

        public TextView getFirstName(){
            return firstName;
        }
        public TextView getLastName(){
            return lastName;
        }
        public ImageView getIcon(){
            return myImage;
        }
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.ViewHolder holder, int position) {

    holder.getFirstName().setText(students.get(position).firstName);
    holder.getLastName().setText(students.get(position).lastName);
    holder.getIcon().setBackground(icon);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
