package com.example.listsproject.retrofit

object Common {
    const val IMG_BASE_URL = "https://image.tmdb.org/t/p/w500/"
    val BASE_URL = "https://api.themoviedb.org/3/"

    val retrofitService: MoviesAPI
        get() = RetrofitClient.getClient(BASE_URL).create(MoviesAPI::class.java)
}