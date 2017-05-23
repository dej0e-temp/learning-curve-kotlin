package me.dejoe.expensecalculator

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatDelegate
import android.util.Log


/**
 * Created by Samrat on 7/5/16.
 */
object Application {
    private val TAG = Application::class.java.simpleName

    private val instance: Application? = null

    fun get(): Application? {
        return instance
    }

    val appContext: Context? = null
}

