package dev.luizfelipe.androidcore_digitalhouse.data

import java.io.Serializable

data class Restaurante(
        val nome: String,
        val endereco: String,
        val horario: String,
        val img: Int,
        val pratos: List<Prato>
): Serializable