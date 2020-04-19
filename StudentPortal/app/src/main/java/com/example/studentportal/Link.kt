package com.example.studentportal

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Link(
    var name: String,
    var url: String
) : Parcelable

{
    companion object{
        val LINK_TITLES = arrayOf(
            "DLO",
            "Rooster",
            "Android App Development"
        )

        val LINK_LINKS = arrayOf(
            "https://dlo.mijnhva.nl/d2l/le/content/18712/Home",
            "https://rooster.hva.nl/schedule?requireLogin=true",
            "https://www.android-development.app/"
        )
    }
}