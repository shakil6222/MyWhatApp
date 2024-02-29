package com.example.mywhatapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class fragement_adapter(fn:FragmentManager):FragmentStatePagerAdapter(fn,
    BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    val fragementList = ArrayList<Fragment>()
    val  fragementTitle = ArrayList<String>()

    override fun getCount(): Int {
        return  fragementList.size
    }

    override fun getItem(position: Int): Fragment {
       return fragementList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {

        return fragementTitle[position]
    }
}