package ui.smartpro.cleanarchgeekbrains.common.cleanarch

import ui.smartpro.cleanarchgeekbrains.common.AppState

//1
/**
 * Нижний уровень. View знает о контексте и фреймворке
 */
interface View {
    // View имеет только один метод, в который приходит некое состояние приложения
    fun renderData(appState: AppState)
}