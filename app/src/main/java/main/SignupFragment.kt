package main


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.sample.navigationdrawer.R
import com.sample.navigationdrawer.databinding.FragmentSignUpBinding
import com.sample.navigationdrawer.showAlert

class SignUpFragment : Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        binding.btButton.setOnClickListener { signup() }
        binding.signup.setOnClickListener { login() }
        return binding.root
    }

    private fun login() {
        findNavController().navigate(R.id.action_signUpFragment_to_loginFragment2)
    }

    private fun signup() {
        when {
            binding.etUsername.text.toString().isEmpty() -> {
                context?.showAlert(R.string.enterthemobilenumber)
            }
            binding.etUsername.text.toString().length < 10 -> {
                context?.showAlert(R.string.enterthevalidmobilenumber)
            }
            binding.etPassword.text.toString().isEmpty() -> {
                context?.showAlert(R.string.enterthevalidpassword)
            }
            binding.etPassword.text.toString().length < 6 -> context?.showAlert(R.string.enterthepassword)
            else -> {
                findNavController().navigate(R.id.action_signUpFragment_to_loginFragment2)
            }
        }
    }


}