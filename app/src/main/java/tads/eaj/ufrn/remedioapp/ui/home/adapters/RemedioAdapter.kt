package tads.eaj.ufrn.remedioapp.ui.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import tads.eaj.ufrn.remedioapp.databinding.RemedioItemListBinding
import tads.eaj.ufrn.remedioapp.model.Remedio

class RemedioAdapter : ListAdapter<Remedio, RemedioAdapter.RemedioViewHolder>(RemedioDiffUtilCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RemedioViewHolder {
        return RemedioViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: RemedioViewHolder, position: Int) {
        val remedio = getItem(position)
        holder.bind(remedio)
    }

    class RemedioViewHolder private constructor(var binding: RemedioItemListBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(remedio: Remedio) {
            binding.textViewNomeRemedio.text = remedio.nome
            binding.textViewDosagemRemedio.text = remedio.dosagem.toString()

            binding.textViewNomeRemedio.setOnClickListener {
                Toast.makeText(binding.root.context, "CLicou no texto", Toast.LENGTH_SHORT).show()
            }
        }

        companion object {
            fun from(parent: ViewGroup): RemedioViewHolder {

                val inflater = LayoutInflater.from(parent.context)
                val binding = RemedioItemListBinding.inflate(inflater, parent, false)
                return RemedioViewHolder(binding)
            }
        }
    }

    class RemedioDiffUtilCallback : DiffUtil.ItemCallback<Remedio>(){
        override fun areItemsTheSame(oldItem: Remedio, newItem: Remedio): Boolean {
            return oldItem.id.equals(newItem.id)
        }

        override fun areContentsTheSame(oldItem: Remedio, newItem: Remedio): Boolean {
            return oldItem.equals(newItem)
        }

    }
}


/*
class RemedioAdapter : RecyclerView.Adapter<RemedioAdapter.RemedioViewHolder>() {

    var remedios:List<Remedio> = ArrayList<Remedio>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RemedioViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.remedio_item_list, parent, false)
        return RemedioViewHolder(view)
    }

    override fun onBindViewHolder(holder: RemedioViewHolder, position: Int) {
        holder.textViewNomeRemedio.text = remedios[position].nome
        holder.textViewDosagemRemedio.text = remedios[position].dosagem.toString()
    }

    override fun getItemCount(): Int {
        return remedios.size
    }

    class RemedioViewHolder(v: View) : RecyclerView.ViewHolder(v){
        var textViewNomeRemedio = v.findViewById<TextView>(R.id.textViewNomeRemedio)
        var textViewDosagemRemedio = v.findViewById<TextView>(R.id.textViewDosagemRemedio)
    }
}

 */