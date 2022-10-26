package com.otus.homework.pickmovie

data class MovieDetails (
    var name : String,
    var description : String? = null,
    var comment : String? = null,
    var isFavourite : Boolean = false)