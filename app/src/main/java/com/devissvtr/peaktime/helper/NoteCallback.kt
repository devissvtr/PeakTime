package com.devissvtr.peaktime.helper

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.recyclerview.widget.DiffUtil

class NoteCallback ( private val oldNote: List<Note>, private val newNote: List<Note>) : DiffUtil.Callback(){
    override fun getOldListSize(): Int = oldNote.size

    override fun getNewListSize(): Int = newNote.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        TODO("Not yet implemented")
    }

}
