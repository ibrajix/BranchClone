package com.ibrajix.branchclone.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.ibrajix.branchclone.R
import com.ibrajix.branchclone.databinding.ActivityHomeBinding
import com.ibrajix.branchclone.utils.Utility.viewBinding

class HomeActivity : AppCompatActivity() {

    lateinit var navController: NavController

    private val binding by viewBinding(ActivityHomeBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initView()

    }

    private fun initView(){
        setUpBottomNavigation()
    }

    private fun setUpBottomNavigation(){

        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        navController = navHost.navController

        binding.bottomNavigation.setupWithNavController(navController)

        binding.bottomNavigation.setOnItemReselectedListener {
            //do something when selected twice
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            NavigationUI.onNavDestinationSelected(
                item,
                Navigation.findNavController(this, R.id.nav_host_fragment)
            )
        }


    }

}