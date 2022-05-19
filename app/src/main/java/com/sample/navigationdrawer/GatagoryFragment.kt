package io.a70mm.utils.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.sample.navigationdrawer.R

import com.sample.navigationdrawer.databinding.FragmentCatagoryBinding
import io.a70mm.utils.Adapter.GroceryAdapter
import io.a70mm.utils.Model.ImagaData

class GatagoryFragment: Fragment() ,GroceryAdapter. OnImageSelected
{
    private val imageClass = ArrayList<ImagaData>()
    private lateinit var groceryAdapter: GroceryAdapter
    private lateinit var binding: FragmentCatagoryBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentCatagoryBinding.inflate(inflater)

        groceryAdapter = GroceryAdapter(imageClass,this)
      /*  val gridLayoutManager = GridLayoutManager(activity, 2)
        binding.rcView.setLayoutManager(gridLayoutManager)*/
        binding.rcView.adapter = groceryAdapter
        prepareMovieData()
        return binding.root

    }
    private fun prepareMovieData() {
        var movie = ImagaData("apple")
        imageClass.add(movie)
         movie = ImagaData("apple")
        imageClass.add(movie)
        groceryAdapter.notifyDataSetChanged()
    }

    override fun onLatestVideoSelected(latestVideo: ImagaData) {
        findNavController().navigate(
            R.id.action_homeFragment2_to_newFragment)
    }


}