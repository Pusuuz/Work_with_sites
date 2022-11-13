package com.example.listsproject.retrofit

import retrofit2.create

object Common {
    const val IMG_BASE_URL = "https://image.tmdb.org/t/p/w500/"
    val BASE_URL = "https://api.themoviedb.org/3/"

    const val API_KEY="f1a672a73440012ba36d7df4dda2d84c"
    val retrofitService: MoviesAPI
        get() = RetrofitClient.getClient(BASE_URL).create(MoviesAPI::class.java)
}