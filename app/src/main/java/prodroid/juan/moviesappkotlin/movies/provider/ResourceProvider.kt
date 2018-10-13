package prodroid.juan.moviesappkotlin.movies.provider

import android.content.Context
import android.support.annotation.StringRes
import javax.inject.Inject

class ResourceProvider @Inject constructor(context: Context) {

    var context: Context? = null

    init {
        this.context = context
    }

    fun getString(@StringRes stringId: Int): String? {
        return context?.getString(stringId)
    }
}