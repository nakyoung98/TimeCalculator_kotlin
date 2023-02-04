package com.nakyoung98.timecalculator_kotlin.placeholder

import android.util.Log
import java.util.ArrayList
import java.util.HashMap

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 *
 * TODO: Replace all uses of this class before publishing your app.
 */
object PlaceholderContent {

    /**
     * An array of sample (placeholder) items.
     */
    val ITEMS: MutableList<PlaceholderItem> = ArrayList()

    /**
     * A map of sample (placeholder) items, by ID.
     */
    val ITEM_MAP: MutableMap<String, PlaceholderItem> = HashMap()

    var COUNT = 0

    init {
//        // Add some sample items.
//        for (i in 1..COUNT) {
//            addItem(createPlaceholderItem(i))
//        }
    }

    fun addItem(item: PlaceholderItem) {
        ITEMS.add(item)
        ITEM_MAP.put(item.process, item)
        COUNT ++
        Log.i("PlacehorderContent",item.toString())
    }

//    private fun createPlaceholderItem(position: Int): PlaceholderItem {
//        return PlaceholderItem(position.toString(), "Item " + position)
//    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0..position - 1) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }

    /**
     * A placeholder item representing a piece of content.
     */
    data class PlaceholderItem(val process: String, val result: String) {
        override fun toString(): String = "$process $result" //aa:aa:aa + aa:aa:aa = aa:aa:aa
    }
}