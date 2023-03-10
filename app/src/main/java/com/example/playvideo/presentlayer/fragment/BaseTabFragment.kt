package com.example.playvideo.presentlayer.fragment

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.playvideo.databinding.FragmentTabBinding
import com.example.playvideo.presentlayer.adapter.TabFragmentAdapter


abstract class BaseTabFragment() : BaseFragment()
{
    private var _mBinding: FragmentTabBinding?=null
    protected val mBinding:FragmentTabBinding by lazy {
        _mBinding!!
    }

    protected var adapter: TabFragmentAdapter? = null


    override fun onCreateView(inflater:LayoutInflater, container:ViewGroup?, savedInstanceState:Bundle?):View?
    {
        if(_mBinding == null)
        {
            _mBinding = FragmentTabBinding.inflate(inflater, container, false)
        }
        return mBinding.root
    }

    override fun onViewCreated(view:View, savedInstanceState:Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        mBinding.viewPager.adapter = createFragmentAdapter()
    }

    override fun onStart()
    {
        super.onStart()

        if(mBinding.viewPager.adapter == null)
            mBinding.viewPager.adapter = createFragmentAdapter()
    }

    abstract fun createFragmentAdapter():FragmentStateAdapter

    override fun onStop()
    {
        super.onStop()
        mBinding.viewPager.adapter = null
    }

    fun changeTab(position:Int)
    {
        if(position < 0 )
            return

        if(adapter == null)
            return

        if(position >= adapter!!.itemCount)
            return

        mBinding.viewPager.setCurrentItem(position, false)
    }

}