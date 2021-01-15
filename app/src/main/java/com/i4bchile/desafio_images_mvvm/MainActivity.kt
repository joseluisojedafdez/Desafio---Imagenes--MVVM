package com.i4bchile.desafio_images_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.i4bchile.desafio_images_mvvm.databinding.ActivityMainBinding

/*
[X] 1. Ir a la web de jsonplaceholder https://jsonplaceholder.typicode.com, e identificar el método a
utilizar para los datos de fotos ("/photos").
[X] 2. Crear un nuevo proyecto kotlin, min sdk 21, targetSdk 29, blank activity, llamado
RestApiDesafioDos.
[x] 3. Agregar las dependecias en el archivo gradle.
[X] 4. Modificar diseño layout por defecto activity_main.xml para incluir una vista tipo RecyclerView.
[X]5. Crear el layout photos_list_item.xml con los atributos image y title.
[x]6. Crear el archivo pojo “Photo” con los atributos id, title, url y thumbnail.
[x]7. Crear la interfaz Api con el método GET de la lista de fotos del api.
[X]8. Crear la clase cliente de Retrofit.
[]9. Crear la clase PhotoAdapter con la implementación de ViewHolder y parametrización de los
datos image y title, utilizando Picasso para la carga de la imagen en la vista imageView por cada
elemento de la lista. y empleando Coil para la carga de imágenes.
[]10. Modificar la clase de Actividad agregando un nuevo método loadApiData() e instanciando la clase
Recyclerview y PhotoAdapter.

 */

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    val viewModel:PhotosVM by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val adapter=PhotoAdapter()
        binding.rvPhotos.adapter=adapter
        binding.rvPhotos.layoutManager=LinearLayoutManager(this)
        viewModel.photoList.observe(this,{list->list?.let{
            adapter.updateList(it)}
        })
        setContentView(binding.root)
    }
}