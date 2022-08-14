package com.example.myapplication
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    private lateinit var btnToast: Button
    private lateinit var detalles: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnToast = findViewById(R.id.btn_mainActivity_toast)
        detalles = findViewById(R.id.button3)
        initListeners()

    }
    private fun initListeners() {
        btnToast.setOnClickListener {
            Toast.makeText(applicationContext, "Jennifer Toxcon", Toast.LENGTH_LONG).show()
        }

        detalles.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }
    }

}