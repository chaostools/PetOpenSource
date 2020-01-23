package ru.sheckspir.petapplication.fragments.expandable.view

import android.view.View
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
import kotlinx.android.synthetic.main.item_sound.view.*
import ru.sheckspir.petapplication.model.RockSound

class SoundVH(view : View) : ChildViewHolder(view) {

    val soundNameTextView = view.textSoundName
    val soundLikesTextView = view.textSoundLikes

    fun bind(sound : RockSound) {
        soundNameTextView.text = sound.name
        soundLikesTextView.text = sound.likes.toString()
    }
}