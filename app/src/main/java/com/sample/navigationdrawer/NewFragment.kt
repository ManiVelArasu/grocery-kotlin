package com.sample.navigationdrawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sample.navigationdrawer.databinding.FragmentGatagoryBinding

class NewFragment : Fragment() {
    private lateinit var binding: FragmentGatagoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGatagoryBinding.inflate(inflater)
        return binding.root
    }

    override fun onPause() {

        super.onPause()


    }
}