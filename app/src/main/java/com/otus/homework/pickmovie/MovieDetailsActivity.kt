package com.otus.homework.pickmovie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MovieDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val intent = getIntent()
        val name = intent.getStringExtra(MoviesListActivity.MOVIE_NAME)
        val nameTextView = findViewById<TextView>(R.id.movieName)
        nameTextView.setText(name)

        val description = intent.getStringExtra(MoviesListActivity.MOVIE_DESCRIPTION)
        val descriptionTextView = findViewById<TextView>(R.id.movieDescription)
        descriptionTextView.setText(description)

        val comment = intent.getStringExtra(MoviesListActivity.MOVIE_COMMENT)
        val commentTextView = findViewById<TextView>(R.id.movieComment)
        commentTextView.setText(comment)

        findViewById<Button>(R.id.buttonOk).setOnClickListener {
            val comment = findViewById<TextView>(R.id.movieComment)
            val commentText = comment.text.toString()

            intent.putExtra(MoviesListActivity.MOVIE_COMMENT, commentText)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}