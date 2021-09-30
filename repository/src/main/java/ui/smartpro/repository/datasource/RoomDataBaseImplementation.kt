package ui.smartpro.cleanarchgeekbrains.model.datasource

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import ui.smartpro.model.data.AppState
import ui.smartpro.model.data.ResponseItem
import ui.smartpro.cleanarchgeekbrains.storage.Dao
import ui.smartpro.cleanarchgeekbrains.storage.TranslationItem
import ui.smartpro.cleanarchgeekbrains.utils.convertResponseItemSuccessToEntity
import ui.smartpro.cleanarchgeekbrains.utils.mapTranslationItemToSearchResult

class RoomDataBaseImplementation(private val dao: Dao) :
        DataSourceLocal<List<ResponseItem>> {

    override suspend fun getData(word: String): List<ResponseItem> {
        return mapTranslationItemToSearchResult(dao.all())
    }

    override suspend fun saveToDB(appState: AppState): Unit =
            withContext(Dispatchers.IO) {
                convertResponseItemSuccessToEntity(appState)?.let {
                    dao.insert(it)
                }
                Log.d("SAVETODB", appState.toString())
            }

    override suspend fun getDataByWord(orig: String): TranslationItem =
            withContext(Dispatchers.IO) {
                dao.getDataByWord(orig)
            }

    override suspend fun getAllLocal(): List<TranslationItem> = withContext(Dispatchers.IO) {
        dao.all()
    }

    override suspend fun addToFavorite(id: Int) =
            withContext(Dispatchers.IO) {
                dao.addToFavorite(id)
            }

    override suspend fun removeFromFavorite(id: Int) =
            withContext(Dispatchers.IO) {
                dao.removeFromFavorite(id)
            }

    override suspend fun getFavorite(): List<TranslationItem> = withContext(Dispatchers.IO) {
        dao.getFavorite()
    }
}
