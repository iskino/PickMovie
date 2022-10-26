package com.otus.homework.pickmovie

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MoviesListActivity : AppCompatActivity() {
    companion object {
        const val MOVIE_NAME = "MOVIE_NAME"
        const val MOVIE_DESCRIPTION = "MOVIE_DESCRIPTION"
        const val MOVIE_COMMENT = "MOVIE_COMMENT"
    }

    private var movies: MutableList<MovieDetails> = mutableListOf()
    private var currentMovieIndex : Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies_list)

        setDetailsClickListeners()
        setCommentClickListeners()
        setFavouriteClickListeners()
        setSharedClickListeners()

        moviesInit()
    }

    private fun setDetailsClickListeners() {
        findViewById<TextView>(R.id.thorDetailsView).setOnClickListener {
            launchMovieDetails(0)
        }
        findViewById<TextView>(R.id.youngmanDetailsView).setOnClickListener {
            launchMovieDetails(1)
        }
        findViewById<TextView>(R.id.minionsDetailsView).setOnClickListener {
            launchMovieDetails(2)
        }
        findViewById<TextView>(R.id.doctorStrangeDetailsView).setOnClickListener {
            launchMovieDetails(3)
        }
        findViewById<TextView>(R.id.pawsOfFuryDetailsView).setOnClickListener {
            launchMovieDetails(4)
        }
    }

    private fun launchMovieDetails(indexOfMovieList : Int) {
        currentMovieIndex = indexOfMovieList

        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra(MOVIE_NAME, movies[indexOfMovieList].name)
        intent.putExtra(MOVIE_DESCRIPTION, movies[indexOfMovieList].description)
        intent.putExtra(MOVIE_COMMENT, movies[indexOfMovieList].comment)

        launcher.launch(intent)
    }

    private fun setCommentClickListeners() {
        findViewById<TextView>(R.id.thorCommentView).setOnClickListener {
            launchMovieDetails(0)
        }
        findViewById<TextView>(R.id.youngmanCommentView).setOnClickListener {
            launchMovieDetails(1)
        }
        findViewById<TextView>(R.id.minionsCommentView).setOnClickListener {
            launchMovieDetails(2)
        }
        findViewById<TextView>(R.id.doctorStrangeCommentView).setOnClickListener {
            launchMovieDetails(3)
        }
        findViewById<TextView>(R.id.pawsOfFuryCommentView).setOnClickListener {
            launchMovieDetails(4)
        }
    }

    private fun setFavouriteClickListeners() {
        findViewById<ImageView>(R.id.thorFavourite).setOnClickListener {
            checkFavourite(0, R.id.thorFavourite)
        }
        findViewById<ImageView>(R.id.youngmanFavourite).setOnClickListener {
            checkFavourite(1, R.id.youngmanFavourite)
        }
        findViewById<ImageView>(R.id.minionsFavourite).setOnClickListener {
            checkFavourite(2, R.id.minionsFavourite)
        }
        findViewById<ImageView>(R.id.doctorStrangeFavourite).setOnClickListener {
            checkFavourite(3, R.id.doctorStrangeFavourite)
        }
        findViewById<ImageView>(R.id.pawsOfFuryFavourite).setOnClickListener {
            checkFavourite(4, R.id.pawsOfFuryFavourite)
        }
    }

    private fun checkFavourite(indexOfMovieList : Int, id : Int) {
        val favouriteStar = findViewById<ImageView>(id)

        if(movies[indexOfMovieList].isFavourite) {
            favouriteStar.setImageResource(R.drawable.not_checked_favourite_icon)
            movies[indexOfMovieList].isFavourite = false
        }
        else {
            favouriteStar.setImageResource(R.drawable.checked_favourite_icon)
            movies[indexOfMovieList].isFavourite = true
        }
    }

    private fun setSharedClickListeners() {
        findViewById<ImageView>(R.id.thorShare).setOnClickListener {
            launchMovieInvite(0)
        }
        findViewById<ImageView>(R.id.youngmanShare).setOnClickListener {
            launchMovieInvite(1)
        }
        findViewById<ImageView>(R.id.minionsShare).setOnClickListener {
            launchMovieInvite(2)
        }
        findViewById<ImageView>(R.id.doctorStrangeShare).setOnClickListener {
            launchMovieInvite(3)
        }
        findViewById<ImageView>(R.id.pawsOfFuryShare).setOnClickListener {
            launchMovieInvite(4)
        }
    }

    private fun launchMovieInvite(indexOfMovieList : Int) {
        val intent = Intent(this, ShareToFriendActivity::class.java)
        intent.putExtra(MOVIE_NAME, movies[indexOfMovieList].name)

        launcher.launch(intent)
    }

    private fun moviesInit() {
        fillDetails(0, getString(R.string.thor_movie), getString(R.string.thor_movie_details))
        fillDetails(1, getString(R.string.youngman_movie), getString(R.string.youngman_movie_details))
        fillDetails(2, getString(R.string.minions_movie), getString(R.string.minions_movie_details))
        fillDetails(3, getString(R.string.doctor_strange_movie), getString(R.string.doctor_strange_movie_details))
        fillDetails(4, getString(R.string.paws_of_fury_movie), getString(R.string.paws_of_fury_movie_details))
    }

    private fun fillDetails(index : Int, name : String, description : String?) {
        movies.add(index, MovieDetails(name, description))
    }

    private val launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result -> result ?: return@registerForActivityResult
        var comment : String = "nothing"

        if(result.resultCode == Activity.RESULT_OK) {
            result.data?.extras?.let { extras ->
                comment = extras.getString(MOVIE_COMMENT).toString()
                movies[currentMovieIndex].comment = comment
            }

            val textView : TextView? =
                when (currentMovieIndex) {
                    0 -> findViewById<TextView>(R.id.thorCommentView)
                    1 -> findViewById<TextView>(R.id.youngmanCommentView)
                    2 -> findViewById<TextView>(R.id.minionsCommentView)
                    3 -> findViewById<TextView>(R.id.doctorStrangeCommentView)
                    4 -> findViewById<TextView>(R.id.pawsOfFuryCommentView)
                    else -> null
                }

            if(comment.isEmpty()) {
                textView?.setClickable(false)
                textView?.setText("Нет комментариев")
            }
            else {
                textView?.setClickable(true)
                textView?.setText("Есть комментарий")
            }
        }
    }
}
