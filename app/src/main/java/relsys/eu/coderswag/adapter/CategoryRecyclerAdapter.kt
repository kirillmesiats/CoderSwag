package relsys.eu.coderswag.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import relsys.eu.coderswag.R
import relsys.eu.coderswag.model.Category

class CategoryRecyclerAdapter(private val context : Context, private val categories : List<Category>, val itemClick : (Category) -> Unit) : RecyclerView.Adapter<CategoryRecyclerAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.category_list_item, parent, false)
        return Holder(view, categories) { position ->
            itemClick(categories[position])
        }
    }

    override fun getItemCount(): Int {
        return categories.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindCategory(categories[position], context)
    }

    class Holder(itemView: View, categories: List<Category>, private val itemClick: (Int) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val categoryImage = itemView.findViewById<ImageView>(R.id.categoryImage)
        val categoryName = itemView.findViewById<TextView>(R.id.categoryName)

        init {
            itemView.setOnClickListener {
                itemClick(adapterPosition)
            }
        }

        fun bindCategory(category: Category, context: Context) {
            val resourceId = context.resources.getIdentifier(category.image, "drawable",
                    context.packageName)
            categoryImage.setImageResource(resourceId)
            categoryName.text = category.title
        }
    }
}