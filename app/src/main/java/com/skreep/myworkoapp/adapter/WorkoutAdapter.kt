package com.skreep.myworkoapp.adapter

import android.content.Context

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.skreep.myworkoapp.R
import com.skreep.myworkoapp.databinding.ActivityMainBinding
import com.skreep.myworkoapp.model.WorkoutData

class WorkoutAdapter(var workoutList: ArrayList<WorkoutData>
) : RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {

        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_workout,
            parent,false)
        return WorkoutViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {

        val newList = workoutList[position]

        holder.workoutName.text = newList.workoutName
        holder.workoutDesc.text = newList.workoutDesc
        holder.workoutTime.text = newList.workoutTime

    }

    override fun getItemCount(): Int {
        return workoutList.size
    }

    class WorkoutViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val workoutName: TextView = itemView.findViewById(R.id.workout_title)
        val workoutDesc: TextView = itemView.findViewById(R.id.workout_description)
        val workoutTime: TextView = itemView.findViewById(R.id.workout_time)
    }


}