package prodroid.juan.moviesappkotlin.movies.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.Observables
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toObservable
import kotlinx.android.synthetic.main.reactive_layout.*
import prodroid.juan.moviesappkotlin.R

class ReactiveActivity: AppCompatActivity() {

    private var TAG = "ReactiveActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.reactive_layout)

        button.setOnClickListener {
            startStream()
        }
    }

    private fun startStream() {
        val list = listOf("1", "2", "3", "4", "5")
        val numbers = Observable.range(1, 6)
        val strings = Observable.just("One", "Two", "Three", "Four",
                "Five", "Six")
        /*list.toObservable()
                .subscribeBy (
                    onNext = { println(it)},
                    onError = {it.printStackTrace()},
                    onComplete = { println("onCompleted!")}
        )*/
        val zipped = Observables.zip(strings, numbers) { s, n -> "$s $n" }
        zipped.subscribe(::println)

    }

    private fun getObservable(): Observable<String> {
        return Observable.just("1", "2", "3", "4", "5")
    }

    private fun getObserver(): Observer<String> {
        return object : Observer<String> {
            override fun onComplete() {
                Log.d(TAG, "onComplete")
            }

            override fun onSubscribe(d: Disposable) {}

            override fun onNext(t: String) {
                Log.d(TAG, "onNext: $t")
            }

            override fun onError(e: Throwable) {
                Log.e(TAG, "onError: " + e.message)
            }
        }
    }
}