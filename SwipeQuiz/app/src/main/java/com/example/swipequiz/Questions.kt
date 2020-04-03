package com.example.swipequiz

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.android.parcel.Parcelize

data class Questions(var name: String, var answer: Boolean) {

    companion object{
        val QUESTION = arrayOf(
            "A 'val' and 'var' are the same",
            "Mobile Application Development grants 12 ECTS."
        )

        val ANSWER = arrayOf(
            true,
            false
        )
    }


}