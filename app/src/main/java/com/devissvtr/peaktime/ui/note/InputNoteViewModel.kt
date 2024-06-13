package com.devissvtr.peaktime.ui.note

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.devissvtr.peaktime.network.database.Note
import com.devissvtr.peaktime.repository.NoteRepository

class InputNoteViewModel(application: Application) : ViewModel(){
    private val mRepository: NoteRepository = NoteRepository(application)

    fun getAllNotes(): LiveData<List<Note>> = mRepository.getAllNotes()
    fun insert(note: Note) {
        mRepository.insert(note)
    }
    fun update(note: Note) {
        mRepository.update(note)
    }
    fun delete(note: Note) {
        mRepository.delete(note)
    }
}