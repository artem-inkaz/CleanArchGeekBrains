package ui.smartpro.cleanarchgeekbrains.utils

import ui.smartpro.cleanarchgeekbrains.storage.TranslationItem
import ui.smartpro.model.data.AppState
import ui.smartpro.model.data.PhoneticsItem
import ui.smartpro.model.data.ResponseItem

fun mapTranslationItemToSearchResult(list: List<TranslationItem>): List<ResponseItem> {
    val searchResult = ArrayList<ResponseItem>()
    if (!list.isNullOrEmpty()) {
        for (entity in list) {
            searchResult.add(ResponseItem(null, entity.orig))
        }
    }
    return searchResult
}

fun convertResponseItemSuccessToEntity(appState: AppState): TranslationItem? {
    return when (appState) {
        is AppState.Success -> {
            val searchResult = appState.data
            if (searchResult.isNullOrEmpty()) {
                null
            } else {
                TranslationItem(0, searchResult[0].word.toString(), searchResult[0].phonetics!!.get(0)!!.text.toString(), false)
            }
        }
        else -> null
    }

}

fun convertPhoneticsItemToString(phonetics: List<PhoneticsItem>): String {
    var phoneticsSeparatedByComma = String()
    for ((index, meaning) in phonetics.withIndex()) {
        phoneticsSeparatedByComma += if (index + 1 != phonetics.size) {
            String.format("%s%s", meaning.text, ", ")
        } else {
            meaning.text
        }
    }
    return phoneticsSeparatedByComma
}
