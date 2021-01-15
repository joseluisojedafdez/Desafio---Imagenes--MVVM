package com.i4bchile.desafio_images_mvvm

import retrofit2.Response
import retrofit2.http.GET

interface PhotoApi {

    @GET("photos")
    suspend fun getPhotos(): Response<List<Photo>>
}