package com.example.sistema_experto.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.sistema_experto.R
import com.example.sistema_experto.databinding.FragmentSintomaBinding
import com.example.sistema_experto.ui.adapters.SintomaAdapter
import com.example.sistema_experto.ui.viewmodel.DiagnosticoViewModel
import kotlinx.coroutines.launch
import androidx.lifecycle.Lifecycle

class SintomaFragment : Fragment() {
    private var _binding: FragmentSintomaBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DiagnosticoViewModel by activityViewModels()
    private var esperandoDiagnostico = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSintomaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Reiniciar el estado al crear la vista
        esperandoDiagnostico = false

        binding.textTitulo.text = "Selecciona los síntomas que estás presentando"
        binding.textSubtitulo.text = "Elige entre 3 y 5 para continuar"

        // Crear el adaptador con una referencia mutable para poder sincronizar después
        var adapter: SintomaAdapter? = null
        adapter = SintomaAdapter { sintomaId, isSelected ->
            if (isSelected) {
                viewModel.sintomasSeleccionados.add(sintomaId)
            } else {
                viewModel.sintomasSeleccionados.remove(sintomaId)
            }
            // Sincronizar el estado visual después de actualizar el ViewModel
            adapter?.setSelectedItems(viewModel.sintomasSeleccionados)
            actualizarBotonContinuar()
        }
        
        // Sincronizar el estado inicial de selección
        adapter.setSelectedItems(viewModel.sintomasSeleccionados)

        binding.recyclerViewSintomas.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerViewSintomas.adapter = adapter
        
        // Sincronizar el estado cuando se hace scroll para asegurar que las vistas recicladas muestren el estado correcto
        binding.recyclerViewSintomas.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                // Cuando se detiene el scroll, sincronizar el estado
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    adapter.setSelectedItems(viewModel.sintomasSeleccionados)
                }
            }
        })

        binding.buttonVolver.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.buttonContinuar.setOnClickListener {
            val cantidadSeleccionados = viewModel.sintomasSeleccionados.size
            if (cantidadSeleccionados < 3) {
                Toast.makeText(
                    requireContext(),
                    "Debes seleccionar al menos 3 síntomas para continuar.",
                    Toast.LENGTH_SHORT
                ).show()
            } else if (cantidadSeleccionados > 5) {
                Toast.makeText(
                    requireContext(),
                    "Por favor selecciona máximo 5 síntomas.",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                // Iniciar el proceso de diagnóstico
                esperandoDiagnostico = true
                viewModel.obtenerDiagnostico()
                // La navegación se realizará cuando el diagnóstico esté listo
                // (observado más abajo)
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.sintomas.collect { sintomas ->
                    adapter.submitList(sintomas)
                    // Sincronizar el estado de selección del ViewModel con el adaptador
                    adapter.setSelectedItems(viewModel.sintomasSeleccionados)
                    actualizarBotonContinuar()
                }
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.loading.collect { isLoading ->
                    binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
                    binding.buttonContinuar.isEnabled = !isLoading && viewModel.sintomasSeleccionados.size >= 3 && viewModel.sintomasSeleccionados.size <= 5
                    
                    // Si acabamos de terminar de cargar y estábamos esperando un diagnóstico,
                    // navegar al fragmento de resultados
                    if (!isLoading && esperandoDiagnostico) {
                        esperandoDiagnostico = false
                        // Navegar al fragmento de resultados (incluso si no hay coincidencias)
                        if (viewModel.sintomasSeleccionados.isNotEmpty()) {
                            findNavController().navigate(R.id.action_sintomaFragment_to_resultadoFragment)
                        }
                    }
                }
            }
        }

        // Observar errores para mostrar mensajes al usuario
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.error.collect { mensajeError ->
                    mensajeError?.let {
                        Toast.makeText(
                            requireContext(),
                            it,
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
            }
        }

        // Cargar síntomas si aún no están cargados
        viewModel.subcategoriaSeleccionada?.let {
            if (viewModel.sintomas.value.isEmpty()) {
                viewModel.cargarSintomas(it.nombre)
            }
        }
    }

    private fun actualizarBotonContinuar() {
        val cantidad = viewModel.sintomasSeleccionados.size
        binding.buttonContinuar.isEnabled = cantidad >= 3 && cantidad <= 5
        binding.textContador.text = "Seleccionados: $cantidad/5"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

