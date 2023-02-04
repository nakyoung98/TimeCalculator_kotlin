package com.nakyoung98.timecalculator_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.nakyoung98.timecalculator_kotlin.databinding.ActivityMainBinding
import com.nakyoung98.timecalculator_kotlin.placeholder.PlaceholderContent

class MainActivity : AppCompatActivity() {

    private val TAG = "MainActivity"
    lateinit var mAdView : AdView

    //바인딩 객체 선언
    private var mBinding: ActivityMainBinding? =null
    private val binding get() = mBinding!!

    private val model: TimeStringViewModel by viewModels()
    private var timeString:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)

        //광고 표시
        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        mBinding!!.adView.loadAd(adRequest)
        Log.i(TAG,""+adRequest.isTestDevice(this))

        val stringObserver = Observer<String> {newTimeString->
            Log.i(TAG,"timeString length: $newTimeString")

            when(newTimeString.length){
                0 -> {
                    mBinding!!.hourTextView.text = "00"
                    mBinding!!.minTextView.text = "00"
                    mBinding!!.secondTextView.text = "00" }
                1 -> {
                    mBinding!!.hourTextView.text = "0"+newTimeString[0]
                    mBinding!!.minTextView.text = "00"
                    mBinding!!.secondTextView.text = "00" }
                2 -> {
                    mBinding!!.hourTextView.text = newTimeString.substring(0,2)
                    mBinding!!.minTextView.text = "00"
                    mBinding!!.secondTextView.text = "00" }
                3 -> {
                    mBinding!!.hourTextView.text = newTimeString.substring(0,2)
                    mBinding!!.minTextView.text = "0"+newTimeString[2]
                    mBinding!!.secondTextView.text = "00" }
                4 -> {
                    mBinding!!.hourTextView.text = newTimeString.substring(0,2)
                    mBinding!!.minTextView.text = newTimeString.substring(2,4)
                    mBinding!!.secondTextView.text = "00"}
                5 -> {
                    mBinding!!.hourTextView.text = newTimeString.substring(0,2)
                    mBinding!!.minTextView.text = newTimeString.substring(2,4)
                    mBinding!!.secondTextView.text = "0"+newTimeString[4]}
                6 -> {
                    mBinding!!.hourTextView.text = newTimeString.substring(0,2)
                    mBinding!!.minTextView.text = newTimeString.substring(2,4)
                    mBinding!!.secondTextView.text = newTimeString.substring(4,6)}
            }
        }

        model.timeString.observe(this,stringObserver)

        setContentView(binding.root)
    }

    override fun onDestroy() {
        mBinding = null
        super.onDestroy()
    }

    fun dialogOnClick(view: View){
        if(view is Button){
            if(timeString.length>=6) return

            timeString += view.text
            model.timeString.value = timeString
            Log.i(TAG, timeString)
        }
    }

    fun deleteOnClick(view: View){
        if(view is Button){
            timeString = timeString.dropLast(1)
            model.timeString.value = timeString
            Log.i(TAG, timeString)
        }
    }

    fun addOnClick(view:View){
        if(timeString.length!=6) return

        //000000
        var hour = timeString.substring(0, 2).toInt()
        var minute = timeString.substring(2,4).toInt()
        var second = timeString.substring(4).toInt()

        var addend = Time(hour,minute,second)

        TimeCalculator.add(TimeCalculator.lastResult,addend)

        resetTimeString()

        addItem()
    }

    fun subOnClick(view:View){
        if(timeString.length!=6) return

        //000000
        var hour = timeString.substring(0, 2).toInt()
        var minute = timeString.substring(2,4).toInt()
        var second = timeString.substring(4).toInt()

        var subtrahend = Time(hour,minute,second)

        TimeCalculator.sub(TimeCalculator.lastResult,subtrahend)

        resetTimeString()
        addItem()

    }

    fun divOnClick(view:View){
        if(timeString.length!=6) return

        //000000
        var hour = timeString.substring(0, 2).toInt()
        var minute = timeString.substring(2,4).toInt()
        var second = timeString.substring(4).toInt()

        var dividor = Time(hour,minute,second)

        TimeCalculator.div(TimeCalculator.lastResult,dividor)

        resetTimeString()
        addItem()

    }

    fun resetOnClick(view:View){
        resetTimeString()
        TimeCalculator.reset()
        addItem()
    }

    fun resetTimeString(){
        timeString = ""
        model.timeString.value = timeString
    }

    fun addItem(){
        PlaceholderContent.addItem(PlaceholderContent.PlaceholderItem(TimeCalculator.lastProcess,TimeCalculator.lastResult.toString()))
        mBinding?.fragmentContainerView?.getFragment<CalculationResultFragment>()?.refreshFragment()
    }
}