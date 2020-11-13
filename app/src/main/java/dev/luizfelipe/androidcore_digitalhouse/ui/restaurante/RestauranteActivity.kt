package dev.luizfelipe.androidcore_digitalhouse.ui.restaurante

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.luizfelipe.androidcore_digitalhouse.R
import dev.luizfelipe.androidcore_digitalhouse.data.Prato
import dev.luizfelipe.androidcore_digitalhouse.data.PratoClickListener
import dev.luizfelipe.androidcore_digitalhouse.data.Restaurante
import dev.luizfelipe.androidcore_digitalhouse.data.PratoAdapter
import dev.luizfelipe.androidcore_digitalhouse.ui.restaurante.prato.PratoActivity

class RestauranteActivity : AppCompatActivity(), PratoClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante)

        val restaurante = intent.getSerializableExtra("data") as Restaurante

        val titleRestTxt: TextView = findViewById(R.id.titlePratoTxt)
        val imgRest: ImageView = findViewById(R.id.pratoImg)
        val backBtn: ImageView = findViewById(R.id.backBtn)
        val recyclerPrato: RecyclerView = findViewById(R.id.recyclerPrato)
        val pratoAdapter = PratoAdapter(this, restaurante.pratos, this)

        recyclerPrato.layoutManager = GridLayoutManager(this, 2)
        recyclerPrato.adapter = pratoAdapter

        titleRestTxt.text = restaurante.nome
        imgRest.setImageResource(restaurante.img)

        backBtn.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }
    }

    override fun onPratoClickListener(item: Prato): View.OnClickListener =
        View.OnClickListener { v ->
            val intent = Intent(v?.context, PratoActivity::class.java)
            intent.putExtra("data", item)
            startActivity(intent)
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left)
        }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}