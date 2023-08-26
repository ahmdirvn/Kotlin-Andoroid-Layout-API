package com.example.tugasandroidstechoq
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.LinearLayoutManager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ExpandableListAdapter
import com.example.tugasandroidstechoq.databinding.ActivityTugas3Binding
import okhttp3.internal.notify
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Tugas3 : AppCompatActivity() {

    private lateinit var binding: ActivityTugas3Binding
    private lateinit var adapter: RVadapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTugas3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RVadapter(this@Tugas3, arrayListOf())
        binding.rvMain.adapter = adapter
        binding.rvMain.setHasFixedSize(true)

        remoteGetPhotos() // Ambil data dari API dan pasang ke adapter
    }

    fun remoteGetPhotos(){
        ApiClient.apiService.getPhotos().enqueue(object : Callback<ArrayList<userModel>>{
            override fun onResponse(
                call: Call<ArrayList<userModel>>,
                response: Response<ArrayList<userModel>>
            ) {
                if(response.isSuccessful){
                    val data = response.body()
                    setDataToAdapter(data!!)
                }
            }

            override fun onFailure(call: Call<ArrayList<userModel>>, t: Throwable) {
                Log.e("error", t.printStackTrace().toString())
            }
        })
    }

    fun setDataToAdapter(data: ArrayList<userModel>){
        adapter.setData(data)
    }
}
