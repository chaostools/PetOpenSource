package ru.sheckspir.petapplication.fragments.swipable.view

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.daimajia.swipe.SwipeLayout
import kotlinx.android.synthetic.main.item_swipable.view.*
import ru.sheckspir.petapplication.model.RockSound

class SoundSwipeVH(itemView : View) : RecyclerView.ViewHolder(itemView) {

    private val swipableLayout = itemView.layoutSwipable
    private val textSoundName = itemView.textSoundName
    private val textSoundLikes = itemView.textSoundLikes

    fun bind(sound : RockSound) {
        textSoundLikes.text = sound.likes.toString()
        textSoundName.text = sound.name
    }

    fun isOpennedOrProcess() : Boolean {
        return swipableLayout.openStatus == SwipeLayout.Status.Open || swipableLayout.openStatus == SwipeLayout.Status.Middle
    }

    fun close() {
        swipableLayout.close()
    }
}