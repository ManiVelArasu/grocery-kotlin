package io.a70mm.utils.Adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import io.a70mm.utils.view.GatagoryFragment
import io.a70mm.utils.view.NewItemFragment
import io.a70mm.utils.view.PopularFragment

class MyPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> GatagoryFragment()
            1 -> PopularFragment()
            2 -> NewItemFragment()
            else -> GatagoryFragment()
        }
    }
    override fun getCount(): Int {
        return 3;
    }
    override fun getPageTitle(position: Int): CharSequence? {
        when(position) {
            0 -> {
                return "Gatagory"
            }
            1 -> {
                return "Popular"
            }
            2 -> {
                return "NewItem"
            }
        }
        return super.getPageTitle(position)
    }

}


