package com.i4bchile.desafio_images_mvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class PhotoRepository {

    val photoList= MutableLiveData<List<Photo>>()

    suspend fun getPhotosfromApi(){

        val response=RetrofitClient.retrofitClient().getPhotos()

        when(response.isSuccessful){

            true -> {
                response.body()?.let {
                    photoList.value = it
                    Log.d("Repo-getphotos", "getPhotosfromApi con :${it.size} fotos ")
                }

            }

            false -> {
                Log.d("Repo-getphotos", "getPhotosfromApi: ${response.errorBody()}")

            }
        }

    }

}