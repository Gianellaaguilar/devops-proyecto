package com.example.sistema_experto.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sistema_experto.data.models.Subcategoria
import com.example.sistema_experto.databinding.ItemSubcategoriaBinding

class SubcategoriaAdapter(
    private val onItemClick: (Subcategoria) -> Unit
) : ListAdapter<Subcategoria, SubcategoriaAdapter.SubcategoriaViewHolder>(SubcategoriaDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SubcategoriaViewHolder {
        val binding = ItemSubcategoriaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SubcategoriaViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: SubcategoriaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class SubcategoriaViewHolder(
        private val binding: ItemSubcategoriaBinding,
        private val onItemClick: (Subcategoria) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(subcategoria: Subcategoria) {
            binding.textNombre.text = subcategoria.nombre
            binding.textIcono.text = subcategoria.icono ?: "🔸"
            binding.root.setOnClickListener {
                onItemClick(subcategoria)
            }
        }
    }

    class SubcategoriaDiffCallback : DiffUtil.ItemCallback<Subcategoria>() {
        override fun areItemsTheSame(oldItem: Subcategoria, newItem: Subcategoria): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Subcategoria, newItem: Subcategoria): Boolean {
            return oldItem == newItem
        }
    }
}



