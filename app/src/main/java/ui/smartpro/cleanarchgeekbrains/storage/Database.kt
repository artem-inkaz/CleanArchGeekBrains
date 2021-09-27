package ui.smartpro.cleanarchgeekbrains.storage

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(TranslationItem::class), version = 1, exportSchema = false)
abstract class Database: RoomDatabase() {

    abstract fun dao(): Dao
}