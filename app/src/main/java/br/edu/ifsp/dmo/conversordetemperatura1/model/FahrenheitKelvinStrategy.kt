package br.edu.ifsp.dmo.conversordetemperatura1.model

object FahrenheitKelvinStrategy : ConversorTemperatura {

    override fun converter(temperature: Double): Double {
        return (temperature - 32) * 5/9 + 273
    }

    override fun getScale(): String {
        return "K"
    }
}