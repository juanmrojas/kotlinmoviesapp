package mobile.j.pro.kotlinmoviesapp.binding

import android.app.Activity
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import javax.inject.Inject

class ActivityBindingAdapters @Inject constructor(val activity: Activity) {

    @BindingAdapter("imageUrl")
    fun bindImage(imageView: ImageView, url: String?) {
        Glide.with(activity)
                .asBitmap()
                .load("https://image.tmdb.org/t/p/w500" + url)
                .into(imageView)
    }
}