package dev.luizfelipe.androidcore_digitalhouse.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.luizfelipe.androidcore_digitalhouse.R

class PratoAdapter(private val context: Context, private val listPratos: List<Prato>, private val pratoClickListener: PratoClickListener): RecyclerView.Adapter<PratoAdapter.PratoViewHolder>(){

    class PratoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.findViewById(R.id.imgPrato)
        val title: TextView = itemView.findViewById(R.id.textPrato)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PratoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_prato, parent, false)
        return PratoViewHolder(view)
    }

    override fun onBindViewHolder(holder: PratoViewHolder, position: Int) {
        holder.title.text = listPratos[position].nome
        holder.image.setImageResource(listPratos[position].img)

        holder.itemView.setOnClickListener(pratoClickListener.onPratoClickListener(listPratos[position]))
    }

    override fun getItemCount(): Int = listPratos.size
}