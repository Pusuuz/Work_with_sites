package com.example.listsproject.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.listsproject.MyAdapter
import com.example.listsproject.R
import com.example.listsproject.databinding.ActivityDetailsBinding
import com.example.listsproject.retrofit.Common
import com.squareup.picasso.Picasso
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsActivity : AppCompatActivity() {

//    var binding: ActivityDetailsBinding? = null

    private lateinit var binding: ActivityDetailsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)



        CoroutineScope(Dispatchers.IO).launch {
            try {

                val id=intent.getIntExtra("Movie",10)

                val fromServer = Common.retrofitService.getMovieDetails(movie_id = id)

                withContext(Dispatchers.Main){
                    binding.details.text = if (fromServer.adult)"adult" else "all"
                    binding.movieName.text = fromServer.original_title
                    binding.overView.text = fromServer.overview
                    binding.biling.text = "$${fromServer.budget}"
                    binding.ratingBar.rating = fromServer.vote_average.toFloat()

                    val url = Common.IMG_BASE_URL + fromServer.backdrop_path

                    Picasso.get()
                        .load(url)
                        .into(binding.poster)
                }



            }catch (e:Exception){

                Log.d("kmlkmkml", e.toString())
            }







        }


    }
}