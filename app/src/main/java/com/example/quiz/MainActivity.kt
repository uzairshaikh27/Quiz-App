package com.example.quiz

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val but: Button = findViewById(R.id.hehe2)
        val nme: EditText = findViewById(R.id.name)
        val car: CardView = findViewById(R.id.hehe);



        but.setOnClickListener() {
            if(nme.text.isEmpty()) {
                Toast.makeText(this, "Enter name", Toast.LENGTH_LONG).show()
            }else{
                val intent = Intent(this, questions_main::class.java)
                intent.putExtra(constant.Usename, nme.text.toString())
                startActivity(intent);
                finish();


        }


    }
}}