package ui.smartpro.cleanarchgeekbrains.model.repository

interface Repository<T> {

    suspend fun getData(word: String): T
}
