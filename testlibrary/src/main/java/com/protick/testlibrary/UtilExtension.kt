package com.protick.testlibrary

import android.content.Context
import android.content.res.Resources
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by protick kumer dey on 2020/05/14
 * Copyright (c) 2020 bjit. All rights reserved.
 * protick.kumer@bjitgroup.com
 * Last modified $file.lastModified
 */


fun String.getTimeToHour(): Int {
    val hour = this.trim().split(":")
    val len = hour.count()
    if (len == 2) {
        return hour[0].toInt()
    }
    return 0
}



fun Long.toSeconds(): Long = this / 1000


fun Int.minuteToHour(): Int {
    return this / 60
}

fun Long.unixToHourAndMinute(): String {
    if (this == 0L) return "00:00"
    val date = Date(this * 1000L)
    val formatter = SimpleDateFormat("HH:mm", Locale.JAPAN)
    formatter.timeZone = TimeZone.getTimeZone("Japan")
    return formatter.format(date)
}

fun Long.unixToMonth(): Int {
    val cal = Calendar.getInstance()
    cal.timeInMillis = this * 1000L
    return cal.get(Calendar.MONTH) + 1
}

fun Long.unixToDate(): String {
    val date = Date(this * 1000L)
    val dateFormatter = SimpleDateFormat("yyyy/MM/dd", Locale.JAPAN)
    dateFormatter.timeZone = TimeZone.getTimeZone("Japan")
    return dateFormatter.format(date)
}

fun Long.unixTohour(): Int {
    val cal = Calendar.getInstance()
    cal.timeInMillis = this * 1000L
    cal.timeZone = TimeZone.getTimeZone("Japan")
    return cal.get(Calendar.HOUR_OF_DAY)
}

fun currentMonth(): Int {
    val cal = Calendar.getInstance(TimeZone.getTimeZone("Japan"), Locale.JAPAN)
    return cal.get(Calendar.MONTH) + 1
}

fun currentHour(): Int {
    val cal = Calendar.getInstance(TimeZone.getTimeZone("Japan"), Locale.JAPAN)
    return cal.get(Calendar.HOUR_OF_DAY)
}


fun View.hideSoftKeyboard() {
    val inputMethodManager =
        context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
    inputMethodManager?.hideSoftInputFromWindow(this.windowToken, 0)
}

fun Boolean?.value(): Boolean {
    if (this == null) return false
    return this
}


fun Context?.screenWidthInPx(): Int {
    if (this == null) return 0
    val dm = DisplayMetrics()
    val wm = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    wm.defaultDisplay.getMetrics(dm)
    return dm.widthPixels
}

fun Context?.screenHeightInPx(): Int {
    if (this == null) return 0
    val dm = DisplayMetrics()
    val wm = this.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    wm.defaultDisplay.getMetrics(dm)
    return dm.heightPixels
}

fun Int.dpToPx(): Int {
    return (this * Resources.getSystem().displayMetrics.density).toInt()
}

fun Int.pixelsToDp(): Int {
    return (this / Resources.getSystem().displayMetrics.density).toInt()
}