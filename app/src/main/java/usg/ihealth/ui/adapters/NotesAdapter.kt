package usg.ihealth.ui.adapters

import android.graphics.BitmapFactory
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import usg.ihealth.R
import usg.ihealth.ui.fragments.notes.Notes

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NotesViewHolder>() {
    private var listener: OnItemClickListener? = null
    private var arrList = ArrayList<Notes>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_rv_notes, parent,false)
        )
    }

    fun setData(arrNotesList: List<Notes>) {
        arrList = arrNotesList as ArrayList<Notes>
    }

    fun setOnClickListener(listener1: OnItemClickListener) {
        listener = listener1
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
        val arrayNotes = arrList[position]
        holder.tvTitle.text = arrayNotes.title
        holder.tvDesc.text = arrayNotes.noteText
        holder.tvDateTime.text = arrayNotes.dateTime

        if (arrList[position].color != null) {
            holder.cardView.setCardBackgroundColor(Color.parseColor(arrList[position].color))
        } else {
            holder.cardView.setCardBackgroundColor(Color.parseColor(R.color.ColorLightBlack.toString()))
        }

        if (arrList[position].imgPath != null) {
            holder.imgNote.setImageBitmap(BitmapFactory.decodeFile(arrList[position].imgPath))
            holder.imgNote.visibility = View.VISIBLE
        } else {
            holder.imgNote.visibility = View.GONE
        }

        if (arrList[position].webLink != "") {
            holder.tvWebLink.text = arrList[position].webLink
            holder.tvWebLink.visibility = View.VISIBLE
        } else {
            holder.tvWebLink.visibility = View.GONE
        }

        holder.cardView.setOnClickListener {
            arrList[position].id?.let { it1 -> listener?.onClicked(it1) }
        }
    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    class NotesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvDesc: TextView = itemView.findViewById(R.id.tvDesc)
        val tvDateTime: TextView = itemView.findViewById(R.id.tvDateTime)
        val cardView: CardView = itemView.findViewById(R.id.cardView)
        val imgNote: ImageView = itemView.findViewById(R.id.imgNote)
        val tvWebLink: TextView = itemView.findViewById(R.id.tvWebLink)
    }

    interface OnItemClickListener {
        fun onClicked(noteId: Int)
    }
}