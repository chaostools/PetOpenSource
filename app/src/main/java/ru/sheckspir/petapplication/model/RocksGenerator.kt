package ru.sheckspir.petapplication.model

import kotlin.random.Random

class RocksGenerator() {

    companion object {
        private val ALBUM_NAMES = object : ArrayList<String>() {

            init {
                add("Zero Album")
                add("I'm the Rock")
                add("There is only one")
                add("Expand everything")
                add("Work for Google")
                add("We will rock you")
            }

        }
    }

    public fun createSomeSounds() : List<RockSound> {
        val albumName = ALBUM_NAMES[Random.nextInt(0, 5)]
        val count = Random.nextInt(2, 10)
        return createSounds(albumName, count)
    }

    public fun createAlbums() : List<RockAlbum> {
        val albums = ArrayList<RockAlbum>()
        val random = Random(10)
        for (name in ALBUM_NAMES) {
            albums.add(RockAlbum(name, createSounds(name, random.nextInt(2, 10))))
        }
        return albums
    }

    private fun createSounds(albumName : String, count : Int) : List<RockSound> {
        val sounds = ArrayList<RockSound>()
        val random = Random((count + 1) * 34)
        for (i in 0..count) {
            sounds.add(RockSound("$albumName #$i ", (i * random.nextInt(1,(i + 1) * 34) + 42) / 2))
        }
        return sounds
    }


}