package ru.gb.gb_popular_libs.presentation.users.adapter

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ui.smartpro.cleanarchgeekbrains.data.ResponseItem

object UserDiff : DiffUtil.ItemCallback<ResponseItem>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: ResponseItem, newItem: ResponseItem): Boolean {
        return oldItem.word == newItem.word
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: ResponseItem, newItem: ResponseItem): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: ResponseItem, newItem: ResponseItem) = payload

}

