package com.example.samojlov_av_homework_module_13_number_1

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.samojlov_av_homework_module_13_number_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toolbarMain: androidx.appcompat.widget.Toolbar
    private lateinit var titleTextViewMainTV: TextView
    private lateinit var firstImageMainIV: ImageView
    private lateinit var sloganMainTV: TextView
    private lateinit var startTrainingSessionBT: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
    }

    private fun init() {
        toolbarMain = binding.toolbarMain
        setSupportActionBar(toolbarMain)
        title = getString(R.string.toolbar_title)
        toolbarMain.subtitle = getString(R.string.toolbar_subtitle)
        toolbarMain.setLogo(R.drawable.logo_toolbar)

        titleTextViewMainTV = binding.titleTextViewMainTV
        firstImageMainIV = binding.firstImageMainIV
        sloganMainTV = binding.sloganMainTV
        startTrainingSessionBT = binding.startTrainingSessionBT
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("SetTextI18n", "ShowToast")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitMenuAssortment -> {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.toast_exit),
                    Toast.LENGTH_LONG
                ).show()
                finishAffinity()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}