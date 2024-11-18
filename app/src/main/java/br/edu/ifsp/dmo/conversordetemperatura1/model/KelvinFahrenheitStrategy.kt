package br.edu.ifsp.dmo.conversordetemperatura1.model

object KelvinFahrenheitStrategy : ConversorTemperatura {

    override fun converter(temperature: Double): Double {
        return (temperature - 273) * 1.8 + 32
    }

    override fun getScale(): String {
        return "ºF"
    }

}