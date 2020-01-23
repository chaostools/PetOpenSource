package ru.sheckspir.petapplication.model

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

class RockAlbum(title: String, items: List<RockSound>) : ExpandableGroup<RockSound>(title, items) {


}