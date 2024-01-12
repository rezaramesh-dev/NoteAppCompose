package com.onestackdev.noteappcompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.onestackdev.noteappcompose.model.Note
import com.onestackdev.noteappcompose.util.DateConverter
import com.onestackdev.noteappcompose.util.UUIDConvertor

@Database(entities = [Note::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class, UUIDConvertor::class)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDatabaseDao
}