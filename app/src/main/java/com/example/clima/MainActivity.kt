package com.example.clima

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Define un único OnClickListener para todos los botones
        val ciudadClickListener = View.OnClickListener { view ->
            // Determina qué botón fue presionado
            when (view.id) {
                R.id.btnCuenca -> abrirClimaActivity("Cuenca")
                R.id.btnAzoges -> abrirClimaActivity("Azoges")
                R.id.btnGuayaquil -> abrirClimaActivity("Guayaquil")
                R.id.btnQuito -> abrirClimaActivity("Quito")
                R.id.btnRiobamba -> abrirClimaActivity("Riobamba")
            }
        }

        val btnCuenca: Button = findViewById(R.id.btnCuenca)
        btnCuenca.setOnClickListener(ciudadClickListener)

        val btnAzoges: Button = findViewById(R.id.btnAzoges)
        btnAzoges.setOnClickListener(ciudadClickListener)

        val btnGuayaqui: Button = findViewById(R.id.btnGuayaquil)
        btnGuayaqui.setOnClickListener(ciudadClickListener)

        val btnQuito: Button = findViewById(R.id.btnQuito)
        btnQuito.setOnClickListener(ciudadClickListener)

        val btnRiobamba: Button = findViewById(R.id.btnRiobamba)
        btnRiobamba.setOnClickListener(ciudadClickListener)
    }

    private fun abrirClimaActivity(ciudad: String) {
        // Crear un Intent para iniciar ClimaActivity
        val intent = Intent(this, Clima::class.java)

        // Pasar datos a ClimaActivity
        intent.putExtra("ciudad", ciudad)

        // Iniciar la actividad
        startActivity(intent)
    }

}