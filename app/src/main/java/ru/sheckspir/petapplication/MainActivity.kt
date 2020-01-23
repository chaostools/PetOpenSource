package ru.sheckspir.petapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import ru.sheckspir.petapplication.fragments.corutinloader.CorrutinLoaderFragment
import ru.sheckspir.petapplication.fragments.expandable.ExpandableRecyclerFragment
import ru.sheckspir.petapplication.fragments.flexbox.FlexboxFragment
import ru.sheckspir.petapplication.fragments.swipable.SwipableFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .replace(R.id.layoutContent, FlexboxFragment())
            .commit()
    }
}
