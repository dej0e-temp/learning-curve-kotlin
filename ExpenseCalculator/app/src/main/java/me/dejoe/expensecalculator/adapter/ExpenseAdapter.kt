package me.dejoe.expensecalculator.adapter

import android.content.Context
import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.expense_single_row.view.*
import me.dejoe.expensecalculator.R
import me.dejoe.expensecalculator.model.Constants
import me.dejoe.expensecalculator.model.ExpenseModel
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Created by dejoe on 5/23/17.
 */

open class ExpenseAdapter(private val dataSet: List<ExpenseModel>, private val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {

        val expense: ExpenseModel = dataSet.get(position)
        holder?.itemView?.amount_tv_single_row?.text = expense.amount.toString()
        val date: Date = expense.expenseTime.generateDateObjectFromString()
        holder?.itemView?.day_tv_single_row?.text = date.getDayOfMonth()
        holder?.itemView?.month_tv_single_row?.text = date.getShortMonthName()
        holder?.itemView?.year_tv_single_row?.text = date.getYearString()
        holder?.itemView?.comment_tv_single_row?.text = expense.expenseComment
        holder?.itemView?.place_tv_single_row?.text = expense.place

        holder?.itemView?.type_tv_single_row?.text = when (expense.expenseType) {
            "credit" -> "+"
            "debit" -> "-"
            else -> ""
        }
        holder?.itemView?.type_tv_single_row?.setTextColor(ContextCompat.getColor(context, Color().getColorForExpenseType(expense.expenseType)))
        holder?.itemView?.amount_tv_single_row?.setTextColor(ContextCompat.getColor(context, Color().getColorForExpenseType(expense.expenseType)))
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.expense_single_row, parent, false)
        return ExpenseViewholder(view)
    }

    class ExpenseViewholder(view: View) : RecyclerView.ViewHolder(view)
}


fun Color.getColorForExpenseType(expenseType: String): Int {
    when (expenseType) {
        "credit" -> return R.color.credit_color
        "debit" -> return R.color.debit_color
        else -> return R.color.primary_text
    }

}

fun Date.getYearString(): String {
    val sdf: SimpleDateFormat = SimpleDateFormat(Constants.yearDisplayFormat, Locale.ENGLISH)
    return sdf.format(this).toUpperCase()
}

fun Date.getShortMonthName(): String {
    val sdf: SimpleDateFormat = SimpleDateFormat(Constants.monthDisplayFormat, Locale.ENGLISH)
    return sdf.format(this).toUpperCase()
}

fun Date.getDayOfMonth(): String {
    val sdf: SimpleDateFormat = SimpleDateFormat(Constants.dateDisplayFormat, Locale.ENGLISH)
    return sdf.format(this).toUpperCase()
}

fun String.generateDateObjectFromString(): Date {
    val sdf: SimpleDateFormat = SimpleDateFormat(Constants.dateTimeFormat, Locale.ENGLISH)
    return sdf.parse(this)
}
