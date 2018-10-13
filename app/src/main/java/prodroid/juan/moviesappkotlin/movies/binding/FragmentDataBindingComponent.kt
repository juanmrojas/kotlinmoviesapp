package prodroid.juan.moviesappkotlin.movies.binding

import android.databinding.DataBindingComponent
import android.support.v4.app.Fragment

/**
 * A data binding implementation for fragments
 */

class FragmentDataBindingComponent(fragment: Fragment) : DataBindingComponent {
    private val adapter = FragmentBindingAdapters(fragment)

    override fun getFragmentBindingAdapters() = adapter
}