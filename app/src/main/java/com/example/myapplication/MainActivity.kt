package com.example.myapplication
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    private lateinit var btnToast: Button
    private lateinit var detalles: Button
    private lateinit var download: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnToast = findViewById(R.id.btn_mainActivity_toast)
        detalles = findViewById(R.id.button3)
        download = findViewById(R.id.button2)
        initListeners()

    }

    private fun initListeners() {
        btnToast.setOnClickListener {
            Toast.makeText(applicationContext, "Jennifer Toxcon", Toast.LENGTH_LONG).show()
        }

        detalles.setOnClickListener {
            startActivity(Intent(this, MainActivity2::class.java))
        }

        download.setOnClickListener{
            val url = "https://play.google.com/store/apps/details?id=com.whatsapp"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }
    }

}
