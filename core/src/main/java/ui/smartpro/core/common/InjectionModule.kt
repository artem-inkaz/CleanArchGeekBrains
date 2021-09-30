package ui.smartpro.core.common

import org.koin.core.module.Module

interface InjectionModule {
    fun create(): Module
}