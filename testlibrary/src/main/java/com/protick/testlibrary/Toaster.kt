package com.protick.testlibrary

import android.content.Context
import android.widget.Toast

/**
 * Created by protick kumer dey on 2020/05/14
 * Copyright (c) 2020 bjit. All rights reserved.
 * protick.kumer@bjitgroup.com
 * Last modified $file.lastModified
 */
class Toaster {
    companion object {
        fun showToastMsg(context: Context, msg: String) {
            Toast.makeText(context, msg, Toast.LENGTH_LONG).show()
        }
    }
}