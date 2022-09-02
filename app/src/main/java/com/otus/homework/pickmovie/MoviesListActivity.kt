package com.otus.homework.pickmovie

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.ArraySet
import android.util.Log
import android.widget.ImageView
import android.widget.TextView

private const val TAG = "PickMovie"

data class MovieDetails(
    val name : String,
    var description : String? = null,
    var isFavourite : Boolean = false)

class MoviesListActivity : AppCompatActivity() {
    private lateinit var movies: ArraySet<MovieDetails>

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_list)

        findViewById<TextView>(R.id.thorDetailsView).setOnClickListener {
            startActivity(Intent(this, MovieDetailsActivity::class.java))
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

        findViewById<TextView>(R.id.thorCommentView).setOnClickListener {
            startActivity(Intent(this, MovieDetailsActivity::class.java))
            val textView = findViewById<TextView>(R.id.thorCommentView)
            textView.setTextColor(R.color.purple_700)
        }

        findViewById<ImageView>(R.id.thorFavourite).setOnClickListener {
            val favouriteStar = findViewById<ImageView>(R.id.thorFavourite)
            favouriteStar.setImageResource(R.drawable.checked_favourite_icon)
        }

        findViewById<ImageView>(R.id.thorShare).setOnClickListener {
            startActivity(Intent(this, ShareToFriendActivity::class.java))
        }

        Log.d(TAG, "onCreate")
    }

    /*override fun onStart() {
        super.onStart()
        moviesInit()
    }*/

    private fun moviesInit() {
        movies.add(MovieDetails("thor"))
        movies.add(MovieDetails("youngman"))
        movies.add(MovieDetails("minions"))
        movies.add(MovieDetails("doctor"))
        movies.add(MovieDetails("pawsOfFury"))
    }
}
