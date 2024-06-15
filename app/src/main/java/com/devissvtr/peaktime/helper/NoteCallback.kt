package com.devissvtr.peaktime.helper

import androidx.recyclerview.widget.DiffUtil
import com.devissvtr.peaktime.network.database.Note

class NoteCallback ( private val oldNote: List<Note>, private val newNote: List<Note>) : DiffUtil.Callback(){
    override fun getOldListSize(): Int = oldNote.size

    override fun getNewListSize(): Int = newNote.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldNote[oldItemPosition].id ==newNote[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldNote = oldNote[oldItemPosition]
        val newNote = newNote[newItemPosition]
        return oldNote.title == newNote.title && oldNote.description == newNote.description
    }

}
