package com.example.notepad.database

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.notepad.database.Note
import com.example.notepad.database.NoteDao
import com.example.notepad.database.NotepadRoomDatabase

class NoteRepository(context: Context) {
    private val noteDao: NoteDao

    init{
        val database = NotepadRoomDatabase.getDatabase(context)
        noteDao = database!!.noteDao()
    }

    fun getNotepad(): LiveData<Note?> {
        return noteDao.getNotepad()
    }

    suspend fun updateNotepad(note: Note) {
        noteDao.updateNote(note)
    }

}