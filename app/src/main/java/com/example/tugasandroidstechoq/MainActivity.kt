package com.example.tugasandroidstechoq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //mengambil nilai by id
        btn1 = findViewById(R.id.btntugas1)
        btn2 = findViewById(R.id.btntugas2)
        btn3 = findViewById(R.id.btntugas3)

        //menghubungkan button 1
        //ini namanya explisit intent
        btn1.setOnClickListener{
            //explisit intent
            val intentDestination = Intent(this@MainActivity,Tugas1::class.java)
            startActivity(intentDestination)

        }

        //menghubungkan button 2
        btn2.setOnClickListener{
            val intentDestination = Intent(this@MainActivity,Tugas2::class.java)
            startActivity(intentDestination)
        }

        //menghubungkan button 3
        btn3.setOnClickListener{
            val intentDestination = Intent( this@MainActivity,Tugas3::class.java)
            startActivity(intentDestination)
        }
    }
}