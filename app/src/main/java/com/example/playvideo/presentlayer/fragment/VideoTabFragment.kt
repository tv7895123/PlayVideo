package com.example.playvideo.presentlayer.fragment

import android.os.Bundle
import android.util.SparseArray
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.playvideo.presentlayer.adapter.TabFragmentAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class VideoTabFragment() : BaseTabFragment()
{
    init
    {
        TAG = VideoTabFragment::class.java.simpleName
    }

    private val mFragmentList = SparseArray<Fragment>()

    override fun onViewCreated(view:View, savedInstanceState:Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun createFragmentAdapter():FragmentStateAdapter
    {
        if(adapter != null)
            return adapter!!

        adapter = object : TabFragmentAdapter(this){
            override fun getItemCount():Int
            {
                return 5
            }

            override fun createFragment(position:Int):Fragment
            {
                if(mFragmentList.get(position) == null)
                {
                    mFragmentList[position] = VideoFragment()
                }

                return mFragmentList[position]
            }
        }

        return adapter!!
    }
}