package com.onestackdev.noteappcompose.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.Instant
import java.util.Date
import java.util.UUID

@Entity(tableName = "notes_tbl")
data class Note(
    @PrimaryKey
    val id: UUID = UUID.randomUUID(),
    @ColumnInfo("note_title")
    val title: String,
    @ColumnInfo("note_description")
    val description: String,
    @ColumnInfo("note_entry_date")
    val entryDate: Date = Date.from(Instant.now())
)