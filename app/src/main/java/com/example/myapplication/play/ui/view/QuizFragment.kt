package com.example.myapplication.play.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.QuizDataFragmentBinding
import com.example.myapplication.play.MainAppScopeImpl
import com.example.myapplication.play.data.repo.LocalDataSource
import com.example.myapplication.play.data.repo.QuizDatRepo
import com.example.myapplication.play.ui.Constants
import com.example.myapplication.play.ui.viewmodel.QuizViewModel
import com.example.myapplication.play.usecase.LocalRandomGenerator
import com.example.myapplication.play.usecase.QuizUseCase
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class QuizFragment : Fragment() {
    private val viewModel = QuizViewModel(
        QuizDatRepo(LocalDataSource(requireContext(), Gson()), MainAppScopeImpl().ioScope()),
        QuizUseCase(LocalRandomGenerator())
    )

    private lateinit var viewBinding: QuizDataFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = QuizDataFragmentBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToStreams()
    }

    private fun subscribeToStreams() {

    }

    fun newInstance(input: String): QuizFragment {
        return QuizFragment().apply {
            arguments = Bundle().apply {
                putString(Constants.DATA_SOURCE_ASSETS_PATH, input)
            }
        }
    }
}