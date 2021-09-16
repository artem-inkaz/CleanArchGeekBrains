package ru.gb.gb_popular_libs.presentation.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import ui.smartpro.cleanarchgeekbrains.R.layout.item

import ui.smartpro.cleanarchgeekbrains.data.ResponseItem

class WordsAdapter(private val delegate: Delegate?): ListAdapter<ResponseItem, WordViewHolder>(UserDiff) {

    interface Delegate {

        /**
         * Событие наступает при выборе
         * пользователя из списка.
         * @param user пользователь
         */
        fun onWordPicked(user: ResponseItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder =
        WordViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(item, parent, false)
        )

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)

}