package com.example.uf1_proyecto

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainer
import androidx.navigation.Navigation
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_content)

        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar_view)
        setSupportActionBar(toolbar)

        val layout = findViewById<DrawerLayout>(R.id.drawer_layout)
        var toggle = ActionBarDrawerToggle(this,
            layout,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        layout.addDrawerListener(toggle)
        toggle.syncState()

    }

    override fun onResume() {
        super.onResume()
        var navigate = findViewById<NavigationView>(R.id.navigation_view)
        val header = navigate.getHeaderView(0)
        header.findViewById<TextView>(R.id.actual_user).setText(PeopleViewModel.userUse!!.userName)
    }

    override fun onStop() {
        val alert = AlertDialog.Builder(this)
        alert.setTitle("¿Estas seguro que quieres cerrar la sesion?")
        alert.setPositiveButton("Si", DialogInterface.OnClickListener { dialog, which ->
            super.onStop()
        })
        alert.setNegativeButton("No", null)
        alert.show()
    }
    override fun onDestroy() {
        super.onDestroy()
        PeopleViewModel.userUse = null

    }
}