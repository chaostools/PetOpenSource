package ru.sheckspir.petapplication.fragments.flexbox

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexboxLayoutManager
import com.google.android.flexbox.JustifyContent
import kotlinx.android.synthetic.main.fragment_recycler.view.*
import ru.sheckspir.petapplication.R
import ru.sheckspir.petapplication.fragments.flexbox.view.FlexboxAdapter

class FlexboxFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_recycler, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = FlexboxLayoutManager(activity)
        val adapter = FlexboxAdapter()
        adapter.dataSource = Triple(1,2,3).toList()
        layoutManager.flexDirection = FlexDirection.ROW
        layoutManager.justifyContent = JustifyContent.FLEX_START
        view.recyclerView.layoutManager = layoutManager
        view.recyclerView.adapter = adapter
    }
}