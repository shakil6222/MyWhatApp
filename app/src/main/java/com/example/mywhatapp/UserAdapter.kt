package com.example.mywhatapp

import android.content.Context
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder

class UserAdapter(
    val contex: Context,
    val user_list: ArrayList<User_Model>
) : RecyclerView.Adapter<UserAdapter.myHolder>() {

    inner class myHolder(itemView: View) : ViewHolder(itemView) {

        val name = itemView.findViewById<TextView>(R.id.textName_listItom_layout)
        val number = itemView.findViewById<TextView>(R.id.SubtitleNumber_listItom_layout)
        val date = itemView.findViewById<TextView>(R.id.time_listItom_layout)
        var itemImage = itemView.findViewById<ImageView>(R.id.image_listItom_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myHolder {
        val layout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_itom_chait, parent, false)
        return myHolder(layout)
    }

    override fun getItemCount(): Int {
        return user_list.size
    }

    override fun onBindViewHolder(holder: myHolder, position: Int) {
        val userList = user_list[position]
        holder.name.text = user_list[position].nameTitle
        holder.number.text = user_list[position].subTileNum
        holder.date.text = user_list[position].datetitle

        holder.itemImage.setBackgroundResource(userList.image)


    }
}