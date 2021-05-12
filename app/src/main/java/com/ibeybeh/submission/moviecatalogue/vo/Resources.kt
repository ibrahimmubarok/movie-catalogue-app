package com.ibeybeh.submission.moviecatalogue.vo

import com.ibeybeh.submission.moviecatalogue.vo.Status.ERROR
import com.ibeybeh.submission.moviecatalogue.vo.Status.LOADING
import com.ibeybeh.submission.moviecatalogue.vo.Status.SUCCESS

data class Resources<T>(val status: Status, val data: T?, val message: String?) {
    companion object {
        fun <T> success(data: T?): Resources<T> = Resources(SUCCESS, data, null)

        fun <T> error(message: String?, data: T?): Resources<T> = Resources(ERROR, data, message)

        fun <T> loading(data: T?): Resources<T> = Resources(LOADING, data, null)
    }
}