package com.example.mywhatapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button


class Cominuti_fragement : Fragment() {
   lateinit var startNewComminuty:Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
     var view = inflater.inflate(R.layout.fragment_cominuti_fragement, container, false)

        startNewComminuty =  view.findViewById(R.id.startYourComminuty_Button)


        startNewComminuty.setOnClickListener {

//  intent one Activity to an Other Activity
            startActivity(Intent(context,new_comminuty2::class.java))
        }
        return view

    }




}