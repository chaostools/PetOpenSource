package ru.sheckspir.petapplication.model

import android.os.Parcel
import android.os.Parcelable

class RockSound(val name: String, val likes: Int) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(likes)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RockSound> {
        override fun createFromParcel(parcel: Parcel): RockSound {
            return RockSound(parcel)
        }

        override fun newArray(size: Int): Array<RockSound?> {
            return arrayOfNulls(size)
        }
    }
}