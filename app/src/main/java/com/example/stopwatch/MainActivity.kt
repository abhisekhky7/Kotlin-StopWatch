package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer

class MainActivity : AppCompatActivity() {
    private lateinit var btnStart:Button
    private lateinit var btnPause: Button
    private lateinit var btnReset:Button
    private lateinit var stopWatch:Chronometer
    var pauseAt:Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnStart = findViewById<Button>(R.id.btn_start)
        btnReset = findViewById<Button>(R.id.btn_reset)
        btnPause = findViewById<Button>(R.id.btn_pause)
        stopWatch=findViewById<Chronometer>(R.id.stopwatch)

        btnStart.setOnClickListener {
            stopWatch.base = SystemClock.elapsedRealtime()-pauseAt
            stopWatch.start()
        }
        btnPause.setOnClickListener {
            pauseAt = SystemClock.elapsedRealtime()-stopWatch.base
            stopWatch.stop()
        }
        btnReset.setOnClickListener {
            stopWatch.base = SystemClock.elapsedRealtime()
            stopWatch.stop()
        }


    }
}