package com.nakyoung98.timecalculator_kotlin

class Time( val hour:Int = 0, val min:Int= 0, val sec:Int= 0, val data: TimeMetaData = TimeMetaData()) {

    override fun toString(): String {
        var timeString = ""

        if(hour in 0..9){
            timeString += "0$hour"
        }else{
            timeString += "$hour"
        }

        timeString += ":"

        if(min in 0..9){
            timeString += "0$min"
        }else{
            timeString += "$min"
        }

        timeString += ":"

        if(sec in 0..9){
            timeString += "0$sec"
        }else{
            timeString += "$sec"
        }

        return timeString
    }

    fun convertSec(): Time{

        var convertedSec :Int

        if (hour>=0){
            //만약 hour가 -인경우, 우선 +로 변경하여 계산한 후에 마지막 결과에 - 붙여줌
            convertedSec = hour*60*60 + min*60 + sec }
        else{
            convertedSec = (-hour*60*60) + min*60 + sec }

        if (hour<0){
            convertedSec = -convertedSec }

        return Time(0,0,convertedSec)
    }

    fun convertSecToTime():Time{
        var newSec:Int
        if (sec>=0){ //-일경우 우선 +로 계산한 후에, 마지막에 -붙여줌
            newSec = sec }
        else{
            newSec = -sec }

        var newMin:Int = newSec/60
        newSec %= 60

        var newHour:Int = newMin/60
        newMin %= 60

        if(sec<0){
            newHour = -newHour }

        return Time(newHour, newMin, newSec)
    }
}