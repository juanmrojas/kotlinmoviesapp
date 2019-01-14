package mobile.j.pro.kotlinmoviesapp.common

import android.databinding.DataBindingComponent
import android.databinding.DataBindingUtil
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import mobile.j.pro.kotlinmoviesapp.AppExecutors
import mobile.j.pro.kotlinmoviesapp.R
import mobile.j.pro.kotlinmoviesapp.databinding.MovieItemBinding
import mobile.j.pro.kotlinmoviesapp.vo.Movie

class MovieListAdapter(
        private val dataBindingComponent: DataBindingComponent,
        appExecutors: AppExecutors,
        private val movieClickCallback: ((Movie) -> Unit)?) : DataBoundListAdapter<Movie, MovieItemBinding>(
        appExecutors = appExecutors,
        diffCallback = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
                return oldItem.overview == newItem.overview
            }
        }
) {

    override fun createBinding(parent: ViewGroup): MovieItemBinding{
        val binding = DataBindingUtil.inflate<MovieItemBinding>(
                LayoutInflater.from(parent.context),
                R.layout.movie_item,
                parent,
                false,
                dataBindingComponent
        )
        binding.root.setOnClickListener {
            binding.movie?.let {
                movieClickCallback?.invoke(it)
            }
        }
        return binding
    }

    override fun bind(binding: MovieItemBinding, item: Movie) {
        binding.movie = item
    }

}