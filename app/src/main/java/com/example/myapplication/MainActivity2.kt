package com.example.myapplication

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.DragAndDropPermissions
import android.view.OnReceiveContentListener
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import java.util.jar.Manifest

class MainActivity2 : AppCompatActivity() {
    private lateinit var buttoncamera : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        buttoncamera = findViewById(R.id.button4)
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

    }

    private fun hasCameraPermission()=
        ActivityCompat.checkSelfPermission(this, Manifest.permission.) == PackageManager.PERMISSION_GRANTED

    private fun checkCameraPermission(){
        if(!hasCameraPermission()) {
            checkRequestRationale(Manifest.permission.CAMERA)
        } else{
            Toast.makeText(applicationContext, "Permiso otorgado para abrir la cámara", Toast.LENGTH_LONG).show()

        }
    }
}