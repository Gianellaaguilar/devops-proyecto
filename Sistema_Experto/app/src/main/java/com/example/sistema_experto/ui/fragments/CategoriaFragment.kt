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
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sistema_experto.R
import com.example.sistema_experto.databinding.FragmentCategoriaBinding
import com.example.sistema_experto.ui.adapters.CategoriaAdapter
import com.example.sistema_experto.ui.viewmodel.DiagnosticoViewModel
import kotlinx.coroutines.launch
import androidx.lifecycle.Lifecycle

class CategoriaFragment : Fragment() {
    private var _binding: FragmentCategoriaBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DiagnosticoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCategoriaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textTitulo.text = "¿Qué tipo de malestar estás experimentando?"
        binding.textSubtitulo.text = "Selecciona una categoría para continuar"

        val adapter = CategoriaAdapter { categoria ->
            viewModel.categoriaSeleccionada = categoria
            viewModel.cargarSubcategorias(categoria.nombre)
            findNavController().navigate(R.id.action_categoriaFragment_to_subcategoriaFragment)
        }

        binding.recyclerViewCategorias.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerViewCategorias.adapter = adapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.categorias.collect { categorias ->
                    adapter.submitList(categorias)
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

        // Observar errores
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.error.collect { error ->
                    if (error != null) {
                        android.util.Log.e("CategoriaFragment", "⚠️ Error: $error")
                        // El error se maneja en el ViewModel, no crasheamos la app
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

