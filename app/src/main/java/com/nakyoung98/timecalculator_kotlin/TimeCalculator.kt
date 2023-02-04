package com.nakyoung98.timecalculator_kotlin

import android.util.Log
import kotlin.math.min

object TimeCalculator {
    private val TAG = "TimeCalculator"
    var lastResult:Time = Time()
    var lastProcess:String =""
        get() = field
        set(value) {
            field = value
        }

    fun add(addend1:Time, addend2:Time):Time{
        var addend1Sec :Time = addend1.convertSec()
        var addend2Sec :Time = addend2.convertSec()

        var tempSec:Time = Time(0,0,addend1Sec.sec + addend2Sec.sec)


        var resultTime = tempSec.convertSecToTime()

        Log.i(TAG,resultTime.toString())
        setLastProcess(addend1,addend2,"＋")
        lastResult = resultTime
        return resultTime
    }

    fun sub(minuend:Time, subtrahend:Time):Time{
        var minuendSec: Time = minuend.convertSec()
        var subtrahendSec :Time = subtrahend.convertSec()

        var tempSec:Time = Time(0,0,minuendSec.sec-subtrahendSec.sec)

        var resultTime = tempSec.convertSecToTime()

        Log.i(TAG,resultTime.toString())
        setLastProcess(minuend,subtrahend,"－")
        lastResult = resultTime
        return resultTime
    }


    fun div(dividend:Time, dividor:Time): Time{
        var dividendSec:Time = dividend.convertSec()
        var dividorSec:Time = dividor.convertSec()

        var tempSec:Time = Time(0,0,dividendSec.sec/dividorSec.sec)

        var resultTime = tempSec.convertSecToTime()

        Log.i(TAG,resultTime.toString())
        setLastProcess(dividend,dividor,"÷")
        lastResult = resultTime
        return resultTime
    }

    fun mul(multipliend:Time, multiplier:Time):Time{
        var multipliendSec:Time = multipliend.convertSec()
        var multiplierSec:Time = multiplier.convertSec()

        var tempSec:Time = Time(0,0,multipliendSec.sec * multiplierSec.sec)

        var resultTime = tempSec.convertSecToTime()

        Log.i(TAG,resultTime.toString())
        setLastProcess(multipliend,multiplier,"×")
        lastResult = resultTime
        return resultTime
    }
    fun reset(): Time{
        lastResult = Time()
        setLastProcess("RESET")
        return Time()
    }

    private fun setLastProcess(time1:Time, time2:Time, instruction:String) {
        lastProcess = "${time1.toString()} $instruction ${time2.toString()} ="
        Log.i(TAG, lastProcess)
    }

    @JvmName("setLastProcess1")
    private fun setLastProcess(string:String){
        lastProcess = string
        Log.i(TAG, lastProcess)
    }
}