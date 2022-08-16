package com.example.myapplication
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast



class MainActivity : AppCompatActivity() {
    private lateinit var btnToast: Button
    private lateinit var detalles: Button
    private lateinit var download: Button
    private lateinit var direction : ImageView
    private lateinit var titulo : TextView
    private lateinit var textdirection : TextView
    private lateinit var hor : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnToast = findViewById(R.id.btn_mainActivity_toast)
        detalles = findViewById(R.id.button3)
        direction = findViewById(R.id.imageView4)
        download = findViewById(R.id.button2)
        titulo = findViewById(R.id.textView3)
        textdirection =findViewById(R.id.textView4)
        hor = findViewById(R.id.textView5)

        initListeners()

    }

    private fun initListeners() {
        btnToast.setOnClickListener {
            Toast.makeText(applicationContext, "Jennifer Toxcon", Toast.LENGTH_LONG).show()
        }

        detalles.setOnClickListener {

            val titulo = titulo.text.toString()
            val direction = textdirection.text.toString()
            val hora = hor.text.toString()
            val dato = datos(titulo, direction, hora)

            val intent = Intent(this, MainActivity2::class.java)

            intent.putExtra("EXTRA_DATO", dato)
            startActivity(intent)

        }

        download.setOnClickListener{
            val url = "https://play.google.com/store/apps/details?id=com.whatsapp"
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse(url)
            startActivity(intent)
        }

        direction.setOnClickListener{
            val location = "https://www.google.com/maps/place/Cafe+Mimi/@14.5975044,-90.5097156,17z/data=!4m5!3m4!1s0x8589a3c7a7944343:0x6306b4f8fa9fada1!8m2!3d14.5973227!4d-90.5085247"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(location))
            startActivity(intent)
        }
    }

}
