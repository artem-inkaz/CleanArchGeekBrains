package ui.smartpro.cleanarchgeekbrains.utils

import ui.smartpro.model.data.AppState
import ui.smartpro.model.data.PhoneticsItem
import ui.smartpro.model.data.ResponseItem

fun parseSearchResults(data: AppState): AppState {
    val newSearchResults = arrayListOf<ResponseItem>()
    when (data) {
        is AppState.Success -> {
            val searchResults = data.data
            if (!searchResults.isNullOrEmpty()) {
                for (searchResult in searchResults) {
                    parseResult(searchResult, newSearchResults)
                }
            }
        }
    }

    return AppState.Success(newSearchResults)
}

private fun parseResult(dataModel: ResponseItem, newDataModels: ArrayList<ResponseItem>) {
    if (!dataModel.word.isNullOrBlank() && !dataModel.phonetics.isNullOrEmpty()) {
        val newMeanings = arrayListOf<PhoneticsItem>()
        for (meaning in dataModel.phonetics!!) {
            if (meaning?.text != null && !meaning.audio.isNullOrBlank()) {
                newMeanings.add(PhoneticsItem(meaning.text, meaning.audio))
            }
        }
        if (newMeanings.isNotEmpty()) {
            newDataModels.add(ResponseItem(newMeanings, dataModel.word))
        }
    }
}