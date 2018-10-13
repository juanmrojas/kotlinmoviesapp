package prodroid.juan.moviesappkotlin.movies.binding

import android.databinding.BindingAdapter
import android.support.v4.app.Fragment
import android.widget.ImageView
import com.bumptech.glide.Glide
import javax.inject.Inject

// Binding adapter that works with a fragment instance.
class FragmentBindingAdapters @Inject constructor(val fragment: Fragment){

    @BindingAdapter("imageUrl")
    fun bindImage(imageView: ImageView, url: String?) {
        Glide.with(fragment).load(url).into(imageView)
    }
}