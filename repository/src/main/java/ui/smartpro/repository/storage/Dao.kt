package ui.smartpro.cleanarchgeekbrains.storage

import androidx.room.*
import androidx.room.Dao

@Dao
interface Dao {

    // Получить весь список слов
    @Query("SELECT * FROM TranslationItem")
    suspend fun all(): List<TranslationItem>

    // Получить конкретное слово
    @Query("SELECT * FROM TranslationItem WHERE orig LIKE :orig")
    suspend fun getDataByWord(orig: String): TranslationItem

    @Query("SELECT * FROM TranslationItem WHERE isFav = 1")
    fun getFavorite(): List<TranslationItem>

    @Query("UPDATE TranslationItem SET isFav = 1 WHERE id = :id")
    suspend fun addToFavorite(id: Int)

    @Query("UPDATE TranslationItem SET isFav = 0 WHERE id = :id")
    suspend fun removeFromFavorite(id: Int)

    // Сохранить новое слово
    // onConflict = OnConflictStrategy.IGNORE означает, что дубликаты не будут
    // сохраняться
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(entity: TranslationItem)

    // Вставить список слов
    // onConflict = OnConflictStrategy.IGNORE означает, что дубликаты не будут
    // сохраняться
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAll(entities: List<TranslationItem>)

    // Обновить слово
    @Update
    suspend fun update(entity: TranslationItem)

    // Удалить слово
    @Delete
    suspend fun delete(entity: TranslationItem)
}