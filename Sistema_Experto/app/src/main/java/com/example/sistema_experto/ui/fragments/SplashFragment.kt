package com.example.sistema_experto.ui.fragments

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.sistema_experto.R
import com.example.sistema_experto.databinding.FragmentSplashBinding
import com.example.sistema_experto.ui.viewmodel.DiagnosticoViewModel
import androidx.lifecycle.Lifecycle
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay

class SplashFragment : Fragment() {
    private var _binding: FragmentSplashBinding? = null
    private val binding get() = _binding!!
    private val viewModel: DiagnosticoViewModel by activityViewModels()
    private var navegacionRealizada = false
    private var cargaCompletada = false
    private val tiempoMinimoVisualizacion = 6000L // 6 segundos mínimo
    private var porcentajeActual = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplashBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Configurar textos de bienvenida
        binding.textTituloBienvenida.text = "Bienvenido"
        binding.textSubtituloBienvenida.text = "Sistema Experto de Diagnóstico de Enfermedades Básicas"
        binding.textCargando.text = "Inicializando sistema..."
        binding.textPorcentaje.text = "0%"

        // Configurar progress bars
        binding.progressBarCircular.max = 100
        binding.progressBarCircular.progress = 0
        binding.progressBarLineal.max = 100
        binding.progressBarLineal.progress = 0

        // Inicialmente ocultar elementos para animarlos
        binding.cardIcono.alpha = 0f
        binding.textTituloBienvenida.alpha = 0f
        binding.textSubtituloBienvenida.alpha = 0f
        binding.frameProgress.alpha = 0f
        binding.textCargando.alpha = 0f
        binding.progressBarLineal.alpha = 0f

        // Animar entrada de elementos
        animarEntrada()

        // Iniciar simulación de progreso
        iniciarProgreso()

        // Cambiar mensajes de carga periódicamente
        cambiarMensajesCarga()

        // Guardar el tiempo de inicio
        val tiempoInicio = System.currentTimeMillis()

        // Iniciar carga de categorías
        viewModel.cargarCategorias()

