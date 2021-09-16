package ui.smartpro.cleanarchgeekbrains.common

import androidx.annotation.CallSuper

abstract class BasePresenter<T : AppState, V : MvpView> : BaseViewModel(),
    MvpPresenter<T, V> {

    protected var view: V? = null
        private set

    @CallSuper
    override fun attach(view: V) {
        this.view = view
    }

    @CallSuper
    override fun detach(view: V) {
        this.view = null
    }
}