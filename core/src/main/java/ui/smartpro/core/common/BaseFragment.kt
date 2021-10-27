package ui.smartpro.core.common

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import ui.smartpro.cleanarchgeekbrains.utils.showsnackBar
import ui.smartpro.model.data.AppState
import ui.smartpro.core.R
import ui.smartpro.utils.network.OnlineLiveData

abstract class BaseFragment<T : AppState> : Fragment() {

    abstract fun renderData(Re: T)
    protected var isNetworkAvailable: Boolean = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        subscribeToNetworkChange()
    }

    private fun subscribeToNetworkChange() {
        OnlineLiveData(requireContext()).observe(
                viewLifecycleOwner,
                {
                    isNetworkAvailable = it
                    if (!isNetworkAvailable) {
                        view?.showsnackBar(R.string.dialog_message_device_is_offline.toString())
                    }
                })
    }
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