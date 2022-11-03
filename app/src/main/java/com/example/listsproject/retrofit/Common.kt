package com.example.listsproject.retrofit

object Common {
    val BASE_URL = "https://api.themoviedb.org/3/"

    val retrofitService: MoviesAPI
        get() = RetrofitClient.getClient(BASE_URL).create(MoviesAPI::class.java)
}