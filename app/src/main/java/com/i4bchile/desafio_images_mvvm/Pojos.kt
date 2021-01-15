package com.i4bchile.desafio_images_mvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.room.*

@Entity(tableName="photo")
data class Photo(@PrimaryKey val id:Int, val title:String, val url:String, val thumbnailUrl:String )

@Dao
interface PhotoDAO{

    @Insert
    suspend fun insertPhotos(lista:List<Photo>)

    @Query("SELECT * FROM photo")
    fun getPhotos(): LiveData<List<Photo>>

}

@Database(entities = [Photo::class],version=1)
abstract class PhotoDatabase:RoomDatabase(){
    abstract fun photoDao():PhotoDAO
}

class PhotoApplication: Application(){

    companion object{
        var photoDatabase:PhotoDatabase?=null

    }

    override fun onCreate(){
        super.onCreate()
        Log.d("Application", "onCreate: ")
        photoDatabase=Room.databaseBuilder(this,PhotoDatabase::class.java,"photo_db").build()
    }
}