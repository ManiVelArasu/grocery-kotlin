package main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sample.navigationdrawer.R

import com.sample.navigationdrawer.databinding.FragmentOTPBinding
import com.sample.navigationdrawer.showAlert

class OTPFragment : Fragment() {
    private lateinit var binding: FragmentOTPBinding
    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOTPBinding.inflate(inflater, container, false)
        binding.btVerify.setOnClickListener { success() }
        return binding.root
    }

    private fun success() {
       if (binding.firstPinView.text.toString().isEmpty())
       {
           context?.showAlert(R.string.enterOTP)
       }
        else if (binding.firstPinView.text.toString().length<4)
       {
           context?.showAlert(R.string.entertheOTP)
       }
        else{
           (activity as LoginActivity).main();
          /* findNavController().navigate(R.id.action_OTPFragment_to_homeActivity)*/
       }
    }



}