package com.bikk.redditapp.ui.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bikk.redditapp.R
import com.bikk.redditapp.data.popularItemRedditModel.PopularItemRedditModel
import com.bikk.redditapp.data.source.AppState
import com.bikk.redditapp.databinding.FragmentMainBinding
import com.bikk.redditapp.ui.screens.adapter.MainAdapter
import kotlinx.coroutines.flow.collect
import org.koin.android.ext.android.getKoin
import org.koin.core.scope.Scope

class MainFragment : Fragment(R.layout.fragment_main) {
    private val viewBinding: FragmentMainBinding by viewBinding()
    private val scope: Scope = getKoin().createScope<MainFragment>()
    private val viewModel: MainViewModel = scope.get()
    private var adapter: MainAdapter? = null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setupMenu()
        setupOnView()

    }

    private fun setupMenu() {
        setHasOptionsMenu(true)
        setMenuVisibility(true)
    }

    private fun setupOnView() {
        viewLifecycleOwner
            .lifecycleScope
            .launchWhenCreated {
                viewModel.getMore().collect {

                    adapter = MainAdapter()
                    viewBinding.rvMain.adapter = adapter
                    adapter?.submitData(it)
                    renderData(it as AppState)
                }
            }
    }


    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                adapter = MainAdapter()
                viewBinding.rvMain.adapter = adapter
                if (appState.data is PopularItemRedditModel) {
                    adapter = MainAdapter()
                    viewBinding.rvMain.adapter = adapter
                }
            }
            else -> {}
        }
    }

}