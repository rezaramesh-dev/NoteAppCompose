package com.onestackdev.noteappcompose.repository

import com.onestackdev.noteappcompose.data.NoteDatabaseDao
import com.onestackdev.noteappcompose.model.Note
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.conflate
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class NoteRepository @Inject constructor(private val noteDatabaseDao: NoteDatabaseDao) {

    suspend fun addNote(note: Note) = noteDatabaseDao.insert(note = note)

    suspend fun updateNote(note: Note) = noteDatabaseDao.update(note = note)

    suspend fun deleteNote(note: Note) = noteDatabaseDao.deleteNote(note = note)

    suspend fun deleteAllNote() = noteDatabaseDao.deleteAll()

    fun getAllNotes(): Flow<List<Note>> = noteDatabaseDao.getNote().flowOn(IO).conflate()
}