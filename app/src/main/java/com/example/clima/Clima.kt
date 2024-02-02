package com.example.clima

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class Clima : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clima)
        /*Estados:
            Soleado > 30°
            Nublado 10° a 20°
            Luvioso < 10°
         */
        val ciudad = intent.getStringExtra("ciudad")
        ciudad?.let { actualizarInterfaz(it) }

        val btnRegresar: ImageView = findViewById(R.id.btnRegresar)
        btnRegresar.setOnClickListener { finish() }
    }

    private fun actualizarInterfaz(ciudad: String) {
        val tvCiudad: TextView = findViewById(R.id.tvCiudad)
        tvCiudad.text = ciudad

        // Genera un número aleatorio en el rango específico
        val temperatura = Random.nextInt(101)

        // Actualiza la interfaz con la temperatura
        val tvClimaNumero: TextView = findViewById(R.id.tvClimaNumero)
        tvClimaNumero.text = "$temperatura°"

        // Determina el estado según la temperatura
        val estado: String = when {
            temperatura > 30 -> {
                // Actualiza el icono
                val imgClima: ImageView = findViewById(R.id.imgClima)
                imgClima.setImageResource(R.drawable.soleado)
                "Soleado"
            }
            temperatura in 10..20 -> {
                // Actualiza el icono
                val imgClima: ImageView = findViewById(R.id.imgClima)
                imgClima.setImageResource(R.drawable.nublado)
                "Nublado"
            }
            else -> {
                // Actualiza el icono
                val imgClima: ImageView = findViewById(R.id.imgClima)
                imgClima.setImageResource(R.drawable.lluvia)
                "Lluvioso"
            }
        }

        // Actualiza la interfaz con el estado
        val tvClimaEstado: TextView = findViewById(R.id.tvClimaEstado)
        tvClimaEstado.text = estado

        // Actualiza la bandera de la ciudad
        val imgBandera: ImageView = findViewById(R.id.imgBandera)
        when (ciudad) {
            "Cuenca" -> imgBandera.setImageResource(R.drawable.cuenca)
            "Azoges" -> imgBandera.setImageResource(R.drawable.azoges)
            "Guayaquil" -> imgBandera.setImageResource(R.drawable.guayaquil)
            "Quito" -> imgBandera.setImageResource(R.drawable.quito)
            "Riobamba" -> imgBandera.setImageResource(R.drawable.riobamba)
        }
    }
}