package Base

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.sample.navigationdrawer.MainActivity


abstract class BaseFragment : Fragment() {

    companion object {
        fun handleBackPressed(fm: FragmentManager): Boolean {
            for (frag in fm.fragments)
                if (frag != null && frag.isVisible && frag is BaseFragment)
                    if (frag.onBackPressed())
                        return true
            return false
        }
    }

    abstract fun onBackPressed(): Boolean
/*

    protected fun onBackPressed(): Boolean {
        */
/*val fm: FragmentManager = childFragmentManager
        if (handleBackPressed(fm)) {
            return true
        } else if (findNavController().currentDestination?.id != R.id.projectListFragment) {
            findNavController().popBackStack()
            return true
        }
        return false*//*

    }
*/


    protected fun toggleBackVisibility(show: Boolean = true) {
        if (activity is MainActivity)
            (activity as MainActivity).toggleBackVisibility(show)
    }

    private fun baseActivity(): BaseActivity? {
        return activity as? BaseActivity
    }

    fun showLoader() = baseActivity()?.let { it.showLoader() }

    fun hideLoader() = baseActivity()?.let { it.hideLoader() }
}