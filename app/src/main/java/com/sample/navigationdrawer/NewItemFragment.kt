package io.a70mm.utils.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sample.navigationdrawer.databinding.FragmentNewBinding
import io.a70mm.utils.Adapter.MyPageAdapter

class NewItemFragment: Fragment() {
    private lateinit var binding: FragmentNewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewBinding.inflate(inflater)
        return binding.root
    }
}