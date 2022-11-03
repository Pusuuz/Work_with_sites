package com.example.listsproject.retrofit

import com.example.listsproject.model.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesAPI {


    @GET("movie/popular")
    suspend fun getMovieList(
        @Query("api_key") key:String = "f1a672a73440012ba36d7df4dda2d84c"
    ): Response
}