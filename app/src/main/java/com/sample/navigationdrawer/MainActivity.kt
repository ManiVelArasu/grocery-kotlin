package com.sample.navigationdrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.navigation.NavigationView
import com.sample.navigationdrawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
       /* binding.menu.setOnClickListener { v -> binding.drawerLayout.openDrawer(GravityCompat.START) }*/
        setContentView(binding.root)
        setupNavigationController()
    }
    private fun setupNavigationController() {
        setSupportActionBar(binding.toolbar)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        NavigationUI.setupActionBarWithNavController(this, navController, binding.drawerLayout)
        NavigationUI.setupWithNavController(binding.navView, navController)
        binding.navView.setNavigationItemSelectedListener(this)
    }
    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            Navigation.findNavController(this, R.id.nav_host_fragment),
           binding.drawerLayout
        )
    }
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        item.isChecked = true

        binding.drawerLayout.closeDrawers()

        val id = item.itemId

        when (id) {
            R.id.homeFragment -> navController.navigate(R.id.homeFragment)

            R.id.helpFragment -> navController.navigate(R.id.helpFragment)

            R.id.settingFragment -> navController.navigate(R.id.settingFragment)

            R.id.myListFragment -> navController.navigate(R.id.myListFragment)

            R.id.orderFragment -> navController.navigate(R.id.orderFragment)
        }
        return true

    }

    fun toggleBackVisibility(show: Boolean) {

    }
    /*  private fun setupNavigationController() {
          val navigationController = findNavController(R.id.nav_host_fragment)


          appBarConfig = AppBarConfiguration(setOf(R.id.aboutFragment, R.id.feedFragment), drawerLayout)
          setupActionBarWithNavController(navigationController, appBarConfig)
          navigationView.setupWithNavController(navigationController)
          navigationView.setNavigationItemSelectedListener { menuItem ->
              drawerLayout.closeDrawers()
              menuItem.isChecked = true
              when (menuItem.itemId) {
                  R.id.about -> navigationController.navigate(R.id.aboutFragment)
                  R.id.gitHub, R.id.reddit, R.id.hackerNews, R.id.dev -> navigationController.navigate(R.id.feedFragment)
              }

              true
          }
      }*/

}


