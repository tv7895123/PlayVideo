package com.example.playvideo.presentlayer.fragment

import androidx.fragment.app.Fragment

abstract class BaseFragment: Fragment()
{
    protected var TAG = BaseFragment::class.java.simpleName
    override fun onStop()
    {
        super.onStop()
    }

    override fun onDestroyView()
    {
        super.onDestroyView()
    }

    override fun onDestroy()
    {
        super.onDestroy()
    }
}