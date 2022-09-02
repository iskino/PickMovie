package com.otus.homework.pickmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        findViewById<Button>(R.id.buttonOk).setOnClickListener {
            finish()
        }
    }
}