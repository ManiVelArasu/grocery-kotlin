package main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.sample.navigationdrawer.R
import com.sample.navigationdrawer.databinding.FragmentLoginBinding
import com.sample.navigationdrawer.showAlert

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        binding.btButton.setOnClickListener { login() }
        binding.signup.setOnClickListener { signup() }
        return binding.root
    }

    private fun signup() {
        findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
    }

    private fun login() {
        when {
            binding.editText.text.toString().isEmpty() -> {
                context?.showAlert(R.string.entertheusername)
            }
            binding.editText.text.toString().length < 10 -> {
                context?.showAlert(R.string.enterthevalidmobilenumber)
            }
            else -> {
                findNavController().navigate(R.id.action_loginFragment_to_OTPFragment)
            }
        }
    }
}



