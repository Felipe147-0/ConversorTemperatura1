package br.edu.ifsp.dmo.conversordetemperatura1.model

object FahrenheitCelciusStrategy : ConversorTemperatura {

    override fun converter(temperature: Double): Double {
        return (temperature - 32) * 5/9
    }

    override fun getScale(): String {
        return "ºC"
    }
}