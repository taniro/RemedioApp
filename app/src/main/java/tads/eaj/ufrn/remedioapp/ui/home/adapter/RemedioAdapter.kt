package tads.eaj.ufrn.remedioapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import tads.eaj.ufrn.remedioapp.R
import tads.eaj.ufrn.remedioapp.model.Remedio

class RemedioAdapter: ListAdapter<Remedio, RemedioAdapter.RemedioViewHolder> (RemedioDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RemedioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.remedio_list_item, parent, false)
        return RemedioViewHolder(view)
    }

    override fun onBindViewHolder(holder: RemedioViewHolder, position: Int) {
        holder.nomeTextView.text = currentList[position].nome
        holder.dosagemTextView.text = currentList[position].dosagem.toString()
    }


    class RemedioViewHolder(v:View): RecyclerView.ViewHolder(v) {
        var nomeTextView = v.findViewById<TextView>(R.id.textViewNome)
        var dosagemTextView = v.findViewById<TextView>(R.id.textViewDosagem)
    }
}

class RemedioDiffCallback : DiffUtil.ItemCallback<Remedio>() {
    override fun areItemsTheSame(oldItem: Remedio, newItem: Remedio): Boolean {
        return oldItem.id.equals(newItem.id)
    }

    override fun areContentsTheSame(oldItem: Remedio, newItem: Remedio): Boolean {
        return oldItem.equals(newItem)
    }
}