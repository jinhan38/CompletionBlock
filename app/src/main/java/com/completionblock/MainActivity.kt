package com.completionblock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        callbackString(completion = {
            Log.d(TAG, "onCreate: $it")

            if (it == "1") {
                someCallback(completion = {
                    Log.d(TAG, "onCreate: 컴플리션 블럭 호출")
                })

            }
        })

    }

    fun someCallback(completion: () -> Unit) {
        Log.d(TAG, "someCallback: 메소드 진입")
        Handler().postDelayed({
            completion()
            Log.d(TAG, "someCallback: ")
        }, 1000)
    }

    fun callbackString(completion: (String) -> Unit) {
        Handler().postDelayed({

            completion("1")
        }, 2000)
    }
}