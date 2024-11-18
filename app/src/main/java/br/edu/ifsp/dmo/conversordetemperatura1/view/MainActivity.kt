package br.edu.ifsp.dmo.conversordetemperatura1.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.edu.ifsp.dmo.conversordetemperatura1.R
import br.edu.ifsp.dmo.conversordetemperatura1.databinding.ActivityMainBinding
import br.edu.ifsp.dmo.conversordetemperatura1.model.CelsiusFahrenheitStrategy
import br.edu.ifsp.dmo.conversordetemperatura1.model.CelsiusKelvinStrategy
import br.edu.ifsp.dmo.conversordetemperatura1.model.ConversorTemperatura
import br.edu.ifsp.dmo.conversordetemperatura1.model.FahrenheitCelciusStrategy
import br.edu.ifsp.dmo.conversordetemperatura1.model.FahrenheitKelvinStrategy
import br.edu.ifsp.dmo.conversordetemperatura1.model.KelvinCelciusStrategy
import br.edu.ifsp.dmo.conversordetemperatura1.model.KelvinFahrenheitStrategy

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var converterStrategy: ConversorTemperatura

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(R.layout.activity_main)

        setClickListener()

    }
/**
 * Diferente dos projetos anteriores, nesse exemplo o clique nos botões
 * é tratado com a implementação por uma lambda. As duas formas de
 * implementação indicadas são válidas, no botão btnCelsius adotou-se
 * a forma mais direta de implementação, sem especificar qual a
 * interface se está implementando. Já para o btnFahrenheit utiliza-se
 * uma implementação que indica a interface que está sendo implementada.
 *
 * Isso é possível pois é feita a inferência do tipo do argumento do método
 * setClickListener(), que sempre recebe um objeto de View.OnClickListener.
 *
 * Para cada botão é realizada a chamada do método handleConversion() que
 * recebe como argumento qual a estratégia que o sistema deve utilizar
 * para realizar a conversão.
 */
private fun setClickListener() {
    binding.buttonCelsiusFah.setOnClickListener {
        handleConversion(CelsiusFahrenheitStrategy)
    }

    binding.buttonCelsiusKel.setOnClickListener {
        handleConversion(CelsiusKelvinStrategy)
    }

    binding.buttonFahrenheitCel.setOnClickListener {
        handleConversion(FahrenheitCelciusStrategy)
    }

    binding.buttonFahrenheitKel.setOnClickListener {
        handleConversion(FahrenheitKelvinStrategy)
    }

    binding.buttonKelvinCel.setOnClickListener {
        handleConversion(KelvinCelciusStrategy)
    }

    binding.buttonKelvinFah.setOnClickListener {
        handleConversion(KelvinFahrenheitStrategy)
    }
}
    /**
     * Método responsável por recuperar o valor digitado no edittext
     * e converte-lo para o tipo Double.
     * O método pode lança uma exceção caso não seja possível converter
     * a entrada para Double.
     */
    private fun readTemperature(): Double {
        return try {
            binding.edittextTemperature.text.toString().toDouble()
        } catch (e: NumberFormatException) {
            throw NumberFormatException("Input Error")
        }
    }
    /**
     * O método agrupa a lógica da MainActivity, delegando à TeperatureConverter
     * a lógica de negócio da aplicação, contudo é MainActivity que aplica o
     * resultado da estratégia selecionada,
     */
    private fun handleConversion(strategy: ConversorTemperatura) {
        converterStrategy = strategy
        try {
            val inputValue = readTemperature()
            binding.textviewResultNumber.text = String.format(
                "%.2f %s",
                converterStrategy.converter(inputValue),
                converterStrategy.getScale()
            )
            binding.textviewResultMessage.text =

                when (this.converterStrategy) {
                    is CelsiusFahrenheitStrategy -> {
                        getString(R.string.msgCtoF)
                    }

                    is CelsiusKelvinStrategy -> {
                        getString(R.string.msgCtoK)
                    }

                    is FahrenheitCelciusStrategy -> {
                        getString(R.string.msgFtoC)
                    }

                    is FahrenheitKelvinStrategy -> {
                        getString(R.string.msgFtoK)
                    }

                    is KelvinCelciusStrategy -> {
                        getString(R.string.msgKtoC)
                    }

                    else -> {
                        getString(R.string.msgKtoF)
                    }
                }
        } catch (e: Exception) {
            Toast.makeText(this, getString(R.string.error_popup_notify), Toast.LENGTH_SHORT).show()
            Log.e("APP_DMO", e.stackTraceToString())
        }
    }
    }