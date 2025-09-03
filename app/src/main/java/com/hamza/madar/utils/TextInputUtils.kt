package com.hamza.madar.utils

import com.google.android.material.textfield.TextInputLayout

object TextInputUtils {

    fun TextInputLayout.validate(text: String, errorMsg: String): Boolean {
        return if (text.isBlank()) {
            error = errorMsg
            false
        } else {
            error = null
            true
        }
    }




}