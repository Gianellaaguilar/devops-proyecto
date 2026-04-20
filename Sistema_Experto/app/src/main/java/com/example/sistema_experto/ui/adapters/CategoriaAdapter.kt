package com.example.sistema_experto.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sistema_experto.data.models.Categoria
import com.example.sistema_experto.databinding.ItemCategoriaBinding

class CategoriaAdapter(
    private val onItemClick: (Categoria) -> Unit
) : ListAdapter<Categoria, CategoriaAdapter.CategoriaViewHolder>(CategoriaDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriaViewHolder {
        val binding = ItemCategoriaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CategoriaViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: CategoriaViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class CategoriaViewHolder(
        private val binding: ItemCategoriaBinding,
        private val onItemClick: (Categoria) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(categoria: Categoria) {
            binding.textNombre.text = categoria.nombre
            binding.textIcono.text = categoria.icono ?: getDefaultIcon(categoria.nombre)
            binding.root.setOnClickListener {
                onItemClick(categoria)
            }
        }

        private fun getDefaultIcon(nombre: String): String {
            return when {
                nombre.contains("Respiratorio", ignoreCase = true) -> "🫁" // Pulmones
                nombre.contains("Gastrointestinal", ignoreCase = true) -> "🫄" // Estómago/abdomen
                nombre.contains("Metabólico", ignoreCase = true) -> "⚡" // Energía/metabolismo
                nombre.contains("Dermatológico", ignoreCase = true) -> "🩹" // Piel/curación
                nombre.contains("Neurológico", ignoreCase = true) -> "🧠" // Cerebro
                nombre.contains("Musculoesquelético", ignoreCase = true) -> "💪" // Músculos
                nombre.contains("General", ignoreCase = true) -> "⚕️" // Símbolo médico general
                nombre.contains("Oftalmológico", ignoreCase = true) -> "👁️" // Ojo
                nombre.contains("Otorrinolaringológico", ignoreCase = true) -> "👂" // Oído
                else -> "🏥" // Hospital por defecto
            }
        }
    }

    class CategoriaDiffCallback : DiffUtil.ItemCallback<Categoria>() {
        override fun areItemsTheSame(oldItem: Categoria, newItem: Categoria): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Categoria, newItem: Categoria): Boolean {
            return oldItem == newItem
        }
    }
}


