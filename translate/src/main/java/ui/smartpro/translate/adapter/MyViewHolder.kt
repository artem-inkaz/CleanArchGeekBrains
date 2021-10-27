package ui.smartpro.cleanarchgeekbrains.ui.translate.adapter

import android.view.ContextMenu
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import ui.smartpro.cleanarchgeekbrains.storage.TranslationItem
import ui.smartpro.translate.R
import ui.smartpro.translate.databinding.ItemBinding

class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnCreateContextMenuListener {

    private val viewBinding: ItemBinding by viewBinding()
    var id: Int = 0
    var favoriteText = R.string.add_to_favorites

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        menu?.add(0, R.id.menu_copy, id, R.string.copy)
        menu?.add(0, R.id.menu_share, id, R.string.share)
        menu?.add(0, R.id.menu_delete, id, R.string.delete)
        menu?.add(0, R.id.menu_to_favorite, id, favoriteText)
    }

    fun setItem(item: TranslationItem) {
        id = item.id
        favoriteText = if (item.isFav) R.string.delete_from_favorites else R.string.add_to_favorites
        itemView.setOnCreateContextMenuListener(this)
        with(viewBinding) {
            inputTextView.text = item.orig
            outputTextView.text = item.translated
        }
    }
}

