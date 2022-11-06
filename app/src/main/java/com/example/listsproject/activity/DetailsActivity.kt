package com.example.listsproject.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.listsproject.MyAdapter
import com.example.listsproject.R
import com.example.listsproject.retrofit.Common
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val id=intent.getIntExtra("Movie",10)

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val fromServer = Common.retrofitService.getMovieDetails(id = id)





            }catch (e:Exception){

                Log.d("kmlkmkml", e.toString())
            }




        }


    }
}