package com.example.dashboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.dashboard.fragment.BerandaFragment
import com.example.dashboard.fragment.NotificationFragment
import com.example.dashboard.fragment.ProfilFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFrag = BerandaFragment()
        val notifFrag = NotificationFragment()
        val profilFrag = ProfilFragment()

        makeCurrentFragment(homeFrag)
        val bottom_nav = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_nav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.beranda -> makeCurrentFragment(homeFrag)
                R.id.notificaton -> makeCurrentFragment(notifFrag)
                R.id.profil -> makeCurrentFragment(profilFrag)
            }
            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {

        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fram_nam, fragment)
            commit()
        }
    }

}