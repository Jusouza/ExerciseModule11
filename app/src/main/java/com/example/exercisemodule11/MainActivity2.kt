package com.example.exercisemodule11

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.exercisemodule11.databinding.ActivityMain2Binding
import com.example.exercisemodule11.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar

class MainActivity2 : AppCompatActivity() {

    lateinit var drawer: DrawerLayout
    lateinit var navDrawer: NavigationView
    lateinit var bottomNav: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMain2Binding.inflate(layoutInflater)
        val toolbar = binding.toolbar2

        setContentView(binding.root)
        setSupportActionBar(toolbar)

        drawer = binding.root
        navDrawer = binding.navView
        bottomNav = binding.bottomNavBar

        setupBottomNavigation()
        setupDrawer()
        setupToolbar()
    }

    private fun setupBottomNavigation() {
        bottomNav.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.result -> {
                    startActivity(Intent(this, MainActivity3::class.java))
                    finish()
                    true
                }

                R.id.player -> {
                    startActivity(Intent(this, MainActivity2::class.java))
                    finish()
                    true
                }

                else -> false
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.drawer_result -> {
                startActivity(Intent(this, MainActivity3::class.java))
                finish()
                true
            }

            R.id.drawer_player -> {
                startActivity(Intent(this, MainActivity2::class.java))
                finish()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setupDrawer() {
        navDrawer.setNavigationItemSelectedListener { menuItem ->
            drawer.closeDrawers()
            when (menuItem.itemId) {
                R.id.drawer_player -> {
                    startActivity(Intent(this, MainActivity2::class.java))
                    finish()
                    true
                }

                R.id.drawer_result -> {
                    startActivity(Intent(this, MainActivity3::class.java))
                    finish()
                    true
                }

                else -> false
            }

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        drawer.openDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.drawer_menu, menu)
        return true
    }

    private fun setupToolbar() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_menu)
    }

}