package com.andromeda.belajarfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment1 = BlankFragment1()
        val fragment = supportFragmentManager.findFragmentByTag(BlankFragment1::class.java.simpleName)

        if (fragment !is BlankFragment1) {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, fragment1, BlankFragment1::class.java.simpleName)
                .commit()
        }


    }
}