package com.ibeybeh.submission.moviecatalogue.utils.ext

import android.view.View
import android.widget.ProgressBar

fun ProgressBar.setVisibility(boolean: Boolean) {
    if (boolean) {
        this.visibility = View.VISIBLE
    }else{
        this.visibility = View.GONE
    }
}