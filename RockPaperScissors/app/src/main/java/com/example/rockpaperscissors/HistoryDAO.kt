package com.example.rockpaperscissors

import androidx.room.*
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface HistoryDAO {
    @Query("SELECT * FROM historyTable")
    suspend fun getAllGames(): List<RockPaperScissor>

    @Insert
    suspend fun insertGame(rockpaperscissor: RockPaperScissor)

    @Query("DELETE FROM historyTable")
    suspend fun deleteAllGames()
}