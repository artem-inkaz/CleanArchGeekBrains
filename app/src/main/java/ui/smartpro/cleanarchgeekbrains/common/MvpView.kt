package ui.smartpro.cleanarchgeekbrains.common

import ui.smartpro.cleanarchgeekbrains.data.ResponseItem

interface MvpView {
    fun showBikes(words: List<ResponseItem>)
}