package com.onestackdev.noteappcompose.data

import com.onestackdev.noteappcompose.model.Note

class NotesDataSource {
    fun loadNotes(): List<Note> {
        return listOf(
            Note(title = "Title Test 1", description = "Description Test 1"),
            Note(title = "Title Test 2", description = "Description Test 2"),
            Note(title = "Title Test 3", description = "Description Test 3")
        )
    }
}