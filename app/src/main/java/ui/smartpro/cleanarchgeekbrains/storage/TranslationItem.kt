package ui.smartpro.cleanarchgeekbrains.storage

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TranslationItem(
        @PrimaryKey(autoGenerate = true)
        var id: Int = 0,
        var orig: String = "",
        var translated: String = "",
        val isFav: Boolean = false
)
