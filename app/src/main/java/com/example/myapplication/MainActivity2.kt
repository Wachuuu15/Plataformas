package com.example.myapplication

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.app.ActivityCompat
import com.google.android.material.snackbar.Snackbar


class MainActivity2 : AppCompatActivity() {
    private lateinit var buttoncamera : Button
    private lateinit var buttonCall : Button
    private lateinit var rootLayout: ConstraintLayout
    private lateinit var titulo : TextView
    private lateinit var textdirection : TextView
    private lateinit var hor : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        buttoncamera = findViewById(R.id.button4)
        buttonCall = findViewById(R.id.button5)
        titulo = findViewById(R.id.textView9)
        textdirection =findViewById(R.id.textView10)
        hor = findViewById(R.id.textView12)

        val dato : datos = intent.getSerializableExtra("EXTRA_DATO") as datos
        titulo.text = dato.titulo
        textdirection.text = dato.direccion
        hor.text = dato.hora

        setListeners()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 0 && grantResults.isNotEmpty()){
            for(i in grantResults.indices){
                if (grantResults[i] == PackageManager.PERMISSION_GRANTED)
                    Log.d("TAG","${permissions[i]} was granted")
            }
        }
    }

    private fun setListeners(){
        buttoncamera.setOnClickListener{
            checkCameraPermission()
        }
        buttonCall.setOnClickListener{
            val phoneNum = "2367 2676"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNum"))
            startActivity(intent)
        }

    }


    private fun hasCameraPermission() =
        ActivityCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED

    private fun checkCameraPermission(){
        if(!hasCameraPermission()) {
            checkRequestRationale(android.Manifest.permission.CAMERA)
        } else{
            Toast.makeText(applicationContext, "Permiso otorgado para abrir la cámara", Toast.LENGTH_LONG).show()

        }
    }

    private fun checkRequestRationale(permission: String){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (shouldShowRequestPermissionRationale(permission)){
                Snackbar.make(
                    rootLayout,
                        "El acceso es necesario para X o Y motivo",
                    Snackbar.LENGTH_INDEFINITE
                ).setAction("ok"){
                    ActivityCompat.requestPermissions(this, arrayOf(permission),0)
                }.show()
            }else{
                ActivityCompat.requestPermissions(this, arrayOf(permission),0)
            }
        }
    }


}