package com.i4bchile.desafio_images_mvvm

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun retrofitClient(): PhotoApi {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
            ).build()

            return retrofit.create(PhotoApi::class.java)


        }
    }
}
