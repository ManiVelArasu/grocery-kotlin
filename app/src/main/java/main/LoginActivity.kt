package main

import Base.BaseActivity
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.Navigation

import com.sample.navigationdrawer.MainActivity
import com.sample.navigationdrawer.R
import com.sample.navigationdrawer.databinding.ActivityLoginBinding



class LoginActivity : BaseActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    fun toggleBackVisibility(show: Boolean) {
        TODO("Not yet implemented")
    }

    override fun onSupportNavigateUp() = Navigation.findNavController(
        this,
        R.id.navHostFragment
    ).navigateUp()

    public fun main() {
        startActivity(
            Intent(
                this,
                MainActivity::class.java
            )
        )
        finish()
    }
}