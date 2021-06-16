package com.ibeybeh.submission.moviecatalogue.utils.ext

import android.view.View

fun View.setViewVisibility(boolean: Boolean) {
    if (boolean) {
        this.visibility = View.VISIBLE
    }else{
        this.visibility = View.GONE
    }
}