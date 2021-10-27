package ui.smartpro.cleanarchgeekbrains.scheduler

import ui.smartpro.geekbrainskursovoimvp.scheduler.DefaultSchedulers
import ui.smartpro.geekbrainskursovoimvp.scheduler.Schedulers

object SchedulersFactory {

    fun create(): Schedulers = DefaultSchedulers()

}