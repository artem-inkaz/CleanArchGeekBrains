package ui.smartpro.cleanarchgeekbrains.ui.translate

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.gb.gb_popular_libs.presentation.users.adapter.WordsAdapter
import ui.smartpro.cleanarchgeekbrains.R
import ui.smartpro.cleanarchgeekbrains.common.BaseFragment
import ui.smartpro.cleanarchgeekbrains.data.AppState
import ui.smartpro.cleanarchgeekbrains.data.ResponseItem
import ui.smartpro.cleanarchgeekbrains.databinding.FragmentTranslateBinding

class TranslateFragment : BaseFragment<AppState>(),
    WordsAdapter.Delegate {

    private val viewBinding: FragmentTranslateBinding by viewBinding()
    private val adapterDictionary = WordsAdapter(delegate = null)

    private val vm by viewModel<TranslateViewModel>()
    private val observer = Observer<AppState> { renderData(it) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_translate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.recyclerView.adapter = adapterDictionary
        val manager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        viewBinding.recyclerView.apply {
            layoutManager = manager
            adapter = adapterDictionary
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
    }

    override fun onWordPicked(user: ResponseItem) {
        TODO("Not yet implemented")
    }

    override fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                val data = appState.data
                if (data == null || data.isEmpty()) {
                    showErrorScreen(getString(R.string.error_word))
                } else {
                    showViewSuccess(data)
                    adapterDictionary.submitList(data)
                }
            }
            is AppState.Loading -> {
                showViewLoading()
            }
            is AppState.Error -> {
                showErrorScreen(appState.error.message)
            }
        }
    }

    private fun setObservers() {
        vm.subscribe().observe(viewLifecycleOwner, {
            renderData(it)
        })
    }


    private fun showErrorScreen(error: String?) {
        showViewError()
        Toast.makeText(context, error, Toast.LENGTH_LONG).show()
        vm.getData("error", true)
    }

    private fun showViewSuccess(words: List<ResponseItem>) {
        adapterDictionary.submitList(words)
    }

    private fun showViewLoading() {}
    private fun showViewError() {}
}