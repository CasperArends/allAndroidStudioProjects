package com.example.studentportal

<<<<<<< HEAD
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
=======
data class Link(
    var name: String
) {
    companion object{
        var LINK_TITLES = arrayOf(
>>>>>>> f1f0d67b7d848b16dd693c9e94172f803a42a252
            "DLO",
            "Rooster",
            "Android App Development"
        )

<<<<<<< HEAD
        val LINK_LINKS = arrayOf(
=======
        var LINK_LINKS = arrayOf(
>>>>>>> f1f0d67b7d848b16dd693c9e94172f803a42a252
            "https://dlo.mijnhva.nl/d2l/le/content/18712/Home",
            "https://rooster.hva.nl/schedule?requireLogin=true",
            "https://www.android-development.app/"
        )
    }
}