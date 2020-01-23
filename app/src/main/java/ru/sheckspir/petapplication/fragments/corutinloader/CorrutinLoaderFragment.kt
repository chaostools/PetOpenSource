package ru.sheckspir.petapplication.fragments.corutinloader

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.ImageLoader
import coil.api.load
import coil.decode.SvgDecoder
import coil.util.CoilLogger
import kotlinx.android.synthetic.main.fragment_image_loader.*
import ru.sheckspir.petapplication.R
import ru.sheckspir.petapplication.fragments.corutinloader.model.ImageData
import ru.sheckspir.petapplication.fragments.corutinloader.view.ImageAdapter

class CorrutinLoaderFragment : Fragment(){

    private val images = object : ArrayList<ImageData>() {
         init {
             add(ImageData("https://ruka.world/img/hand.svg"))
             add(ImageData("", R.drawable.ic_boy_face))
             add(ImageData("https://ruka.world/img/penguin.svg"))
             add(ImageData("https://ruka.world/img/trubka.png"))
             add(ImageData("https://ruka.world/img/photo-machines.jpeg"))

             add(ImageData("https://ruka.world/img/bluefrog.svg"))
             add(ImageData("https://ruka.world/img/boy_face.svg"))
             add(ImageData("https://ruka.world/img/nuclear_symbol.svg"))
             add(ImageData("https://ruka.world/img/new_tux.svg"))
         }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_image_loader, container, false)
    }

    var position = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        CoilLogger.setEnabled(true)
        CoilLogger.setLevel(Log.INFO)
        val imageLoader = ImageLoader(context!!) {
            componentRegistry {
                add(SvgDecoder(context!!))
            }
        }

        val adapter = ImageAdapter(imageLoader)
        recyclerView.adapter = adapter
        adapter.replaceImages(images)

        buttonShow.setOnClickListener {


            imageBig.visibility = View.VISIBLE
            val image = images[position%images.size]
            if (image.url.isNotEmpty()) {
                imageBig.load(image.url, imageLoader)
            } else {
                imageBig.load(image.id, imageLoader)
            }
            position++
        }
    }
}