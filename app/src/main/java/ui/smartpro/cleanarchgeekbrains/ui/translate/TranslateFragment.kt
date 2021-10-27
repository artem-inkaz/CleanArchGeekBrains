package ui.smartpro.cleanarchgeekbrains.ui.translate

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import ru.gb.gb_popular_libs.presentation.users.adapter.WordsAdapter
import ui.smartpro.cleanarchgeekbrains.R
import ui.smartpro.cleanarchgeekbrains.common.AppState
import ui.smartpro.cleanarchgeekbrains.common.BaseFragment
import ui.smartpro.cleanarchgeekbrains.data.ResponseItem
import ui.smartpro.cleanarchgeekbrains.databinding.FragmentTranslateBinding

class TranslateFragment() : BaseFragment<AppState, Contract.View, Contract.Presenter>(),
    Contract.View, WordsAdapter.Delegate {

    private val viewBinding: FragmentTranslateBinding by viewBinding()
    private val adapterDictionary = WordsAdapter(delegate = null)

    private val presenterImpl: PresenterImpl by viewModel()
    override val presenter: Contract.Presenter
        get() = presenterImpl

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
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
                presenter.getData(originalText.toString().trim(), true)

            } else {
                Toast.makeText(context, "Пожалуйста, заполните поле для ввода!", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    override fun onWordPicked(user: ResponseItem) {
        TODO("Not yet implemented")
    }

    override fun showBikes(words: List<ResponseItem>) {
        adapterDictionary.submitList(words)
        Log.d("dataModel", words.toString())
    }
}