package com.nakyoung98.timecalculator_kotlin

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class TimeStringViewModel : ViewModel() {

    val timeString : MutableLiveData<String> by lazy{
        MutableLiveData<String>()
    }

}
