package dev.luizfelipe.androidcore_digitalhouse.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.luizfelipe.androidcore_digitalhouse.R
import dev.luizfelipe.androidcore_digitalhouse.data.Prato
import dev.luizfelipe.androidcore_digitalhouse.data.Restaurante
import dev.luizfelipe.androidcore_digitalhouse.data.RestauranteAdapter
import dev.luizfelipe.androidcore_digitalhouse.data.RestauranteClickListener
import dev.luizfelipe.androidcore_digitalhouse.ui.restaurante.RestauranteActivity

class MainActivity : AppCompatActivity(), RestauranteClickListener {

    private lateinit var listRestaurantes: List<Restaurante>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listRestaurantes = getCardapioList()
        val cardapioView: RecyclerView = findViewById(R.id.cardapioView)
        val cardapioAdapter = RestauranteAdapter(this, listRestaurantes, this)
        cardapioView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        cardapioView.adapter = cardapioAdapter
    }

    fun getCardapioList(): List<Restaurante> {
        return listOf(
            Restaurante(
                "Aoyama - Moema",
                "Alameda dos Arapanés, 532 - Moema",
                "Fecha às 00:00",
                R.drawable.image1,
                getPratosList()
            ),
            Restaurante(
                "Aoyama - Moema",
                "Alameda dos Arapanés, 532 - Moema",
                "Fecha às 00:00",
                R.drawable.image3,
                getPratosList()
            ),
            Restaurante(
                "Aoyama - Moema",
                "Alameda dos Arapanés, 532 - Moema",
                "Fecha às 00:00",
                R.drawable.image4,
                getPratosList()
            ),
        )
    }

    fun getPratosList(): List<Prato> {
        return listOf(
            Prato(
                "Teste",
                "teste2",
                R.drawable.image4
            ),
            Prato(
                "Teste",
                "teste2",
                R.drawable.image3
            ),
            Prato(
                "Teste",
                "teste2",
                R.drawable.image1
            ),
            Prato(
                "Teste",
                "teste2",
                R.drawable.image5
            ),
            Prato(
                "Teste",
                "teste2",
                R.drawable.image4
            ),
            Prato(
                "Teste",
                "teste2",
                R.drawable.image3
            ),
            Prato(
                "Teste",
                "teste2",
                R.drawable.image1
            ),
            Prato(
                "Teste",
                "teste2",
                R.drawable.image5
            ),
            Prato(
                "Teste",
                "teste2",
                R.drawable.image4
            ),
            Prato(
                "Teste",
                "teste2",
                R.drawable.image3
            ),
            Prato(
                "Teste",
                "teste2",
                R.drawable.image1
            ),
            Prato(
                "Teste",
                "teste2",
                R.drawable.image5
            ),
        )
    }

    override fun onRestauranteClickListener(item: Restaurante): View.OnClickListener =
        View.OnClickListener { v ->
            val intent = Intent(v?.context, RestauranteActivity::class.java)
            intent.putExtra("data", item)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}