package ru.sheckspir.petapplication.fragments.swipable.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.sheckspir.petapplication.R
import ru.sheckspir.petapplication.model.RockSound

class SoundsSwipeAdapter(private val sounds : List<RockSound>) : RecyclerView.Adapter<SoundSwipeVH>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SoundSwipeVH {
        return SoundSwipeVH(LayoutInflater.from(parent.context).inflate(R.layout.item_swipable, parent, false))
    }

    override fun getItemCount(): Int {
        return sounds.size
    }

    override fun onBindViewHolder(holder: SoundSwipeVH, position: Int) {
        holder.bind(sounds[position])
    }

    private fun closeAllVH() {
    }
}