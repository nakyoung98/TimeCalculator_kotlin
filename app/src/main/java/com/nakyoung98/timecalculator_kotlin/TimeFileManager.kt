package com.nakyoung98.timecalculator_kotlin

import androidx.activity.viewModels
import androidx.lifecycle.Observer
import java.util.*
import kotlin.collections.ArrayList

object TimeFileManager {
    var TimeCalculationResultsList: ArrayList<Time> = ArrayList()

    init{
        restore()
    }

    fun addToList(time:Time){
        TimeCalculationResultsList.add(time)
        save()
    }
    fun save(){}
    fun restore(){}
}