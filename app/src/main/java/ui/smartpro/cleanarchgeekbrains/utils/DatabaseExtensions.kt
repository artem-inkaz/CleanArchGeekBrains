package ui.smartpro.cleanarchgeekbrains.utils

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

inline fun ioBuilder(crossinline call: suspend () -> Unit) {
    CoroutineScope(Dispatchers.IO).launch {
        call()
    }
}