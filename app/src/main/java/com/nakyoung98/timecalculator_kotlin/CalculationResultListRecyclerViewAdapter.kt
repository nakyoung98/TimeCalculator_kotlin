package com.nakyoung98.timecalculator_kotlin

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.nakyoung98.timecalculator_kotlin.placeholder.PlaceholderContent.PlaceholderItem
import com.nakyoung98.timecalculator_kotlin.databinding.FragmentCalculationResultBinding

/**
 * [RecyclerView.Adapter] that can display a [PlaceholderItem].
 * TODO: Replace the implementation with code for your data type.
 */
class CalculationResultListRecyclerViewAdapter(
    private val values: List<PlaceholderItem>
) : RecyclerView.Adapter<CalculationResultListRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            FragmentCalculationResultBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = values[position]
        holder.processView.text = item.process
        holder.resultView.text = item.result
    }

    override fun getItemCount(): Int = values.size

    inner class ViewHolder(binding: FragmentCalculationResultBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val processView: TextView = binding.calculationProcessText
        val resultView: TextView = binding.calculationResultView

        override fun toString(): String {
            return super.toString() + " '" + processView.text + resultView.text + "'"
        }
    }

}