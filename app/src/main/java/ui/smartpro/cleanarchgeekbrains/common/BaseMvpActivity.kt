package ui.smartpro.cleanarchgeekbrains.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseMvpActivity<T : AppState, V : MvpView, P : MvpPresenter<T, V>> :
    AppCompatActivity(),
    MvpView {

    abstract val presenter: P

    protected abstract fun createPresenter(): MvpPresenter<AppState, MvpView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNCHECKED_CAST")
        presenter.attach(this as V)
    }

    override fun onStart() {
        super.onStart()
        @Suppress("UNCHECKED_CAST")
        presenter.attach(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        @Suppress("UNCHECKED_CAST")
        presenter.detach(this as V)
    }
}