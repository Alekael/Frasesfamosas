package ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.core.view.MenuProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationBarView
import dadm.alsadel.frasesfamosas.R
import dadm.alsadel.frasesfamosas.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MenuProvider {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navController = binding.fragmentContainerView!!.getFragment<NavHostFragment>().navController
        //cambiado por navigationbarview
        (binding.bottomMenu as NavigationBarView).setupWithNavController(navController)
        //nuevo
        setSupportActionBar(binding.toolbar)
        //tras dos imports
        val barconf = AppBarConfiguration.Builder(navController.graph).build()
        setupActionBarWithNavController(navController, barconf)
        // hasta aquí funciona
        addMenuProvider(this)
    }
    override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {

        menuInflater.inflate(R.menu.menu_about, menu)

    }



    override fun onMenuItemSelected(menuItem: MenuItem):Boolean{
        val binding = ActivityMainBinding.inflate(layoutInflater)
        val navController = binding.fragmentContainerView!!.getFragment<NavHostFragment>().navController
        if (menuItem.itemId==R.id.aboutFragment) {
            navController.navigate(R.id.aboutDialogFragment)
            return true
        }
        return false
    }
}