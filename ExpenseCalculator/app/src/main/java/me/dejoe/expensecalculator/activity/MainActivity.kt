package me.dejoe.expensecalculator.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import me.dejoe.expensecalculator.R
import me.dejoe.expensecalculator.adapter.ExpenseAdapter
import me.dejoe.expensecalculator.model.ExpenseModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupRecyclerView()
    }

    fun setupRecyclerView() {
        val mRecyclerView: RecyclerView = expense_recycler_view

        mRecyclerView.layoutManager = LinearLayoutManager(this)
        mRecyclerView.adapter = ExpenseAdapter(generateDataSet(), this)
    }

    fun generateDataSet(): List<ExpenseModel> {
        val dataSet: MutableList<ExpenseModel> = ArrayList()
//        data class ExpenseModel(var amount: Int, var expenseType: String, var place:String, var expenseComment:String, var expenseTime: String) {
//        @JvmStatic val dateTimeFormat = "yyyy-MM-dd'T'HH:mm:ss"
        for (index in 0..10) {
            dataSet.add(ExpenseModel(10000, if (index%2==0) "credit" else "debit", "Bank " + index, "Comment " + index, "2012-04-03 11:11:11"))
        }
        return dataSet
    }
}
