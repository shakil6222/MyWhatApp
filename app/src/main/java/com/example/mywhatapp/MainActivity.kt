package com.example.mywhatapp

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.PorterDuff
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.TabGravity

class MainActivity : AppCompatActivity() {

    lateinit var newUserAdd:RecyclerView
    lateinit var searchImage:ImageView
    lateinit var textTab: com.google.android.material.tabs.TabLayout
    lateinit var viewFragement: ViewPager
    lateinit var cameIcon: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        searchImage = findViewById(R.id.searchImage_imageView)
        textTab = findViewById(R.id.textTab_tabLAyout)
        viewFragement = findViewById(R.id.viewFragement_ViewPager)

        cameIcon = findViewById(R.id.cameraIcon_imageView)

        cameIcon.setOnClickListener {
            cameraIconPermission()
        }

//        call fragement function
        suportFragement()
        searchImage.setOnClickListener {
            intent = Intent(applicationContext,Search_itom_Activity::class.java)
            startActivity(intent)
            tostText("start Activity")
        }
    }


    private fun cameraIconPermission() {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.CAMERA
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
//            Toast.makeText(this, "Camera Permission Granted", Toast.LENGTH_SHORT).show()
            tostText("Camera Permission Granted")
            val intent = Intent("android.media.action.CAMERA")
            startActivity(intent)
        } else {
            ActivityCompat.requestPermissions(
                this, arrayOf(android.Manifest.permission.CAMERA),
                100
            )
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 100) {
            if (ActivityCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.CAMERA
                )
                == PackageManager.PERMISSION_GRANTED
            ) {
                val intent = Intent("android.media.action.IMAGE_CAPTURE")
                startActivity(intent)
            } else {
                val intents = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                var uri = Uri.fromParts("Package", packageName, null)
                intents.setData(uri)
                startActivity(intents)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100 && resultCode == Activity.RESULT_OK && data != null) {

            val externalImage = data.data
            cameIcon.setImageURI(externalImage)
        }
    }

//    @SuppressLint("MissingInflatedId")
//    fun searchViewDilog(){
//        val dilog = AlertDialog.Builder(this)
//        val view = LayoutInflater.from(this).inflate(
//            R.layout.search_icon_dilog,null,false)
//
//        val backSearch : ImageView = view.findViewById(R.id.backPressSearch_ImageView)
//
//        val alertDilog = dilog.create()
//        alertDilog.setView(view)
//        alertDilog.show()
//
//        backSearch.setOnClickListener {
//            onBackPressed()
//        }

//      intent = Intent(applicationContext,Search_itom_Activity::class.java)
//       startActivity(intent)
//    }

    fun suportFragement() {
//        val imglist = arrayOf(R.drawable.baseline_people_outline_24)
//        community icon ka image ka code hai

        val fragementAD = fragement_adapter(supportFragmentManager)

        fragementAD.fragementList.add(Cominuti_fragement())
        fragementAD.fragementTitle.add("Cumminuty")

        fragementAD.fragementList.add(Chats_Fragment())
        fragementAD.fragementTitle.add("Chats")

        fragementAD.fragementList.add(Updates_Fragment())
        fragementAD.fragementTitle.add("Updates")

        fragementAD.fragementList.add(Calls_Fragment())
        fragementAD.fragementTitle.add("Calls")

        viewFragement.adapter = fragementAD

        textTab.setupWithViewPager(viewFragement)

// Set icon for the first tab comminutyIcon ka function

//        textTab.getTabAt(0)?.setIcon(imglist[0])

//        textTab.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
//            override fun onTabSelected(tab: TabLayout.Tab?) {
//                val tabiconColor = ContextCompat.getColor(this@MainActivity,R.color.white)
//                tab?.icon?.setColorFilter(tabiconColor,PorterDuff.Mode.SRC)
//            }
//
//            override fun onTabUnselected(tab: TabLayout.Tab?) {
//                val tabiconColor = ContextCompat.getColor(this@MainActivity,R.color.white)
//                tab?.icon?.setColorFilter(tabiconColor,PorterDuff.Mode.SRC)
//            }
//
//            override fun onTabReselected(tab: TabLayout.Tab?) {
//                val cominutyIconColor = ContextCompat.getColor(this@MainActivity,R.color.white)
//                tab?.icon?.setColorFilter(cominutyIconColor,PorterDuff.Mode.SRC)
//            }
//
//        })

    }
    fun tostText(s:String){
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show()
    }

}