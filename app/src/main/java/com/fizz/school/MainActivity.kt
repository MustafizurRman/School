package com.fizz.school

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.fizz.school.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment

        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)

        binding.bottomNavbar.setOnItemSelectedListener {
            when(it.itemId){
                R.id.subjectNav->navController.navigate(R.id.action_studentInfoFragment_to_subjectListFragment)
                else->navController.navigate(R.id.action_subjectListFragment_to_studentInfoFragment)
            }
            true
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return super.onSupportNavigateUp() || navController.navigateUp()
    }
}