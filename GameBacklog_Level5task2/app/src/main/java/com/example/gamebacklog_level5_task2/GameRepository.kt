package com.example.gamebacklog_level5_task2

import android.content.Context
import androidx.lifecycle.LiveData

class GameRepository(context: Context) {
    private val gameDao: GameDao

    init {
        val database = GameRoomDatabase.getDatabase(context)
        gameDao = database!!.gameDao()
    }

    fun getGames(): LiveData<List<Game>> {
        return gameDao.getGames()
    }

    suspend fun insertGame(game: Game) {
        return gameDao.insertGame(game)
    }

    suspend fun deleteGame(game: Game) {
        return gameDao.deleteGame(game)
    }

    suspend fun deleteAllGames() {
        return gameDao.deleteAllGames()
    }
}