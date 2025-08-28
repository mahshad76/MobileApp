package com.mahshad.mobileapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.mahshad.mobileapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var bottomNavigator: BottomNavigationView
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        bottomNavigator = mainBinding.bottomNavigator
        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.app_fragment_container) as NavHostFragment
        val navController = navHostFragment.navController
        bottomNavigator.setupWithNavController(navController)
        setContentView(mainBinding.root)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById
                (R.id.app_fragment_container)
        )
        { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(
                systemBars.left,
                systemBars.top, systemBars.right, systemBars.bottom
            )
            insets
        }
    }
}