package ru.sheckspir.petapplication.fragments.expandable.view

import android.view.View
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder
import kotlinx.android.synthetic.main.item_album_group.view.*
import ru.sheckspir.petapplication.model.RockAlbum

class AlbumVH(view: View) : GroupViewHolder(view) {

    val albumName = view.textAlbumName

    fun bind(item: RockAlbum) {
        albumName.text = item.title
    }
}