package com.otus.homework.pickmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

private const val TAG = "PickMovie"

class ShareToFriendActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_share_to_friend)

        val intent = getIntent()
        val name = intent.getStringExtra(MoviesListActivity.MOVIE_NAME)
        val nameTextView = findViewById<TextView>(R.id.movieName)
        nameTextView.setText(name)

        findViewById<Button>(R.id.buttonOk).setOnClickListener {
            val view = findViewById<TextView>(R.id.referenceText)
            val text = view.text.toString()
            Log.d(TAG, "Reference shared to friend: $text ($name)")
            finish()
        }
    }
}