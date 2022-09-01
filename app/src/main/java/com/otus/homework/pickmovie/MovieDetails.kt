package com.otus.homework.pickmovie

data class MovieDetails (
    val name : String,
    var description : String? = null,
    var isFavourite : Boolean = false)