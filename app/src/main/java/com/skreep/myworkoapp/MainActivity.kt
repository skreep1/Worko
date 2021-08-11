package com.skreep.myworkoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*
import com.skreep.myworkoapp.adapter.WorkoutAdapter
import com.skreep.myworkoapp.databinding.ActivityMainBinding
import com.skreep.myworkoapp.model.WorkoutData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var dbref: DatabaseReference
    private lateinit var userRecyclerview: RecyclerView
    private lateinit var userArrayList: ArrayList<WorkoutData>
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userRecyclerview = binding.recyclerworkoutList
        userRecyclerview.layoutManager = LinearLayoutManager(this)
        userRecyclerview.setHasFixedSize(true)

        userArrayList = arrayListOf<WorkoutData>()


        getUserData()
        infoListener()


    }

    private fun getUserData() {

        dbref = FirebaseDatabase.getInstance().getReference("Workout")

        dbref.addValueEventListener(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {

                if (snapshot.exists()) {

                    for (userSnapshot in snapshot.children) {


                        val user = userSnapshot.getValue(WorkoutData::class.java)
                        userArrayList.add(user!!)

                    }

                    userRecyclerview.adapter = WorkoutAdapter(userArrayList)


                }


            }


            override fun onCancelled(error: DatabaseError) {

            }


        })

    }

    //функция отвечает за обработчик ic_info

    private fun infoListener() {
        binding.info.setOnClickListener {
            val intent = Intent(this, InfoActivity::class.java)
            startActivity(intent)

        }

    }
}
