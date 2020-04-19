package com.example.shoppinglistkotlin

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "productTable")
data class ProductData(

    @ColumnInfo(name = "product")
    var productName: String,

    @ColumnInfo(name = "amount")
    var productAmount: String,

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null
) : Parcelable {

}