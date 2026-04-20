package com.example.sistema_experto.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.sistema_experto.data.models.Sintoma
import com.example.sistema_experto.databinding.ItemSintomaBinding

class SintomaAdapter(
    private val onItemClick: (String, Boolean) -> Unit
) : ListAdapter<Sintoma, SintomaAdapter.SintomaViewHolder>(SintomaDiffCallback()) {

    private val selectedItems = mutableSetOf<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SintomaViewHolder {
        val binding = ItemSintomaBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return SintomaViewHolder(binding, onItemClick)
    }

    override fun onBindViewHolder(holder: SintomaViewHolder, position: Int) {
        val sintoma = getItem(position)
        // Siempre consultar el estado actual del adaptador
        val isSelected = selectedItems.contains(sintoma.id)
        holder.bind(sintoma, isSelected)
    }
    
    override fun onBindViewHolder(holder: SintomaViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isNotEmpty()) {
            // Si hay payloads, solo actualizar la selección
            val sintoma = getItem(position)
            val isSelected = selectedItems.contains(sintoma.id)
            holder.updateSelection(isSelected)
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    fun setSelectedItems(items: Set<String>) {
        // Guardar el estado anterior para comparar
        val previousSelected = selectedItems.toSet()
        
        // Actualizar el set primero
        selectedItems.clear()
        selectedItems.addAll(items)
        
        // Verificar si hay cambios
        val hasChanges = previousSelected.size != items.size || 
                        previousSelected.any { !items.contains(it) } || 
                        items.any { !previousSelected.contains(it) }
        
        if (hasChanges) {
            // Encontrar los items que cambiaron de estado
            val changedPositions = mutableListOf<Int>()
            currentList.forEachIndexed { index, sintoma ->
                val wasSelected = previousSelected.contains(sintoma.id)
                val isSelected = items.contains(sintoma.id)
                if (wasSelected != isSelected) {
                    changedPositions.add(index)
                }
            }
            
            // Notificar cambios solo en los items afectados usando payload
            if (changedPositions.isNotEmpty()) {
                changedPositions.forEach { 
                    notifyItemChanged(it, "selection_changed")
                }
            } else {
                // Si no encontramos cambios específicos, actualizar todo (por seguridad)
                notifyDataSetChanged()
            }
        }
    }
    
    fun isSelected(sintomaId: String): Boolean {
        return selectedItems.contains(sintomaId)
    }

    class SintomaViewHolder(
        private val binding: ItemSintomaBinding,
        private val onItemClick: (String, Boolean) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        
        private var currentSintomaId: String? = null

        fun bind(sintoma: Sintoma, isSelected: Boolean) {
            currentSintomaId = sintoma.id
            binding.textNombre.text = sintoma.nombre
            binding.checkBoxSintoma.isChecked = isSelected

            // Remover listeners anteriores para evitar duplicados
            binding.root.setOnClickListener(null)
            binding.checkBoxSintoma.setOnClickListener(null)
            
            // Agregar nuevos listeners
            binding.root.setOnClickListener {
                val newState = !binding.checkBoxSintoma.isChecked
                binding.checkBoxSintoma.isChecked = newState
                onItemClick(sintoma.id, newState)
            }

            binding.checkBoxSintoma.setOnClickListener {
                onItemClick(sintoma.id, binding.checkBoxSintoma.isChecked)
            }
        }
        
        fun updateSelection(isSelected: Boolean) {
            binding.checkBoxSintoma.isChecked = isSelected
        }
    }

    class SintomaDiffCallback : DiffUtil.ItemCallback<Sintoma>() {
        override fun areItemsTheSame(oldItem: Sintoma, newItem: Sintoma): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Sintoma, newItem: Sintoma): Boolean {
            return oldItem == newItem
        }
    }
}

