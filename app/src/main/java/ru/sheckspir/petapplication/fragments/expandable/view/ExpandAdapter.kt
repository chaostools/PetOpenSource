package ru.sheckspir.petapplication.fragments.expandable.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import com.thoughtbot.expandablerecyclerview.models.ExpandableListPosition
import ru.sheckspir.petapplication.R
import ru.sheckspir.petapplication.model.RockAlbum

class ExpandAdapter(albums : List<RockAlbum>) : ExpandableRecyclerViewAdapter<AlbumVH, SoundVH>(albums) {

    override fun onCreateGroupViewHolder(parent: ViewGroup, viewType: Int): AlbumVH {
        return AlbumVH(LayoutInflater.from(parent.context).inflate(R.layout.item_album_group, parent,false))
    }

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): SoundVH {
        return SoundVH(LayoutInflater.from(parent.context).inflate(R.layout.item_sound, parent, false))
    }

    override fun onBindChildViewHolder(
        holder: SoundVH,
        flatPosition: Int,
        group: ExpandableGroup<*>?,
        childIndex: Int
    ) {
        holder.bind((group as RockAlbum).items[childIndex])
    }

    override fun onBindGroupViewHolder(
        holder: AlbumVH,
        flatPosition: Int,
        group: ExpandableGroup<*>?
    ) {
        holder.bind(group as RockAlbum)
    }

    fun getGroupItemPosition(indexGroup: Int) : Int {
        var group = 0
        for (i in 0..itemCount) {
            if (getItemViewType(i) == ExpandableListPosition.GROUP) {
                group++
            }
            if (group > indexGroup) {
                return i
            }
        }
        return -1
    }

}