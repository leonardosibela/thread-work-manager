package com.sibela.threadworkmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saveButton.setOnClickListener { onSaveClicked() }
    }

    private fun onSaveClicked() {
        val sendDataScheduler: SendDataScheduler = SendDataWorkManagerScheduler()
        sendDataScheduler.schedule(this, "Some data to be sent")
    }
}