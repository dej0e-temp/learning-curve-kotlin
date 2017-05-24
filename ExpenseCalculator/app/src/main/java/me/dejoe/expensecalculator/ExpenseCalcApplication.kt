package me.dejoe.expensecalculator

import android.app.Application
import android.content.Context
import android.util.Log


class ExpenseCalcApplication : Application() {
    private val TAG = "Application"
    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate:")
        instance = this
        appContext = applicationContext
    }

    companion object {
        lateinit var instance: ExpenseCalcApplication
        lateinit var appContext: Context
    }
}