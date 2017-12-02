package com.projects.enzoftware.countdowntimer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var isRunning = false
        var time = 0

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

        }


    }

    private fun stopCounting() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun startCounting() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
