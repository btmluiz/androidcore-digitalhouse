package dev.luizfelipe.androidcore_digitalhouse.data

import java.io.Serializable

data class Prato(
        val nome: String,
        val descricao: String,
        val img: Int
): Serializable