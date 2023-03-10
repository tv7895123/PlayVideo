package com.example.playvideo.presentlayer.fragment

import android.graphics.SurfaceTexture
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Surface
import android.view.TextureView.SurfaceTextureListener
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.playvideo.databinding.FragmentVideoBinding
import java.io.IOException


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class VideoFragment : BaseFragment()
{
    private var _binding:FragmentVideoBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!


    var mMediaPlayer: MediaPlayer? = null


    init
    {
        TAG = VideoFragment::class.java.simpleName
    }


    override fun onCreateView(inflater:LayoutInflater, container:ViewGroup?, savedInstanceState:Bundle?):View?
    {
        _binding = FragmentVideoBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view:View, savedInstanceState:Bundle?)
    {
        super.onViewCreated(view, savedInstanceState)

        mMediaPlayer = MediaPlayer()
        try
        {
            mMediaPlayer?.setDataSource(requireContext(), Uri.parse("https://www.youtube.com/watch?v=cp13Cz2tHEk"))
            mMediaPlayer?.setOnPreparedListener{
                it.start()
            }

            binding.textureView.setSurfaceTextureListener(object : SurfaceTextureListener
            {
                override fun onSurfaceTextureAvailable(surfaceTexture: SurfaceTexture, i: Int, i1: Int)
                {
                    val s = Surface(surfaceTexture)
                    try
                    {
                        mMediaPlayer?.setSurface(s)
                        mMediaPlayer?.prepareAsync()
                    }
                    catch (e: IllegalArgumentException)
                    {
                        e.printStackTrace()
                    }
                    catch (e: SecurityException)
                    {
                        e.printStackTrace()
                    }
                    catch (e: IllegalStateException)
                    {
                        e.printStackTrace()
                    }
                    catch (e: IOException)
                    {
                        e.printStackTrace()
                    }
                }

                override fun onSurfaceTextureSizeChanged(surfaceTexture: SurfaceTexture, i: Int, i1: Int)
                {
                }

                override fun onSurfaceTextureDestroyed(surfaceTexture: SurfaceTexture): Boolean
                {
                    return false
                }

                override fun onSurfaceTextureUpdated(surfaceTexture: SurfaceTexture)
                {
                }
            })

        }
        catch (e: IOException)
        {
            e.printStackTrace()
        }
    }

    override fun onResume()
    {
        super.onResume()
        //mMediaPlayer?.start()
    }

    override fun onStop()
    {
        super.onStop()
        mMediaPlayer?.pause()
    }

    override fun onDestroyView()
    {
        super.onDestroyView()
        _binding = null
    }
}