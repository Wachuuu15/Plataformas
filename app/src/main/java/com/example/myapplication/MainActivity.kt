package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    private lateinit var btnToast: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnToast = findViewById(R.id.btn_mainActivity_toast)
        initListeners()
    }
    private fun initListeners() {
        btnToast.setOnClickListener {
            Toast.makeText(applicationContext, "Jennifer Toxcon", Toast.LENGTH_LONG).show()
        }
    }

}