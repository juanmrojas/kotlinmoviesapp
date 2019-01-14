package mobile.j.pro.kotlinmoviesapp.ui.movies

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import mobile.j.pro.kotlinmoviesapp.AppExecutors
import mobile.j.pro.kotlinmoviesapp.R
import mobile.j.pro.kotlinmoviesapp.binding.ActivityDataBindingComponent
import mobile.j.pro.kotlinmoviesapp.common.MovieListAdapter
import mobile.j.pro.kotlinmoviesapp.databinding.ActivityMoviesBinding
import javax.inject.Inject

class MoviesActivity : AppCompatActivity(), HasActivityInjector {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var appExecutors: AppExecutors

    @Inject
    lateinit var moviesViewModel: MoviesViewModel

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    lateinit var binding: ActivityMoviesBinding

    lateinit var adapter: MovieListAdapter

    var dataBindingComponent: DataBindingComponent = ActivityDataBindingComponent(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movies)

        moviesViewModel = ViewModelProviders.of(this, viewModelFactory).get(MoviesViewModel::class.java)
        initRecyclerView()

        adapter = MovieListAdapter(
                dataBindingComponent = dataBindingComponent,
                appExecutors = appExecutors
        ) {
            // TODO: implement a click action for the item
        }

        binding.movieList.adapter = adapter
        initSearchInputListener()
    }

    override fun activityInjector() = dispatchingAndroidInjector

    private fun initSearchInputListener() {
        binding.input.setOnEditorActionListener { view: View, actionId: Int, _: KeyEvent? ->
            if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                doSearch(view)
                true
            } else {
                false
            }
        }
        binding.input.setOnKeyListener { view: View, keyCode: Int, event: KeyEvent ->
            if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                doSearch(view)
                true
            } else {
                false
            }
        }
    }

    private fun doSearch(v: View) {
        val query = binding.input.text.toString()
        binding.query = query
        moviesViewModel.setQuery(query)
    }

    private fun initRecyclerView() {
        binding.movieList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                // TODO: read next page from endpoint result
            }
        })

        moviesViewModel.results.observe(this, Observer { result ->
            adapter.submitList(result?.data)
        })
    }
}
