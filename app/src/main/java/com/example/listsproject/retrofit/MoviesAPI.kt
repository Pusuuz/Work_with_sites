package com.example.listsproject.retrofit

import android.telecom.Call.Details
import com.example.listsproject.model.DetailsResponse
import com.example.listsproject.model.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MoviesAPI {


    @GET("movie/popular")
    suspend fun getMovieList(
        @Query("api_key") key:String = Common.API_KEY,
        @Query("language")ln:String = "ru"
    ): Response


    @GET("movie/{movie_id}")
    suspend fun getMovieDetails(
        @Path("movie_id") movie_id:Int,
        @Query("api_key") key:String = Common.API_KEY,
        @Query("language") ln:String = "ru"
    ):DetailsResponse

}