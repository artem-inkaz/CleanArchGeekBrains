package ui.smartpro.core.common

import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import ui.smartpro.model.data.AppState
import ui.smartpro.core.R

abstract class BaseFragment<T : AppState> : Fragment() {

    abstract fun renderData(Re: T)

    fun replaceFragment(
        fragment: Fragment,
        @IdRes layoutId: Int = R.id.container,
        addToBackStack: Boolean = true,
        tag: String = fragment::class.java.simpleName,
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
            tag: String = fragment::class.java.simpleName,
    ) {
        activity?.supportFragmentManager
                ?.beginTransaction()
                ?.add(layoutId, fragment)
                ?.apply { if (addToBackStack) addToBackStack(tag) }
                ?.commitAllowingStateLoss()
    }
}