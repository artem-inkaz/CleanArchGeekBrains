package ui.smartpro.cleanarchgeekbrains.ui.translate

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.view.menu.MenuPopupHelper
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import ui.smartpro.cleanarchgeekbrains.storage.TranslationItem
import ui.smartpro.cleanarchgeekbrains.ui.translate.adapter.MyItemDecoration
import ui.smartpro.cleanarchgeekbrains.ui.translate.adapter.TranslateAdapter
import ui.smartpro.core.common.BaseFragment
import ui.smartpro.model.data.AppState
import ui.smartpro.translate.R
import ui.smartpro.translate.databinding.FragmentTranslateBinding

class TranslateFragment : BaseFragment<AppState>() {

    private val viewBinding: FragmentTranslateBinding by viewBinding()
    private val vm by viewModel<TranslateViewModel>()
    private var items = listOf<TranslationItem>()
    private val translateAdapter = TranslateAdapter(items)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?,
    ): View? {
        return inflater.inflate(R.layout.fragment_translate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val manager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        initRvComponents()
        viewBinding.recyclerView.apply {
            layoutManager = manager
            adapter = translateAdapter
            addItemDecoration(MyItemDecoration())
        }
        val originalText = viewBinding.etText.text
        viewBinding.ivSend.setOnClickListener {
            if (originalText.toString().trim().isNotEmpty()) {
                Toast.makeText(context, originalText, Toast.LENGTH_SHORT)
                        .show()
                vm.getData(originalText.toString().trim(), true)

            } else {
                Toast.makeText(context, getString(R.string.error_empty_field), Toast.LENGTH_SHORT)
                        .show()
            }
        }

        setObservers()
        observeLocalData()
    }

    override fun onStart() {
        super.onStart()
        vm.getAllLocal()
    }

    override fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                val data = appState.data
                if (data == null || data.isEmpty()) {
                    showErrorScreen(getString(R.string.error_word))
                } else {

                    Toast.makeText(context, getString(R.string.date_success), Toast.LENGTH_LONG).show()
                }
            }
            is AppState.Loading -> {
                showViewLoading()
            }
            is AppState.Error -> {
                showErrorScreen(appState.error.message + getString(R.string.error_word))
            }
        }
    }

    private fun setObservers() {
        vm.subscribe().observe(viewLifecycleOwner, {
            renderData(it)
        })
    }

    private fun observeLocalData() {

        vm.liveDataLocal.observe(viewLifecycleOwner, {
            val words = it ?: return@observe
            words.let {
                translateAdapter.setData(words)
                translateAdapter.notifyDataSetChanged()
            }
        })
    }

    private fun showErrorScreen(error: String?) {
        showViewError()
        Toast.makeText(context, getString(R.string.error) + error, Toast.LENGTH_LONG).show()
        vm.getData("error", true)
    }

    private fun showViewLoading() {}
    private fun showViewError() {}

    override fun onContextItemSelected(menuItem: MenuItem): Boolean {
        items.firstOrNull { it.id == menuItem.order }?.let {
            return when (menuItem.itemId) {
                R.id.menu_copy -> {
//                    onCopyClick(it)
                    true
                }
                R.id.menu_share -> {
//                    onShareClick(it)
                    true
                }
                R.id.menu_delete -> {
//                    onDeleteClick(it)
                    true
                }
                R.id.menu_to_favorite -> {
//                    onFavoriteClick(it)
                    true
                }
                else -> super.onContextItemSelected(menuItem)
            }
        }
        return false
    }

    @SuppressLint("RestrictedApi")
    private fun initRvComponents() {
        translateAdapter.onClickListener = { item, view ->
            val popup = PopupMenu(requireContext(), view).apply {
                menuInflater.inflate(R.menu.popup, menu)
                setOnMenuItemClickListener {
                    when (it.itemId) {
                        R.id.menu_copy -> {
                            //                           onCopyClick(item)
                            true
                        }
                        R.id.menu_share -> {
//                            onShareClick(item)
                            true
                        }
                        R.id.menu_delete -> {
//                            onDeleteClick(item)
                            true
                        }
                        R.id.menu_to_favorite -> {
//                            onFavoriteClick(item)
                            true
                        }
                        else -> false
                    }
                }
            }
            val popupHelper = MenuPopupHelper(requireContext(), popup.menu as MenuBuilder, view)
            popupHelper.setForceShowIcon(true)
            popupHelper.show()
        }
    }
}