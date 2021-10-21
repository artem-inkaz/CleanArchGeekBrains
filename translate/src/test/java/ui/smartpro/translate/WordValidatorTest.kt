package ui.smartpro.translate

import org.junit.Assert.*
import org.junit.Test

class WordValidatorTest {

    @Test
    fun wordTrue() {
        assertTrue(WordValidator.isValidWord("name@email.co.uk"))
    }

    @Test
    fun wordFalse() {
        assertFalse(WordValidator.isValidWord("name"))
    }

    @Test
    fun wordEquals() {
        assertEquals("name", "mane")
    }

    @Test
    fun wordNotNull() {
        assertNotNull(WordValidator.isValidWord("name"))
    }
}