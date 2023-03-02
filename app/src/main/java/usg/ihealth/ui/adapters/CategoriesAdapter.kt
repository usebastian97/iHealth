package usg.ihealth.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import usg.ihealth.R

class CategoriesAdapter(
    private val categoriesList: List<CategoriesSection>,
    private val context: Context
) : RecyclerView.Adapter<CategoriesAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageView: ImageView = itemView.findViewById(R.id.ivCategories)
        val textView: TextView = itemView.findViewById(R.id.tvCategories)

    }


    //-- Inflate the design for items in RecyclerView --//
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.categories_items, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemCategories = categoriesList[position]
        holder.imageView.setImageResource(itemCategories.img)
        holder.textView.text = itemCategories.title


    }

    //-- Initialize the list of items --//
    override fun getItemCount(): Int {
        return categoriesList.size
    }

    data class CategoriesSection(val title: String, val img: Int)
}