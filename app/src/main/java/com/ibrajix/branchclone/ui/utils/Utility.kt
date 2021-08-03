package com.ibrajix.branchclone.ui.utils

import android.app.Activity
import android.content.ClipData
import android.content.Context
import android.graphics.Color
import android.view.View

object Utility {

    //copy text
    fun copyText(context: Context, text: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as android.content.ClipboardManager
        val clip = ClipData.newPlainText("Copied Text", text)
        clipboard.setPrimaryClip(clip)
    }

    //transparent status bar
    fun Activity.transparentStatusBar() {
        val decor = window.decorView
        decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        window.statusBarColor = Color.TRANSPARENT
    }

}