package com.example.sistema_experto.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sistema_experto.data.models.Experto
import com.example.sistema_experto.databinding.ItemExpertoBinding

class ExpertoAdapter : ListAdapter<Experto, ExpertoAdapter.ExpertoViewHolder>(ExpertoDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpertoViewHolder {
        val binding = ItemExpertoBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ExpertoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExpertoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class ExpertoViewHolder(
        private val binding: ItemExpertoBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(experto: Experto) {
            binding.textNombre.text = experto.nombre
            binding.textEspecialidad.text = experto.especialidad
            binding.textPais.text = experto.pais
            binding.textBandera.text = getBandera(experto.pais)
            
            // Cargar la imagen del doctor
            binding.imageDoctor.setImageResource(experto.imagenResId)
        }

        private fun getBandera(pais: String): String {
            return when {
                pais.contains("Italia", ignoreCase = true) -> "🇮🇹"
                pais.contains("India", ignoreCase = true) -> "🇮🇳"
                pais.contains("España", ignoreCase = true) -> "🇪🇸"
                pais.contains("USA", ignoreCase = true) || 
                pais.contains("EE.UU", ignoreCase = true) || 
                pais.contains("Estados Unidos", ignoreCase = true) -> "🇺🇸"
                else -> "🌍"
            }
        }
    }

    class ExpertoDiffCallback : DiffUtil.ItemCallback<Experto>() {
        override fun areItemsTheSame(oldItem: Experto, newItem: Experto): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Experto, newItem: Experto): Boolean {
            return oldItem == newItem
        }
    }
}
