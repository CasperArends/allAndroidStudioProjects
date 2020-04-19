package com.example.rockpaperscissors

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [RockPaperScissor::class], version = 2, exportSchema = false)

abstract class HistoryRoomDatabase : RoomDatabase(){

    abstract fun historyDao(): HistoryDAO

    companion object{
        private const val DATABASE_NAME = "HISTORY_DATABASE"

    @Volatile
    private var historyRoomDatabaseInstance:
            HistoryRoomDatabase? = null


    fun getDatabase(context: Context): HistoryRoomDatabase?{
        if (historyRoomDatabaseInstance == null){
            synchronized(HistoryRoomDatabase::class.java){
                if (historyRoomDatabaseInstance == null){
                    historyRoomDatabaseInstance = Room.databaseBuilder(context.applicationContext, HistoryRoomDatabase::class.java, DATABASE_NAME).fallbackToDestructiveMigration().build()
                }
            }
        }
        return historyRoomDatabaseInstance
    }
    }
}