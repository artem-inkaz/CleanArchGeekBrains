package ui.smartpro.cleanarchgeekbrains.common

import org.koin.core.module.Module

interface InjectionModule {
    fun create(): Module
}