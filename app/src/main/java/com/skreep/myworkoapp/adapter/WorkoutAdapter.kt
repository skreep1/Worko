package com.skreep.myworkoapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.skreep.myworkoapp.R
import com.skreep.myworkoapp.databinding.ActivityMainBinding
import com.skreep.myworkoapp.databinding.ItemWorkoutBinding
import com.skreep.myworkoapp.model.WorkoutData

class WorkoutAdapter(
        var workoutList: ArrayList<WorkoutData>,
) : RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutViewHolder {

        return WorkoutViewHolder(ItemWorkoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))

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

    class WorkoutViewHolder(var binding: ItemWorkoutBinding) : RecyclerView.ViewHolder(binding.root) {
        val workoutName: TextView = binding.workoutTitle
        val workoutDesc: TextView = binding.workoutDescription
        val workoutTime: TextView = binding.workoutTime


    }

}

