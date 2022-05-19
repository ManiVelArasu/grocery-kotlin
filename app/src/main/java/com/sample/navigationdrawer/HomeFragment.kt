package com.sample.navigationdrawer

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.sample.navigationdrawer.databinding.FragmentHelpBinding
import com.sample.navigationdrawer.databinding.FragmentHomeBinding
import com.sample.navigationdrawer.databinding.FragmentHomesBinding
import io.a70mm.utils.Adapter.ImageAdapter
import io.a70mm.utils.Adapter.MyPageAdapter


class HomeFragment : Fragment() {
    private lateinit var handler : Handler
    private lateinit var imageList:ArrayList<Int>
    private lateinit var adapter: ImageAdapter
    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment().apply {
            arguments = Bundle().apply {}
        }
    }

    private lateinit var binding: FragmentHomesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomesBinding.inflate(inflater)
        init()
        setUpTransformer()
        binding.viewPager.adapter = activity?.let { MyPageAdapter(it.supportFragmentManager) }
        binding.Tablayout.setupWithViewPager(binding.viewPager)

        binding.sliderView.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable , 2000)
            }
        })
        return binding.root
    }
    override fun onPause() {
        super.onPause()

        handler.removeCallbacks(runnable)
    }
    override fun onResume() {
        super.onResume()

        handler.postDelayed(runnable , 2000)
    }

    private val runnable = Runnable {
        binding.sliderView.currentItem = binding.sliderView.currentItem + 1
    }


    private fun setUpTransformer() {
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }

        binding.sliderView.setPageTransformer(transformer)
    }

    private fun init() {
        handler = Handler(Looper.myLooper()!!)
        imageList = ArrayList()

        imageList.add(R.drawable.grocery)
        imageList.add(R.drawable.grocery)
        imageList.add(R.drawable.grocery)
        adapter = ImageAdapter(imageList,binding.sliderView)

        binding.sliderView.adapter = adapter
        binding.sliderView.offscreenPageLimit = 3
        binding.sliderView.clipToPadding = false
        binding.sliderView.clipChildren = false
        binding.sliderView.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER

    }
   /* fun onSupportNavigateUp() = Navigation.findNavController(
        this,
        R.id.navHostFragment
    ).navigateUp()
*/

}



/*private fun setViewpager() {
    binding.viewPager.apply {
        adapter = activity?.let {
            MyPageAdapter(
                it.supportFragmentManager,
                binding.Tablayout.tabCount
            )
        }
        addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(binding.Tablayout))
    }

}

private fun setTabLayout() {
    binding.Tablayout.apply {
        addTab((this.newTab().setText("Gatagory")))
        addTab((this.newTab().setText("Popular")))
        addTab((this.newTab().setText("Gatagory")))
        tabGravity = TabLayout.GRAVITY_FILL
        addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.position?.let {
                    binding.viewPager.currentItem = it
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }
        })
    }
}


}
*/
