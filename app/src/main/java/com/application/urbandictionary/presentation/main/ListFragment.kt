package com.application.urbandictionary.presentation.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.application.schedulerz.ui.main.List.DefinitionListAdapter
import com.application.urbandictionary.R
import javax.inject.Inject

class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private val mainActivity: MainActivity by lazy {
        requireActivity() as MainActivity
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MainViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
    }

    private lateinit var listRv: RecyclerView
    private lateinit var searchButton: Button
    private lateinit var searchText: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainActivity.appComponent.inject(this)
        listRv = view.findViewById(R.id.rv_list)
        searchButton = view.findViewById(R.id.button)
        searchText = view.findViewById(R.id.et_search)
        searchButton.setOnClickListener {
            val searchTerm = searchText.text.toString()
            viewModel.search(searchTerm)
        }
        listRv.layoutManager = LinearLayoutManager(context)
        viewModel.searchResultLiveData.observe(this, Observer {
            it?.let {
                listRv.adapter = DefinitionListAdapter(it.toMutableList())
            }
        })
    }
}
