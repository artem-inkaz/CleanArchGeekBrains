package ui.smartpro.cleanarchgeekbrains.utils

import ui.smartpro.model.data.AppState
import ui.smartpro.model.data.PhoneticsItem
import ui.smartpro.model.data.ResponseItem
import ui.smartpro.cleanarchgeekbrains.storage.TranslationItem
import ui.smartpro.utils.UnitTestable
@UnitTestable
fun parseOnlineSearchResults(appState: AppState): AppState {
    return AppState.Success(mapResult(appState, true))
}
@UnitTestable
fun parseLocalSearchResults(appState: AppState): AppState {
    return AppState.Success(mapResult(appState, false))
}
@UnitTestable
private fun mapResult(
        appState: AppState,
        isOnline: Boolean,
): List<ResponseItem> {
    val newSearchResults = arrayListOf<ResponseItem>()
    when (appState) {
        is AppState.Success -> {
            getSuccessResultData(appState, isOnline, newSearchResults)
        }
    }
    return newSearchResults
}
@UnitTestable
private fun getSuccessResultData(
        appState: AppState.Success,
        isOnline: Boolean,
        newResponseItems: ArrayList<ResponseItem>,
) {
    val dataModels: List<ResponseItem> = appState.data as List<ResponseItem>
    if (dataModels.isNotEmpty()) {
        if (isOnline) {
            for (searchResult in dataModels) {
                parseOnlineResult(searchResult, newResponseItems)
            }
        } else {
            for (searchResult in dataModels) {
                newResponseItems.add(ResponseItem(arrayListOf(), searchResult.word))
            }
        }
    }
}
@UnitTestable
private fun parseOnlineResult(dataModel: ResponseItem, newResponseItems: ArrayList<ResponseItem>) {
    if (!dataModel.word.isNullOrBlank() && !dataModel.phonetics.isNullOrEmpty()) {
        val newPhoneticsItems = arrayListOf<PhoneticsItem>()
        for (meaning in dataModel.phonetics!!) {
            if (meaning?.text != null && !meaning.audio.isNullOrBlank()) {
                newPhoneticsItems.add(PhoneticsItem(meaning.text, meaning.audio))
            }
        }
        if (newPhoneticsItems.isNotEmpty()) {
            newResponseItems.add(ResponseItem(newPhoneticsItems, dataModel.word))
        }
    }
}
@UnitTestable
fun mapTranslationItemToSearchResult(list: List<TranslationItem>): List<ResponseItem> {
    val searchResult = ArrayList<ResponseItem>()
    if (!list.isNullOrEmpty()) {
        for (entity in list) {
            searchResult.add(ResponseItem(null, entity.orig))
        }
    }
    return searchResult
}
@UnitTestable
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
@UnitTestable
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
