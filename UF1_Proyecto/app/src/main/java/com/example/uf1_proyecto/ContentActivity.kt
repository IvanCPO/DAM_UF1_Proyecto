package com.example.uf1_proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class ContentActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_view)
        val navView = findViewById<NavigationView>(R.id.navigation_view)
        setSupportActionBar(toolbar)

        val layout = findViewById<DrawerLayout>(R.id.drawer_layout)
        var toggle = ActionBarDrawerToggle(this,
            layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        layout.addDrawerListener(toggle)
        toggle.syncState()

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container_fragments) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph, layout)

        setupActionBarWithNavController(navController, appBarConfiguration)

        // Configurar el NavigationView para manejar clics en elementos del menú
        navView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            layout.closeDrawers()

            when (menuItem.itemId) {
                R.id.nav_user -> {
                    // Navegar al Fragment1
                    navController.navigate(R.id.userFragment)
                    true
                }
                R.id.nav_test -> {
                    // Navegar al Fragment2
                    navController.navigate(R.id.testFragment)
                    true
                }
                R.id.nav_meet -> {
                    // Navegar al Fragment3
                    navController.navigate(R.id.meetMeFragment)
                    true
                }
                else -> false
            }
        }

    }

    override fun onResume() {
        super.onResume()
        var navigate = findViewById<NavigationView>(R.id.navigation_view)
        val header = navigate.getHeaderView(0)
        header.findViewById<TextView>(R.id.actual_user).setText(PeopleViewModel.userUse!!.userName)
        header.findViewById<ImageView>(R.id.profile_picture).setImageResource(PeopleViewModel.userUse!!.picture)
    }


    override fun onBackPressed() {
        mostrarVentanaDeAlerta()
    }

    private fun mostrarVentanaDeAlerta() {
        val builder = AlertDialog.Builder(this)
        builder.setMessage("¿Estás seguro/a de que quieres salir de la sesion?")
            .setPositiveButton("Sí") { dialog, id ->
                PeopleViewModel.saveListPeopleJson()
                PeopleViewModel.userUse=null
                finish()
            }
            .setNegativeButton("No") { dialog, id ->
                // Si el usuario hace clic en "No", cierra la ventana de alerta
                dialog.dismiss()
            }

        // Crea y muestra la ventana de alerta
        builder.create().show()
    }

}