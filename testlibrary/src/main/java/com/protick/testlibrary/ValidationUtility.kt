package com.protick.testlibrary

import java.util.regex.Pattern

/**
 * Created by protick kumer dey on 2020/05/19
 * Copyright (c) 2020 bjit. All rights reserved.
 * protick.kumer@bjitgroup.com
 * Last modified $file.lastModified
 */


/**
 * This function doesn't takes any input.
 * It is a string extension function
 * Uses: name.isValidName() -> it return a boolean value
 */
fun String.isValidName(): Boolean {
    return Pattern.compile("^[a-zA-Zぁ-ゔゞ゛゜ー ]*\$").matcher(this).matches()
}

/**
 * This function doesn't takes any input.
 * It is a string extension function
 * Uses: kprotickju22@gmail.com.isEmailValid() -> it return a boolean value
 */
fun String?.isEmailValid(): Boolean {
    if (this.isNullOrEmpty()) return false
    return android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()
}

fun String?.isValidPassword(): Boolean {

    val startString = "^"
    val oneDigit = "(?=.*[0-9])" // at least one digit
    val oneLower = "(?=.*[a-z])" // at least one small letter
    val oneUpper = "(?=.*[A-Z])" // at least one capital
    val anyLetter = "(?=.*[a-zA-Z])" // any letter
    val specialChar = "(?=.*[@#$%^&+=])" // at least one special character
    val noWhiteSpace = "(?=\\S+$)" // no space
    val length = ".{4,}" // at least 4 lenght
    val endString = "$"

    return false

}
