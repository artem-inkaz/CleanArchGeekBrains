package ru.gb.gb_popular_libs.presentation.users.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.gb.gb_popular_libs.presentation.users.adapter.WordsAdapter.Delegate
import ui.smartpro.cleanarchgeekbrains.model.data.ResponseItem
import ui.smartpro.cleanarchgeekbrains.databinding.ItemBinding
import ui.smartpro.cleanarchgeekbrains.storage.TranslationItem
import ui.smartpro.cleanarchgeekbrains.utils.click

class WordViewHolder(view: View) : ViewHolder(view) {

    private val viewBinding: ItemBinding by viewBinding()

    fun bind(
        word: TranslationItem,
        delegate: Delegate?,
    ) {
        with(viewBinding) {
//            viewBinding.inputTextView.text = word.word
//            viewBinding.outputTextView.text = word.phonetics?.get(0)?.text.toString()
            viewBinding.inputTextView.text = word.orig
            viewBinding.outputTextView.text = word.translated
            root.click { delegate?.onWordPicked(word) }

        }
    }
}