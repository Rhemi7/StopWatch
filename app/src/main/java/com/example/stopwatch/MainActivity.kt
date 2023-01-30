package com.example.stopwatch

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stopwatch.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  lateinit var binding: ActivityMainBinding
    private var isStarted = false
    private lateinit var serviceIntent : Intent
    private var time = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        serviceIntent = Intent(applicationContext, StopwatchService::class.java)
        binding.btnStart.setOnClickListener {
            startOrStop()
        }
    }

    private fun startOrStop() {
        if (isStarted) {
            stop()
        } else {
            start()
        }
    }

    private fun start() {
        serviceIntent.putExtra(StopwatchService.CURRENT_TIME, time)
        startService(serviceIntent)
        binding.btnStart.text = "Stop"
        isStarted = true;
    }

    private fun stop() {
        startService(serviceIntent)
        binding.btnStart.text = "Start"
        isStarted = false
    }

    private  fun reset() {

    }

     private val updateTime : BroadcastReceiver = object : BroadcastReceiver() {
         override fun onReceive(context: Context?, intent: Intent?) {
             TODO("Not yet implemented")
         }

     }
}