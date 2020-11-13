package dev.luizfelipe.androidcore_digitalhouse.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dev.luizfelipe.androidcore_digitalhouse.R

class RestauranteAdapter(private val context: Context, private val restauranteList: List<Restaurante>, private val restauranteClickListener: RestauranteClickListener): RecyclerView.Adapter<RestauranteAdapter.CardapioViewHolder>() {

    class CardapioViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardapioViewHolder {
        val page =LayoutInflater.from(parent.context)
                .inflate(R.layout.item_restaurante, parent, false)
        return CardapioViewHolder(page)
    }

    override fun getItemCount(): Int = restauranteList.size

    override fun onBindViewHolder(holder: CardapioViewHolder, position: Int) {
        val img: ImageView = holder.itemView.findViewById(R.id.img)
        val titleTxt: TextView = holder.itemView.findViewById(R.id.titleTxt)
        val endTxt: TextView = holder.itemView.findViewById(R.id.endTxt)
        val hourTxt: TextView = holder.itemView.findViewById(R.id.hourTxt)

        img.setImageResource(restauranteList[position].img)
        titleTxt.text = restauranteList[position].nome
        endTxt.text = restauranteList[position].endereco
        hourTxt.text = restauranteList[position].horario

        holder.itemView.setOnClickListener(restauranteClickListener.onRestauranteClickListener(restauranteList[position]))
    }
}