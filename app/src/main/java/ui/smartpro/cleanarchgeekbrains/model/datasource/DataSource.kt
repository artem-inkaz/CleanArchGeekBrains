package ui.smartpro.cleanarchgeekbrains.model.datasource

interface DataSource<T> {

    suspend fun getData(word: String): T
}
