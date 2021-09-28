package ru.gb.gb_popular_libs.presentation.users.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ui.smartpro.cleanarchgeekbrains.model.data.ResponseItem
import ui.smartpro.cleanarchgeekbrains.storage.TranslationItem

object UserDiff : DiffUtil.ItemCallback<TranslationItem>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: TranslationItem, newItem: TranslationItem): Boolean {
        return oldItem.orig== newItem.orig
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: TranslationItem, newItem: TranslationItem): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: TranslationItem, newItem: TranslationItem) = payload

}

