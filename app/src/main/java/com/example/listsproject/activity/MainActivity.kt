package com.example.listsproject.activity

import android.content.Intent
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

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        CoroutineScope(Dispatchers.IO).launch {
            try {
                val fromServer = Common.retrofitService.getMovieList()


                withContext(Dispatchers.Main){
                    val adapter = MyAdapter(fromServer) { goToDetails(it) }

                    val rv =findViewById<RecyclerView>(R.id.recyclerView)

                    rv.adapter=adapter


                }
            }catch (e:Exception){
                Log.d("kmlkmkml", e.toString())
            }
        }

    }

    private fun goToDetails(id:Int){
        val intent = Intent(this,DetailsActivity::class.java)
        intent.putExtra("Movie",id)
        startActivity(intent)


    }

}