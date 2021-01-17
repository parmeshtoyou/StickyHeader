package com.param.stickyheaderlib

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.param.stickyheader.StickHeader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: ${StickHeader.testStickyHeader()}")
    }

    companion object {
        private val TAG = MainActivity::class.java.name
    }
}