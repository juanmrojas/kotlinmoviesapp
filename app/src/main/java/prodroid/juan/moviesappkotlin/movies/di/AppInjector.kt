package prodroid.juan.moviesappkotlin.movies.di

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import dagger.android.AndroidInjection
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import prodroid.juan.moviesappkotlin.movies.MoviesApp

object AppInjector {
    fun init(moviesApp: MoviesApp) {
        DaggerAppComponent
                .builder()
                .application(moviesApp)
                .build()
                .inject(moviesApp)
        moviesApp
                .registerActivityLifecycleCallbacks(object : Application.ActivityLifecycleCallbacks {
                    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                        handleActivity(p0)
                    }

                    override fun onActivityStarted(p0: Activity?) {

                    }

                    override fun onActivityResumed(p0: Activity?) {
                    }

                    override fun onActivityPaused(p0: Activity?) {
                    }

                    override fun onActivityStopped(p0: Activity?) {
                    }

                    override fun onActivitySaveInstanceState(p0: Activity?, p1: Bundle?) {
                    }

                    override fun onActivityDestroyed(p0: Activity?) {
                    }

                })
    }

    private fun handleActivity(activity: Activity) {
        if (activity is HasSupportFragmentInjector) {
            AndroidInjection.inject(activity)
        }
        if (activity is FragmentActivity) {
            activity.supportFragmentManager
                    .registerFragmentLifecycleCallbacks(
                            object : android.support.v4.app.FragmentManager.FragmentLifecycleCallbacks() {
                                override fun onFragmentCreated(
                                        fm: android.support.v4.app.FragmentManager,
                                        f: android.support.v4.app.Fragment,
                                        savedInstanceState: Bundle?
                                ) {
                                    if (f is Injectable) {
                                        AndroidSupportInjection.inject(f)
                                    }
                                }
                            }, true
                    )
        }
    }
}