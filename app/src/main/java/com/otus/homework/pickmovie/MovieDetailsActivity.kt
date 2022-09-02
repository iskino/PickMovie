package com.otus.homework.pickmovie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MovieDetailsActivity : AppCompatActivity() {
    companion object {
        const val HAS_COMMENT = "false"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        findViewById<Button>(R.id.buttonOk).setOnClickListener {
            val comment = findViewById<TextView>(R.id.commentView)
            val hasText = if(comment.length() > 0) "true" else "false"

            setResult(RESULT_OK, Intent().putExtra(HAS_COMMENT, hasText))
            finish()
        }
    }
}