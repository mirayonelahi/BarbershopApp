package com.example.barbershopapp.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barbershopapp.Entities.GetAllBarberItem
import com.example.barbershopapp.R
import com.example.barbershopapp.databinding.SingleBarberBinding

class BarbersAdapter(
    private val notesList: List<GetAllBarberItem>,
    private val listener: ListItemListener
) :
    RecyclerView.Adapter<BarbersAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        val binding =
            SingleBarberBinding.bind(itemView) // ListItemBinding refers to the list_item.xml
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.single_barber, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = notesList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notesList[position]
        with(holder.binding) {
            textViewName.text = note.name
            textViewContact.text = note.contact
            textViewEmail.text = note.email
            root.setOnClickListener {
                listener.onItemClick(note._id.`$oid`)
            }
        }
    }

    interface ListItemListener {
        //fun editNote(noteId: Int)
        fun onItemClick(noteId: String)
    }
}