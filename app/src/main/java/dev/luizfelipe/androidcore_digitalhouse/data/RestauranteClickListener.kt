package dev.luizfelipe.androidcore_digitalhouse.data

import android.view.View

interface RestauranteClickListener {
    fun onRestauranteClickListener(item: Restaurante): View.OnClickListener
}