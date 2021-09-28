package ui.smartpro.cleanarchgeekbrains.storage

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TranslationItem(
        @PrimaryKey
        (autoGenerate = true)
        var id: Int = 0,
        @ColumnInfo(name = "orig")
        var orig: String = "",
        @ColumnInfo(name = "translated")
        var translated: String = "",
        @ColumnInfo(name = "isFav")
        var isFav: Boolean = false,
)
