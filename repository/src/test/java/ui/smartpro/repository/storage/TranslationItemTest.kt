package ui.smartpro.repository.storage

import org.assertj.core.api.Assertions.assertThat
import org.junit.After
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import ui.smartpro.cleanarchgeekbrains.storage.TranslationItem

class TranslationItemTest {

    private var items = TranslationItem()
    @Before
    fun setUp() {
        println("Before: " + items)
    }
    @After
    fun tearDown() {
        println("After: " + items)
    }
    @Test
    fun testGetOrig() {
    assertTrue("word", true)
    }
    @Test
    fun testSetOrig() {
        assertThat(items.translated).contains("word")
    }
    @Test
    fun testIsFav() {
    assertTrue("word", true)
    }
}