        // Observar el estado de carga
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.loading.collect { isLoading ->
                    // Cuando termine de cargar, completar el progreso
                    if (!isLoading) {
                        completarProgreso()
                        cargaCompletada = true
                        verificarYNavigar(tiempoInicio)
                    }
                }
            }
        }

        // Observar errores (aún así consideramos la carga como "completada")
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.error.collect { error ->
                    if (error != null) {
                        completarProgreso()
                        cargaCompletada = true
                        verificarYNavigar(tiempoInicio)
                    }
                }
            }
        }

        // Verificar si ya hay categorías cargadas (por si vuelve a este fragmento)
        if (viewModel.categorias.value.isNotEmpty()) {
            completarProgreso()
            cargaCompletada = true
            verificarYNavigar(tiempoInicio)
        }

        // Asegurar tiempo mínimo de visualización
        viewLifecycleOwner.lifecycleScope.launch {
            delay(tiempoMinimoVisualizacion)
            if (cargaCompletada) {
                verificarYNavigar(tiempoInicio)
            }
        }
    }

    private fun iniciarProgreso() {
        viewLifecycleOwner.lifecycleScope.launch {
            // Simular progreso gradual hasta 85% (más lento)
            // Dividir en etapas para que se sienta más realista
            while (porcentajeActual < 85 && !cargaCompletada) {
                delay(80) // Más lento: actualizar cada 80ms
                
                // Progreso más lento al inicio, más rápido en el medio
                val incremento = when {
                    porcentajeActual < 30 -> 1 // Muy lento al inicio (0-30%)
                    porcentajeActual < 60 -> 2 // Medio (30-60%)
                    else -> 1 // Lento al final (60-85%)
                }
                
                porcentajeActual += incremento
                if (porcentajeActual > 85) porcentajeActual = 85
                
                binding.progressBarCircular.progress = porcentajeActual
                binding.progressBarLineal.progress = porcentajeActual
                binding.textPorcentaje.text = "$porcentajeActual%"
            }
        }
    }

    private fun completarProgreso() {
        viewLifecycleOwner.lifecycleScope.launch {
            // Completar de 85% a 100% con animación suave y más lenta
            while (porcentajeActual < 100) {
                delay(60) // Más lento para el final
                porcentajeActual += 1 // Incrementos más pequeños
                if (porcentajeActual > 100) porcentajeActual = 100
                
                binding.progressBarCircular.progress = porcentajeActual
                binding.progressBarLineal.progress = porcentajeActual
                binding.textPorcentaje.text = "$porcentajeActual%"
            }
        }
    }

    private fun verificarYNavigar(tiempoInicio: Long) {
        if (navegacionRealizada) return

        val tiempoTranscurrido = System.currentTimeMillis() - tiempoInicio
        val tiempoRestante = tiempoMinimoVisualizacion - tiempoTranscurrido

        if (cargaCompletada && tiempoTranscurrido >= tiempoMinimoVisualizacion) {
            // Ya pasó el tiempo mínimo y la carga está completa
            navegacionRealizada = true
            navegarACategorias()
        } else if (cargaCompletada && tiempoRestante > 0) {
            // La carga terminó pero aún falta tiempo mínimo
            viewLifecycleOwner.lifecycleScope.launch {
                delay(tiempoRestante)
                if (!navegacionRealizada) {
                    navegacionRealizada = true
                    navegarACategorias()
                }
            }
        }
    }

    private fun animarEntrada() {
        // Animación del card del icono (fade in + scale)
        val cardFadeIn = ObjectAnimator.ofFloat(binding.cardIcono, "alpha", 0f, 1f)
        cardFadeIn.duration = 800
        val cardScaleX = ObjectAnimator.ofFloat(binding.cardIcono, "scaleX", 0.5f, 1f)
        cardScaleX.duration = 800
        val cardScaleY = ObjectAnimator.ofFloat(binding.cardIcono, "scaleY", 0.5f, 1f)
        cardScaleY.duration = 800

        val cardAnimSet = AnimatorSet()
        cardAnimSet.playTogether(cardFadeIn, cardScaleX, cardScaleY)
        cardAnimSet.startDelay = 200

        // Animación del título
        val tituloFadeIn = ObjectAnimator.ofFloat(binding.textTituloBienvenida, "alpha", 0f, 1f)
        tituloFadeIn.duration = 600
        val tituloTranslateY = ObjectAnimator.ofFloat(binding.textTituloBienvenida, "translationY", 30f, 0f)
        tituloTranslateY.duration = 600

        val tituloAnimSet = AnimatorSet()
        tituloAnimSet.playTogether(tituloFadeIn, tituloTranslateY)
        tituloAnimSet.startDelay = 600

        // Animación del subtítulo
        val subtituloFadeIn = ObjectAnimator.ofFloat(binding.textSubtituloBienvenida, "alpha", 0f, 1f)
        subtituloFadeIn.duration = 600
        subtituloFadeIn.startDelay = 1000

        // Animación del progress y texto de carga
        val progressFadeIn = ObjectAnimator.ofFloat(binding.frameProgress, "alpha", 0f, 1f)
        progressFadeIn.duration = 500
        val progressScale = ObjectAnimator.ofFloat(binding.frameProgress, "scaleX", 0.8f, 1f)
        progressScale.duration = 500
        val progressScaleY = ObjectAnimator.ofFloat(binding.frameProgress, "scaleY", 0.8f, 1f)
        progressScaleY.duration = 500
        
        val textoFadeIn = ObjectAnimator.ofFloat(binding.textCargando, "alpha", 0f, 1f)
        textoFadeIn.duration = 500
        val barraFadeIn = ObjectAnimator.ofFloat(binding.progressBarLineal, "alpha", 0f, 1f)
        barraFadeIn.duration = 500

        val cargaAnimSet = AnimatorSet()
        cargaAnimSet.playTogether(progressFadeIn, progressScale, progressScaleY, textoFadeIn, barraFadeIn)
        cargaAnimSet.startDelay = 1400

        // Ejecutar todas las animaciones
        cardAnimSet.start()
        tituloAnimSet.start()
        subtituloFadeIn.start()
        cargaAnimSet.start()

        // Animación de pulso para el icono
        animarPulsoIcono()
    }

    private fun animarPulsoIcono() {
        val pulseX = ObjectAnimator.ofFloat(binding.cardIcono, "scaleX", 1f, 1.05f, 1f)
        pulseX.duration = 2000
        pulseX.repeatCount = Animation.INFINITE
        pulseX.repeatMode = ObjectAnimator.REVERSE

        val pulseY = ObjectAnimator.ofFloat(binding.cardIcono, "scaleY", 1f, 1.05f, 1f)
        pulseY.duration = 2000
        pulseY.repeatCount = Animation.INFINITE
        pulseY.repeatMode = ObjectAnimator.REVERSE

        val pulseSet = AnimatorSet()
        pulseSet.playTogether(pulseX, pulseY)
        pulseSet.interpolator = AccelerateDecelerateInterpolator()
        pulseSet.startDelay = 2000
        pulseSet.start()
    }

    private fun cambiarMensajesCarga() {
        val mensajes = listOf(
            "Inicializando sistema...",
            "Conectando con base de datos...",
            "Cargando datos médicos...",
            "Procesando información...",
            "Preparando diagnóstico...",
            "Verificando conexión...",
            "Casi listo..."
        )

        var indiceMensaje = 0
        viewLifecycleOwner.lifecycleScope.launch {
            while (!navegacionRealizada && indiceMensaje < mensajes.size) {
                delay(1200) // Cambiar cada 1.2 segundos
                if (!navegacionRealizada && indiceMensaje < mensajes.size) {
                    binding.textCargando.text = mensajes[indiceMensaje]
                    indiceMensaje++
                }
            }
        }
    }

    private fun navegarACategorias() {
        if (findNavController().currentDestination?.id == R.id.splashFragment) {
            // Animación de salida (fade out)
            val fadeOut = AlphaAnimation(1f, 0f)
            fadeOut.duration = 500
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}
                override fun onAnimationRepeat(animation: Animation?) {}
                override fun onAnimationEnd(animation: Animation?) {
                    findNavController().navigate(R.id.action_splashFragment_to_expertosFragment)
                }
            })
            binding.root.startAnimation(fadeOut)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
