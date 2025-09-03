package com.hamza.madar.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hamza.madar.R
import com.hamza.madar.base.BaseFragment
import com.hamza.madar.databinding.FragmentHomeBinding


class HomeFragment : BaseFragment<FragmentHomeBinding>() {


    override val bindLayout: (LayoutInflater, ViewGroup?, Boolean) -> FragmentHomeBinding
        get() = FragmentHomeBinding::inflate

    override fun prepareView(savedInstanceState: Bundle?) {





    }


}