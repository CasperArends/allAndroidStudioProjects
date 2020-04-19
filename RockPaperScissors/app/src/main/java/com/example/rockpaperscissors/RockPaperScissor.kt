package com.example.rockpaperscissors


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "historyTable")
data class RockPaperScissor (

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Long? = null,


    @ColumnInfo(name = "winner")
    var win: Int,

    @ColumnInfo(name = "loser")
    var lose: Int,

    @ColumnInfo(name = "drawwer")
    var draw: Int,

    @ColumnInfo(name = "playerChoice")
    var playerChoice: Int,

    @ColumnInfo(name = "computerChoice")
    var computerChoice: Int,

    @ColumnInfo(name = "date")
    var date: String




)
