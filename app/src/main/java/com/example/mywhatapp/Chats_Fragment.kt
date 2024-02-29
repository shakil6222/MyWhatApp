package com.example.mywhatapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton


class Chats_Fragment : Fragment() {

    lateinit var addContact: FloatingActionButton

    lateinit var recycleview: RecyclerView
    lateinit var adapter: UserAdapter
    var userList = ArrayList<User_Model>()


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_chats_, container, false)
        recycleview = view.findViewById(R.id.new1UserAdd_RecycleView)
        addContact = view.findViewById(R.id.addContact_floatingActionButton)

        userList = ArrayList()
        recycleview.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)


        userList.add(User_Model("Shakil Ansari", "6206731127", "12:50", R.drawable.shakil))
        userList.add(
            User_Model(
                "Aakash Kumar",
                "5541874155",
                "10:00",
                R.drawable.issanimage_tarezaminper
            )
        )
        userList.add(User_Model("Prince Kumar", "555452875", "6:20", R.drawable.priofile))
        userList.add(User_Model("Wakil Ansaei", "9661101556", "5:20", R.drawable.wakilansari))
        userList.add(User_Model("Md Wakil Ansari", "9661101556", "11:50", R.drawable.mdwakil))
        userList.add(
            User_Model(
                "Naushad Alam",
                "256486540",
                "10:15",
                R.drawable.issanimage_tarezaminper
            )
        )
        userList.add(
            User_Model(
                "Afroj Alam",
                "256552165",
                "10:15",
                R.drawable.issanimage_tarezaminper
            )
        )
        userList.add(
            User_Model(
                "Akbar Alam",
                "256486540",
                "10:15",
                R.drawable.issanimage_tarezaminper
            )
        )
        userList.add(
            User_Model(
                "Aasif Ansari",
                "256486540",
                "10:15",
                R.drawable.issanimage_tarezaminper
            )
        )
        userList.add(
            User_Model(
                "Raushan Kumar",
                "256486540",
                "10:15",
                R.drawable.issanimage_tarezaminper
            )
        )

        recycleview.layoutManager = LinearLayoutManager(requireContext())
        adapter = UserAdapter(requireContext(), userList)
        recycleview.adapter = adapter
        return view
    }

    fun cheakContactPermission() {

    }

}