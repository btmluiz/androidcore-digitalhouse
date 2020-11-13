package dev.luizfelipe.androidcore_digitalhouse.ui.restaurante.prato

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import dev.luizfelipe.androidcore_digitalhouse.R
import dev.luizfelipe.androidcore_digitalhouse.data.Prato

class PratoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prato)

        val prato = intent.getSerializableExtra("data") as Prato
        val title: TextView = findViewById(R.id.titlePratoTxt)
        val img: ImageView = findViewById(R.id.pratoImg)
        val descricao: TextView = findViewById(R.id.descricaoTxt)
        val backBtn: ImageView = findViewById(R.id.backBtn)

        backBtn.setOnClickListener {
            finish()
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
        }

        title.text = prato.nome
        img.setImageResource(prato.img)
        descricao.text = prato.descricao
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }
}