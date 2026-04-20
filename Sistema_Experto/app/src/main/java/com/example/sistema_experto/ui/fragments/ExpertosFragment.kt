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
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sistema_experto.R
import com.example.sistema_experto.data.models.Experto
import com.example.sistema_experto.databinding.FragmentExpertosBinding
import com.example.sistema_experto.ui.adapters.ExpertoAdapter

class ExpertosFragment : Fragment() {
    private var _binding: FragmentExpertosBinding? = null
    private val binding get() = _binding!!
    private lateinit var expertoAdapter: ExpertoAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExpertosBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView()
        cargarExpertos()
        setupListeners()
        animarEntrada()
    }

    private fun setupRecyclerView() {
        expertoAdapter = ExpertoAdapter()
        binding.recyclerViewExpertos.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = expertoAdapter
        }
    }

    private fun cargarExpertos() {
        val expertos = listOf(
            Experto(
                id = 1,
                nombre = "Dr. Giovanni Gasbarrini",
                especialidad = "Gastroenterología",
                pais = "Italia",
                imagenResId = R.drawable.doctor_gasbarrini
            ),
            Experto(
                id = 2,
                nombre = "Dr. Venkataram Mysore",
                especialidad = "Dermatología",
                pais = "India",
                imagenResId = R.drawable.doctor_mysore
            ),
            Experto(
                id = 3,
                nombre = "Dr. José Luis Álvarez-Sala Walther",
                especialidad = "Neumología",
                pais = "España",
                imagenResId = R.drawable.doctor_alvarez
            ),
            Experto(
                id = 4,
                nombre = "Dra. Mona M. Abaza",
                especialidad = "Otorrinolaringología",
                pais = "USA",
                imagenResId = R.drawable.doctor_abaza
            ),
            Experto(
                id = 5,
                nombre = "Dr. Santiago Giménez Roldán",
                especialidad = "Neurología",
                pais = "España",
                imagenResId = R.drawable.doctor_gimenez
            ),
            Experto(
                id = 6,
                nombre = "Dr. William A. Abdu",
                especialidad = "Musculoesquelético",
                pais = "EE.UU.",
                imagenResId = R.drawable.doctor_abdu
            ),
            Experto(
                id = 7,
                nombre = "Dr. Carlos Vergés Roger",
                especialidad = "Oftalmología",
                pais = "España",
                imagenResId = R.drawable.doctor_verges
            ),
            Experto(
                id = 8,
                nombre = "Dr. Silvio E. Inzucchi",
                especialidad = "Metabolismo",
                pais = "EE.UU.",
                imagenResId = R.drawable.doctor_inzucchi
            )
        )
        
        expertoAdapter.submitList(expertos)
        binding.textContador.text = "${expertos.size} expertos"
    }

    private fun setupListeners() {
        binding.buttonContinuar.setOnClickListener {
            navegarACategorias()
        }
    }

    private fun animarEntrada() {
        // Ocultar elementos inicialmente
        binding.cardHeaderIcon.alpha = 0f
        binding.textTitulo.alpha = 0f
        binding.textSubtitulo.alpha = 0f
        binding.cardExpertos.alpha = 0f
        binding.cardBoton.alpha = 0f

        // Animación del icono del header
        val iconFadeIn = ObjectAnimator.ofFloat(binding.cardHeaderIcon, "alpha", 0f, 1f)
        iconFadeIn.duration = 600
        val iconScale = ObjectAnimator.ofFloat(binding.cardHeaderIcon, "scaleX", 0.5f, 1f)
        iconScale.duration = 600
        val iconScaleY = ObjectAnimator.ofFloat(binding.cardHeaderIcon, "scaleY", 0.5f, 1f)
        iconScaleY.duration = 600

        val iconAnimSet = AnimatorSet()
        iconAnimSet.playTogether(iconFadeIn, iconScale, iconScaleY)
        iconAnimSet.startDelay = 100

        // Animación del título
        val tituloFadeIn = ObjectAnimator.ofFloat(binding.textTitulo, "alpha", 0f, 1f)
        tituloFadeIn.duration = 500
        val tituloTranslateY = ObjectAnimator.ofFloat(binding.textTitulo, "translationY", 20f, 0f)
        tituloTranslateY.duration = 500

        val tituloAnimSet = AnimatorSet()
        tituloAnimSet.playTogether(tituloFadeIn, tituloTranslateY)
        tituloAnimSet.startDelay = 300

        // Animación del subtítulo
        val subtituloFadeIn = ObjectAnimator.ofFloat(binding.textSubtitulo, "alpha", 0f, 1f)
        subtituloFadeIn.duration = 400
        subtituloFadeIn.startDelay = 500

        // Animación de la card de expertos
        val cardFadeIn = ObjectAnimator.ofFloat(binding.cardExpertos, "alpha", 0f, 1f)
        cardFadeIn.duration = 500
        val cardTranslateY = ObjectAnimator.ofFloat(binding.cardExpertos, "translationY", 50f, 0f)
        cardTranslateY.duration = 500

        val cardAnimSet = AnimatorSet()
        cardAnimSet.playTogether(cardFadeIn, cardTranslateY)
        cardAnimSet.startDelay = 600
        cardAnimSet.interpolator = AccelerateDecelerateInterpolator()

        // Animación del botón
        val botonFadeIn = ObjectAnimator.ofFloat(binding.cardBoton, "alpha", 0f, 1f)
        botonFadeIn.duration = 400
        val botonTranslateY = ObjectAnimator.ofFloat(binding.cardBoton, "translationY", 30f, 0f)
        botonTranslateY.duration = 400

        val botonAnimSet = AnimatorSet()
        botonAnimSet.playTogether(botonFadeIn, botonTranslateY)
        botonAnimSet.startDelay = 800

        // Ejecutar todas las animaciones
        iconAnimSet.start()
        tituloAnimSet.start()
        subtituloFadeIn.start()
        cardAnimSet.start()
        botonAnimSet.start()
    }

    private fun navegarACategorias() {
        if (findNavController().currentDestination?.id == R.id.expertosFragment) {
            // Animación de salida
            val fadeOut = AlphaAnimation(1f, 0f)
            fadeOut.duration = 300
            fadeOut.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation?) {}
                override fun onAnimationRepeat(animation: Animation?) {}
                override fun onAnimationEnd(animation: Animation?) {
                    findNavController().navigate(R.id.action_expertosFragment_to_categoriaFragment)
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
