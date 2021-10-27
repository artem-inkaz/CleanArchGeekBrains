package ui.smartpro.cleanarchgeekbrains.common

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import ui.smartpro.cleanarchgeekbrains.R

abstract class BaseFragment<T : AppState, V : MvpView, P : MvpPresenter<T, V>> :
    BaseMvpFragment<T, V, P>() {

    fun replaceFragment(
        fragment: Fragment,
        @IdRes layoutId: Int = R.id.container,
        addToBackStack: Boolean = true,
        tag: String = fragment::class.java.simpleName
    ) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.replace(layoutId, fragment)
            ?.apply { if (addToBackStack) addToBackStack(tag) }
            ?.commitAllowingStateLoss()
    }

    fun addFragment(
        fragment: Fragment,
        @IdRes layoutId: Int = R.id.container,
        addToBackStack: Boolean = true,
        tag: String = fragment::class.java.simpleName
    ) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.add(layoutId, fragment)
            ?.apply { if (addToBackStack) addToBackStack(tag) }
            ?.commitAllowingStateLoss()
    }
}