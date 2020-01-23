package ru.sheckspir.petapplication.fragments.flexbox.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.sheckspir.petapplication.R
import java.util.*

class FlexboxAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        const val EMPTY_INTEREST = 1
        const val INTEREST_ITEM = 2
        const val ADD_INTEREST = 3
    }

    var dataSource : List<Int> = Collections.emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            EMPTY_INTEREST -> {
                Log.i("TAG", "EMPTY_INTEREST")
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_image_view, parent, false)
                EmptyInterestViewHolder(itemView)
            }
            INTEREST_ITEM -> {
                Log.i("TAG", "ITEM_INTEREST")
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_album_group, parent, false)
                InterestViewHolder(itemView)
            }
            ADD_INTEREST -> {
                Log.i("TAG", "ADD_INTEREST")
                val itemView = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_add_button, parent, false)
                AddInterestViewHolder(itemView)
            }
            else -> throw RuntimeException("there is no type that matches the type $viewType + make sure your using types correctly")
        }
    }

    override fun getItemViewType(position: Int): Int {
        val vType = when {
            position < dataSource.size -> INTEREST_ITEM
            dataSource.isEmpty() -> EMPTY_INTEREST
            else -> ADD_INTEREST
        }
        Log.i("TAG", "type:  $vType")
        return vType
    }

    override fun getItemCount() = dataSource.size + 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //do nothing
    }
}

class EmptyInterestViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
class InterestViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)
class AddInterestViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)