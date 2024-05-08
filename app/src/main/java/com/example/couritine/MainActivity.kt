package com.example.couritine

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var text1: TextView;
    lateinit var text2: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        text1 = findViewById(R.id.txtview1)
        text2 = findViewById(R.id.txtview2)
        fromMainthread();
        fromSecondThread();

    }

    private fun fromMainthread() {
        CoroutineScope(Dispatchers.Main).launch {
            text1.text = "Hello from ${Thread.currentThread().name}"
        }
    }

    private fun fromSecondThread() {
        CoroutineScope(Dispatchers.Default).launch {
            text2.text = "Hello from ${Thread.currentThread().name}"
        }
    }
}