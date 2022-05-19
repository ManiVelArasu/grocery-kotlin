package com.sample.navigationdrawer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sample.navigationdrawer.databinding.FragmentHelpBinding
import com.sample.navigationdrawer.databinding.FragmentMyListBinding


class MyListFragment : Fragment() {
    private lateinit var binding: FragmentMyListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMyListBinding.inflate(inflater)
        return binding.root
    }



}