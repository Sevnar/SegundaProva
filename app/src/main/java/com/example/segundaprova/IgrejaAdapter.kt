package com.example.segundaprova

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class IgrejaAdapter():RecyclerView.Adapter<IgrejaViewHolder>() {



    lateinit var igrejas:List<Igreja>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IgrejaViewHolder {
        val inf = LayoutInflater.from(parent.context).inflate(R.layout.igreja_inflater, parent,false)
        val holder = IgrejaViewHolder(inf)

        return holder
    }

    override fun onBindViewHolder(holder: IgrejaViewHolder, position: Int) {
        val igrejaEscolhida = igrejas.get(position)
        holder.nomeTextView.text = igrejaEscolhida.nome
        holder.entidadeTextView.text = igrejaEscolhida.entidade

    }

    override fun getItemCount(): Int {
        return igrejas.size
    }


}

class IgrejaViewHolder(v:View):RecyclerView.ViewHolder(v){
    val nomeTextView = v.findViewById<TextView>(R.id.nomeTextView)
    val entidadeTextView = v.findViewById<TextView>(R.id.entidadeTextView)
}