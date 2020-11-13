package dev.luizfelipe.androidcore_digitalhouse.data

import android.view.View

interface PratoClickListener {
    fun onPratoClickListener(item: Prato): View.OnClickListener
}