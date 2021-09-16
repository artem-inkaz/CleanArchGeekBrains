package ui.smartpro.cleanarchgeekbrains.common

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import ui.smartpro.cleanarchgeekbrains.common.cleanarch.Presenter
import ui.smartpro.cleanarchgeekbrains.data.ResponseItem

abstract class BaseMvpFragment<T : AppState, V : MvpView, P : MvpPresenter<T, V>> : Fragment(),
    MvpView {

    abstract val presenter: P

    abstract override fun showBikes(words: List<ResponseItem>)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        @Suppress("UNCHECKED_CAST")
        presenter.attach(this as V)
    }

    override fun onStart() {
        super.onStart()
        @Suppress("UNCHECKED_CAST")
        presenter.attach(this as V)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        @Suppress("UNCHECKED_CAST")
        presenter.detach(this as V)
    }
}