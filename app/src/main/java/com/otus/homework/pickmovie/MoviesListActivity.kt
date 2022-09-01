package com.otus.homework.pickmovie

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

private const val TAG = "PickMovie"

class MoviesListActivity : AppCompatActivity() {
    private var movies: MutableList<MovieDetails> = mutableListOf()
    private var hasComment : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_list)

        setDetailsClickListeners()
        setCommentClickListeners()
        setFavouriteClickListeners()

        moviesInit()

        Log.d(TAG, "onCreate")
    }

    private fun setDetailsClickListeners() {
        findViewById<TextView>(R.id.thorDetailsView).setOnClickListener {
            launcher.launch(Intent(this, MovieDetailsActivity::class.java))
        }
        findViewById<TextView>(R.id.youngmanDetailsView).setOnClickListener {
            startActivity(Intent(this, MovieDetailsActivity::class.java))
        }
        findViewById<TextView>(R.id.minionsDetailsView).setOnClickListener {
            startActivity(Intent(this, MovieDetailsActivity::class.java))
        }
        findViewById<TextView>(R.id.doctorStrangeDetailsView).setOnClickListener {
            startActivity(Intent(this, MovieDetailsActivity::class.java))
        }
        findViewById<TextView>(R.id.pawsOfFuryDetailsView).setOnClickListener {
            startActivity(Intent(this, MovieDetailsActivity::class.java))
        }
    }

    private fun setCommentClickListeners() {
        findViewById<TextView>(R.id.thorCommentView).setOnClickListener {
            launcher.launch(Intent(this, MovieDetailsActivity::class.java))
        }
    }

    private fun setFavouriteClickListeners() {
        findViewById<ImageView>(R.id.thorFavourite).setOnClickListener {
            val favouriteStar = findViewById<ImageView>(R.id.thorFavourite)

            if(movies[0].isFavourite) {
                favouriteStar.setImageResource(R.drawable.not_checked_favourite_icon)
                movies[0].isFavourite = false
            }
            else {
                favouriteStar.setImageResource(R.drawable.checked_favourite_icon)
                movies[0].isFavourite = true
            }
        }
    }

    private fun setSharedClickListeners() {
        findViewById<ImageView>(R.id.thorShare).setOnClickListener {
            startActivity(Intent(this, ShareToFriendActivity::class.java))
        }
    }

    private fun moviesInit() {
        movies.add(0,MovieDetails("thor", null, true))
        movies.add(0,MovieDetails("youngman", null, false))
        movies.add(0,MovieDetails("minions", null, false))
        movies.add(0,MovieDetails("doctor", null, false))
        movies.add(0,MovieDetails("pawsOfFury", null, false))
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result -> result ?: return@registerForActivityResult

        if(result.resultCode == Activity.RESULT_OK) {
            result.data?.extras?.let {
                extras ->
                hasComment = extras.getString(MovieDetailsActivity.HAS_COMMENT).toBoolean()
            }
        }

        val textView = findViewById<TextView>(R.id.thorCommentView)
        if(hasComment) {
            textView.setClickable(true)
            textView.setText("Есть комментарий")
        }
        else {
            textView.setClickable(false)
            textView.setText("Нет комментариев")
        }
    }
}
