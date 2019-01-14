package mobile.j.pro.kotlinmoviesapp.binding

import android.databinding.BindingAdapter
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("gridLayoutManager")
    fun setLayoutManager(recyclerView: RecyclerView, orientation: Int) {

        if(orientation == LinearLayoutManager.VERTICAL) {
            recyclerView.layoutManager = GridLayoutManager(recyclerView.context, 3)
        }
    }
}