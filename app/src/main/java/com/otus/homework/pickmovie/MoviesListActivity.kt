package com.otus.homework.pickmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
//import com.otus.homework.pickmovie.R

private const val TAG = "PickMovie"

class MoviesListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_list)

        Log.d(TAG, "onCreate")
    }
}