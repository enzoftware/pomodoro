package com.projects.enzoftware.countdowntimer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

var isRunning = false
var timeMil : Long = 0
var countDownTimer : CountDownTimer ?= null

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        imageViewSwitch.setOnClickListener {
            if (!isRunning){
                if (editTextCount!!.text.toString().isEmpty()){
                    Toast.makeText(this,"Tiempo vacio",Toast.LENGTH_SHORT).show()
                }else{
                    startCounting()
                }
            }else{
                stopCounting()
            }
        }

        imageViewReset.setOnClickListener {
            stopCounting()
            isRunning = false
            imageViewSwitch.setImageResource(R.drawable.play)
            textViewCount!!.text="" + timeMil / 1000
            progressBar.progress = timeMil.toInt() / 1000
            progressBar.max = timeMil.toInt() / 1000
        }


    }

    private fun stopCounting() {
        imageViewSwitch.setImageResource(R.drawable.play)
        isRunning = false
        countDownTimer!!.cancel()

    }

    private fun startCounting() {
        val txtInput = editTextCount!!.text.toString()
        val timeInput = txtInput.toLong() * 1000
        timeMil = timeInput
        progressBar.max = timeMil.toInt() / 1000
        imageViewSwitch.setImageResource(R.drawable.stop)
        isRunning = true
        countDownTimer = object  : CountDownTimer(timeMil,1000){
            override fun onFinish() {

            }

            override fun onTick(millisUntilFinished: Long) {
                textViewCount.text = Math.round(millisUntilFinished * 0.001f).toString()
                progressBar.progress = Math.round(millisUntilFinished * 0.001f)
            }
        }.start()

        countDownTimer!!.start()
    }
}
