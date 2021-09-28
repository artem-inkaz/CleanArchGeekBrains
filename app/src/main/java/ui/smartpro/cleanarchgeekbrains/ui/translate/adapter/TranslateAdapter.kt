package ui.smartpro.cleanarchgeekbrains.ui.translate.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ui.smartpro.cleanarchgeekbrains.R
import ui.smartpro.cleanarchgeekbrains.storage.TranslationItem

class TranslateAdapter(private var items: List<TranslationItem>) :
        RecyclerView.Adapter<MyViewHolder>() {

    var onClickListener: ((TranslationItem, View) -> Unit)? = null

    fun setData(data: List<TranslationItem>) {
        items = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item, parent, false)

        return MyViewHolder(view)
    }


    override fun getItemCount() = items.size * 2

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = items[position / 2]
        holder.setItem(item)
        holder.itemView.setOnClickListener { onClickListener?.invoke(item, holder.itemView) }
    }

    override fun getItemViewType(position: Int) = position % 2

}