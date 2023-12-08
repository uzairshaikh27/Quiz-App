package com.example.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class result_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result2)
        var name:TextView?=null
        var score:TextView?=null
        var fin:TextView?=null
        name=findViewById(R.id.user)
        score=findViewById(R.id.score)
        score.setText("Your score is "+intent.getStringExtra(constant.correct2)+" out of "+intent.getStringExtra(constant.total))
        var intent3=Intent(this,MainActivity::class.java)
        name.setText(intent3.getStringExtra(constant.Usename))
        fin=findViewById(R.id.finish)
        fin.setOnClickListener{

            startActivity(intent)


        }

    }
}