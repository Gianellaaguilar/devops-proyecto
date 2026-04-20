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
import com.example.sistema_experto.R
import com.example.sistema_experto.databinding.FragmentResultadoBinding
import com.example.sistema_experto.ui.viewmodel.DiagnosticoViewModel
import kotlinx.coroutines.launch
import androidx.lifecycle.Lifecycle

class ResultadoFragment : Fragment() {
    private var _binding: FragmentResultadoBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DiagnosticoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultadoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textTitulo.text = "Resultados del análisis"
        // El subtítulo se actualizará según si hay diagnóstico o no

        binding.buttonNuevoDiagnostico.setOnClickListener {
            viewModel.resetear()
            findNavController().navigate(R.id.action_resultadoFragment_to_categoriaFragment)
        }

        binding.buttonVolverInicio.setOnClickListener {
            viewModel.resetear()
            findNavController().popBackStack(R.id.categoriaFragment, false)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.diagnosticoResultado.collect { resultado ->
                    resultado?.let {
                        mostrarResultado(it)
                    } ?: run {
                        mostrarSinCoincidencias()
                    }
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

        // Observar errores para mostrarlos al usuario
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.error.collect { mensajeError ->
                    if (mensajeError != null && !viewModel.loading.value) {
                        // Si hay un error y no hay diagnóstico, mostrar mensaje de error
                        if (viewModel.diagnosticoResultado.value == null) {
                            mostrarError(mensajeError)
                        }
                    }
                }
            }
        }

        // Si no hay resultado, intentar obtenerlo
        if (viewModel.diagnosticoResultado.value == null && viewModel.sintomasSeleccionados.isNotEmpty()) {
            viewModel.obtenerDiagnostico()
        }
    }

    private fun mostrarResultado(resultado: com.example.sistema_experto.data.models.DiagnosticoResultado) {
        binding.textSubtitulo.text = "Según tus síntomas, es muy probable que tengas:"
        binding.textEnfermedad.text = "🧠 ${resultado.enfermedad.nombre}"

        val sintomasTexto = resultado.sintomasSeleccionados.joinToString("\n") { "– ${it.nombre}" }
        binding.textSintomasSeleccionados.text = "📝 Síntomas seleccionados:\n$sintomasTexto"

        val recomendacionesTexto = if (resultado.recomendaciones.isNotEmpty()) {
            resultado.recomendaciones.joinToString("\n") { "• ${it.descripcion}" }
        } else {
            "No hay recomendaciones específicas disponibles para esta enfermedad."
        }
        binding.textRecomendaciones.text = "🩺 Recomendaciones de cuidado:\n$recomendacionesTexto"
        
        // Mostrar la advertencia solo cuando hay diagnóstico válido
        binding.cardAdvertencia.visibility = View.VISIBLE
    }

    private fun mostrarSinCoincidencias() {
        binding.textSubtitulo.text = "No se encontró una coincidencia específica:"
        binding.textEnfermedad.text = "❓ No se encontró un diagnóstico específico"
        
        // Obtener los nombres de los síntomas seleccionados
        viewLifecycleOwner.lifecycleScope.launch {
            val supabaseService = com.example.sistema_experto.data.SupabaseService()
            val sintomas = supabaseService.obtenerSintomasPorIds(viewModel.sintomasSeleccionados.toList())
            
            val sintomasTexto = if (sintomas.isNotEmpty()) {
                sintomas.joinToString("\n") { "– ${it.nombre}" }
            } else {
                "No se pudieron cargar los nombres de los síntomas seleccionados."
            }
            
            binding.textSintomasSeleccionados.text = 
                "📝 Síntomas seleccionados:\n$sintomasTexto"
        }

        binding.textRecomendaciones.text = 
            "💡 Recomendaciones generales:\n" +
            "• Los síntomas que seleccionaste no coinciden completamente con ninguna enfermedad en nuestra base de datos.\n" +
            "• Te recomendamos consultar con un profesional de la salud para una evaluación más precisa.\n" +
            "• Si los síntomas persisten o empeoran, busca atención médica inmediata.\n" +
            "• Intenta ser más específico al seleccionar tus síntomas o consulta otras categorías."
        
        // Ocultar la advertencia cuando no hay diagnóstico
        binding.cardAdvertencia.visibility = View.GONE
    }

    private fun mostrarError(mensajeError: String) {
        binding.textSubtitulo.text = "Error al obtener el diagnóstico:"
        binding.textEnfermedad.text = "⚠️ Error"
        
        binding.textSintomasSeleccionados.text = 
            "📝 Síntomas seleccionados:\n" +
            "Se seleccionaron ${viewModel.sintomasSeleccionados.size} síntoma(s) para el análisis."

        binding.textRecomendaciones.text = 
            "❌ Error:\n$mensajeError\n\n" +
            "💡 Por favor, intenta nuevamente o verifica tu conexión a internet."
        
        // Ocultar la advertencia cuando hay error
        binding.cardAdvertencia.visibility = View.GONE
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

