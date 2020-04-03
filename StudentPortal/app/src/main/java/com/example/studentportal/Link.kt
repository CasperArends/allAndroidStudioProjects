package com.example.studentportal

data class Link(
    var name: String
) {
    companion object{
        var LINK_TITLES = arrayOf(
            "DLO",
            "Rooster",
            "Android App Development"
        )

        var LINK_LINKS = arrayOf(
            "https://dlo.mijnhva.nl/d2l/le/content/18712/Home",
            "https://rooster.hva.nl/schedule?requireLogin=true",
            "https://www.android-development.app/"
        )
    }
}