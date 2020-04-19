package com.example.rockpaperscissors

import android.content.Context

class HistoryRepository (context: Context) {

    private val historyDao: HistoryDAO

    init {
        val database = HistoryRoomDatabase.getDatabase(context)
        historyDao = database!!.historyDao()
    }

    suspend fun getAllGames(): List<RockPaperScissor> {
        return historyDao.getAllGames()
    }

    suspend fun insertGame(rps: RockPaperScissor){
        historyDao.insertGame(rps)
    }

    suspend fun deleteAllGames() {
        historyDao.deleteAllGames()
    }

}