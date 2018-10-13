package prodroid.juan.moviesappkotlin.movies.ui

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import prodroid.juan.moviesappkotlin.R
import prodroid.juan.moviesappkotlin.databinding.SearchFragmentBinding
import prodroid.juan.moviesappkotlin.movies.binding.FragmentDataBindingComponent
import prodroid.juan.moviesappkotlin.movies.di.Injectable
import prodroid.juan.moviesappkotlin.movies.util.autoCleared
import javax.inject.Inject

class SearchFragment: Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    var binding by autoCleared<SearchFragmentBinding>()

    var dataBindingComponent: DataBindingComponent = FragmentDataBindingComponent(this)

    lateinit var searchViewModel: SearchViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.search_fragment,
                container,
                false,
                dataBindingComponent)

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        searchViewModel = ViewModelProviders.of(this, viewModelFactory).get(SearchViewModel::class.java)
    }
}