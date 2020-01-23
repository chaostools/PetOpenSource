package ru.sheckspir.petapplication.fragments.expandable

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_expandable.*
import ru.sheckspir.petapplication.R
import ru.sheckspir.petapplication.model.RockAlbum
import ru.sheckspir.petapplication.model.RockSound
import ru.sheckspir.petapplication.fragments.expandable.view.ExpandAdapter
import ru.sheckspir.petapplication.model.RocksGenerator
import kotlin.random.Random

class ExpandableRecyclerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_expandable, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager

        val adapter = ExpandAdapter(RocksGenerator().createAlbums())
        recyclerView.adapter = adapter

        buttonScroll.setOnClickListener {
            val groupIndex = editCount.text.toString().toInt()
            val realPosition = adapter.getGroupItemPosition(groupIndex)
            Log.d("TAG", "group:$groupIndex real:$realPosition")
            recyclerView.scrollToPosition(realPosition)
        }
    }


}