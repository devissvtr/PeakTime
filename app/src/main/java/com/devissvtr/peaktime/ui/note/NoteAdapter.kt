package com.devissvtr.peaktime.ui.note

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.devissvtr.peaktime.databinding.ListNoteBinding
import com.devissvtr.peaktime.helper.NoteCallback
import com.devissvtr.peaktime.network.database.Note
import com.devissvtr.peaktime.ui.note.NoteAdapter.NoteViewHolder

class NoteAdapter : RecyclerView.Adapter<NoteViewHolder>() {
    private val listNotes = ArrayList<Note>()
    fun setListNotes(listNote: List<Note>) {
        val diffCallback = NoteCallback(this.listNotes, listNote)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listNotes.clear()
        this.listNotes.addAll(listNote)
        diffResult.dispatchUpdatesTo(this)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ListNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(listNotes[position])
    }

    override fun getItemCount(): Int {
        return listNotes.size
    }

    inner class NoteViewHolder (private val binding: ListNoteBinding) : RecyclerView.ViewHolder(binding.root)  {
        fun bind(note: Note){
            with(binding) {
                tvName.text = note.title
                tvDescription.text = note.description
                tvDate.text = note.date
                cvNote.setOnClickListener{
                    val intent = Intent(it.context, InputNoteActivity::class.java)
                    intent.putExtra(InputNoteActivity.EXTRA_NOTE, note)
                    it.context.startActivity(intent)
                }
            }
        }
    }

}