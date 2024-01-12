package com.onestackdev.noteappcompose.screens

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.onestackdev.noteappcompose.data.NotesDataSource
import com.onestackdev.noteappcompose.model.Note
import com.onestackdev.noteappcompose.repository.NoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NoteViewModel @Inject constructor(private val repository: NoteRepository) : ViewModel() {

    private val _noteList = MutableStateFlow<List<Note>>(emptyList())
    val noteList = _noteList.asStateFlow()

    init {
        viewModelScope.launch(IO) {
            repository.getAllNotes().distinctUntilChanged().collect { listOfNote ->
                if (listOfNote.isNullOrEmpty()) Log.d("Empty", ": Empty list")
                else _noteList.value = listOfNote
            }
        }
    }

    fun addNote(note: Note) = viewModelScope.launch { repository.addNote(note = note) }

    fun updateNote(note: Note) = viewModelScope.launch { repository.updateNote(note) }

    fun removeNote(note: Note) = viewModelScope.launch { repository.deleteNote(note) }
}