package com.example.flixster

import com.google.gson.annotations.SerializedName

class Movie {
    @JvmField
    @SerializedName("title")
    var movieTitle: String? = null

    @JvmField
    @SerializedName("detail")
    var movieDetail: String? = null

    @JvmField
    @SerializedName("image")
    var movieImage: String? = null
}