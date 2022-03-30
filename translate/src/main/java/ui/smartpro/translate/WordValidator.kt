package ui.smartpro.translate

import android.text.Editable
import android.text.TextWatcher

import java.util.regex.Pattern

class WordValidator : TextWatcher {

    internal var isValid = false

    override fun afterTextChanged(editableText: Editable) {
        isValid = isValidWord(editableText)
    }

    override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) = Unit

    override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) = Unit

    companion object {

        /**
         * Паттерн для сравнения.
         */
        private val WORD_PATTERN = Pattern.compile(
            "[^A-Za-z0-9 ]"
        )

        fun isValidWord(word: CharSequence?): Boolean {
            return word != null && WORD_PATTERN.matcher(word).matches()
        }
    }
}
