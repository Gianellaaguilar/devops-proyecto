package com.example.sistema_experto.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sistema_experto.R
import com.example.sistema_experto.databinding.FragmentSubcategoriaBinding
import com.example.sistema_experto.ui.adapters.SubcategoriaAdapter
import com.example.sistema_experto.ui.viewmodel.DiagnosticoViewModel
import kotlinx.coroutines.launch
import androidx.lifecycle.Lifecycle

class SubcategoriaFragment : Fragment() {
    private var _binding: FragmentSubcategoriaBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DiagnosticoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSubcategoriaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val categoria = viewModel.categoriaSeleccionada
        binding.textTitulo.text = when {
            categoria?.nombre?.contains("Respiratorio", ignoreCase = true) == true ->
                "Elige el tipo de molestia respiratoria"
            categoria?.nombre?.contains("Gastrointestinal", ignoreCase = true) == true ->
                "¿Qué tipo de molestia digestiva tienes?"
            else -> "Elige el tipo de molestia"
        }

        val adapter = SubcategoriaAdapter { subcategoria ->
            viewModel.subcategoriaSeleccionada = subcategoria
            viewModel.cargarSintomas(subcategoria.nombre)
            findNavController().navigate(R.id.action_subcategoriaFragment_to_sintomaFragment)
        }

        binding.recyclerViewSubcategorias.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewSubcategorias.adapter = adapter

        binding.buttonVolver.setOnClickListener {
            findNavController().navigateUp()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.subcategorias.collect { subcategorias ->
                    adapter.submitList(subcategorias)
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.loading.collect { isLoading ->
                    binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
                }
            }
        }

        // Cargar subcategorías si aún no están cargadas
        categoria?.let {
            if (viewModel.subcategorias.value.isEmpty()) {
                viewModel.cargarSubcategorias(it.nombre)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

