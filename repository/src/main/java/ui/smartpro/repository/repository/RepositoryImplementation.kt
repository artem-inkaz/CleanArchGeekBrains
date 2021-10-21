package ui.smartpro.cleanarchgeekbrains.model.repository

import ui.smartpro.cleanarchgeekbrains.model.datasource.DataSource
import ui.smartpro.model.data.ResponseItem

class RepositoryImplementation(private val dataSource: DataSource<List<ResponseItem>>) :
        Repository<List<ResponseItem>> {

    override suspend fun getData(word: String): List<ResponseItem> {
        return dataSource.getData(word)
    }
}
