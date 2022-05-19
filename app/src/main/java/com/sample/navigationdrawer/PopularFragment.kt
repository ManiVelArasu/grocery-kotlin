package io.a70mm.utils.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.sample.navigationdrawer.R
import com.sample.navigationdrawer.databinding.FragmentPopularBinding
import io.a70mm.utils.Adapter.GroceryAdapter
import io.a70mm.utils.Adapter.PopularAdapter
import io.a70mm.utils.Model.ImagaData
import io.a70mm.utils.Model.PopularData

class PopularFragment : Fragment(),PopularAdapter. OnImageSelected {
    private val popularlist = ArrayList<PopularData>()
    private lateinit var popularAdapter: PopularAdapter
    private lateinit var binding: FragmentPopularBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularBinding.inflate(inflater)
        popularAdapter = PopularAdapter(popularlist,this)
        val gridLayoutManager = GridLayoutManager(activity, 2)
        binding.rcView.setLayoutManager(gridLayoutManager)
        binding.rcView.adapter = popularAdapter
        prepareMovieData()
        return binding.root
    }
    private fun prepareMovieData() {
        var popular = PopularData("apple")
        popularlist.add(popular)
        popular = PopularData("apple")
        popularlist.add(popular)
        popularAdapter.notifyDataSetChanged()
    }
    override fun onLatestVideoSelected(latestVideo: PopularData) {
        findNavController().navigate(
            R.id.action_homeFragment2_to_newFragment)

    }
}