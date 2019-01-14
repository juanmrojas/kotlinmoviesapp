package mobile.j.pro.kotlinmoviesapp.binding

import android.app.Activity
import android.databinding.DataBindingComponent

class ActivityDataBindingComponent(activity: Activity) : DataBindingComponent {
    private val adapter = ActivityBindingAdapters(activity)

    override fun getActivityBindingAdapters() = adapter
}
