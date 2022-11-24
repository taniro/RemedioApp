package tads.eaj.ufrn.remedioapp.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import tads.eaj.ufrn.remedioapp.databinding.RemedioListItemBinding
import tads.eaj.ufrn.remedioapp.model.Remedio

class RemedioAdapter: ListAdapter<Remedio, RemedioAdapter.RemedioViewHolder> (RemedioDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RemedioViewHolder {
        return RemedioViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RemedioViewHolder, position: Int) {
        val remedio = getItem(position)
        holder.bind(remedio)
    }


    class RemedioViewHolder private constructor(var binding: RemedioListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(remedio: Remedio) {
            binding.textViewNome.text = remedio.nome
            binding.textViewDosagem.text = remedio.dosagem.toString()
        }

        companion object {
            fun from(parent: ViewGroup): RemedioViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = RemedioListItemBinding.inflate(inflater, parent, false)
                return RemedioViewHolder(binding)
            }
        }
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