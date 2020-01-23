package ru.sheckspir.petapplication.fragments.swipable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.daimajia.swipe.SwipeLayout
import kotlinx.android.synthetic.main.fragment_swipable.*
import ru.sheckspir.petapplication.R
import ru.sheckspir.petapplication.fragments.swipable.view.SoundsSwipeAdapter
import ru.sheckspir.petapplication.model.RocksGenerator

class SwipableFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_swipable, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = SoundsSwipeAdapter(RocksGenerator().createSomeSounds())
        recyclerView.adapter = adapter

        buttonCheck.setOnClickListener {
            var closed = 0
            for (i in 0..recyclerView.childCount) {
                val view = recyclerView.getChildAt(i)
                if (view is SwipeLayout) {
                    if (view.openStatus == SwipeLayout.Status.Open)  {
                        closed++
                        view.close()
                    }
                }
            }
            Toast.makeText(context, "We close $closed items", Toast.LENGTH_SHORT).show()
        }

    }
}