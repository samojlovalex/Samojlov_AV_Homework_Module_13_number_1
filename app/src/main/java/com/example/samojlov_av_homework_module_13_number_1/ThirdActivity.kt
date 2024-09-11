package com.example.samojlov_av_homework_module_13_number_1

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
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
import com.example.samojlov_av_homework_module_13_number_1.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding
    private lateinit var toolbarThird: androidx.appcompat.widget.Toolbar
    private var exercise = Exercise()
    private lateinit var titleTextViewThirdTV: TextView
    private lateinit var startButtonThirdBT: Button
    private lateinit var exerciseTV: TextView
    private lateinit var descriptionTV: TextView
    private lateinit var timeTV: TextView
    private lateinit var imageVieWThirdIV: ImageView
    private lateinit var timer: CountDownTimer
    private var exerciseIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        setContentView(R.layout.activity_third)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        init()
    }

    private fun init() {
        toolbarThird = binding.toolbarThird
        setSupportActionBar(toolbarThird)
        title = getString(R.string.toolbar_title)
        toolbarThird.subtitle = getString(R.string.toolbar_subtitle)
        toolbarThird.setLogo(R.drawable.logo_toolbar)

        titleTextViewThirdTV = binding.titleTextViewThirdTV
        startButtonThirdBT = binding.startButtonThirdBT
        exerciseTV = binding.exerciseTV
        descriptionTV = binding.descriptionTV
        imageVieWThirdIV = binding.imageVieWThirdIV
        timeTV = binding.timeTV


        exerciseIndex = intent.extras!!.getInt("position")

        startButtonThirdBT.setOnClickListener {
            startWorkout()
        }

    }

    private fun startWorkout() {
        titleTextViewThirdTV.text = getString(R.string.titleTextViewThirdTV_Text_start)
        titleTextViewThirdTV.textSize = 0f
        startButtonThirdBT.isEnabled = false
        startButtonThirdBT.text = getString(R.string.startButtonThirdBT_Text_start)
        startNextExercise()
    }

    private fun startNextExercise() {

        exerciseTV.text = exercise.exerciseNameList[exerciseIndex]
        descriptionTV.text = exercise.exerciseDescriptionList[exerciseIndex]
        imageVieWThirdIV.setImageResource(exercise.exerciseImageGifList[exerciseIndex])
        timeTV.text = formatTime(exercise.exerciseTimeList[exerciseIndex])
        timer = object : CountDownTimer(
            exercise.exerciseTimeList[exerciseIndex] * 1000L, 1000
        ) {
            override fun onTick(millisUntilFinished: Long) {
                timeTV.text = formatTime((millisUntilFinished / 1000).toInt())
            }

            override fun onFinish() {
                intentInStartActivity()
            }
        }.start()
    }

    private fun intentInStartActivity() {
        val intent = Intent(this, SecondActivity::class.java)
        startActivity(intent)
        timer.cancel()
        return finish()
    }

    @SuppressLint("DefaultLocale")
    private fun formatTime(second: Int): String {
        val minutes = second / 60
        val remainingSeconds = second % 60
        return String.format("%02d:%02d", minutes, remainingSeconds)

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_third_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    @SuppressLint("SetTextI18n", "ShowToast")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.exitMenu -> {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.toast_exit),
                    Toast.LENGTH_LONG
                ).show()
                finishAffinity()
            }
            R.id.backMenu -> {
                intentInStartActivity()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}