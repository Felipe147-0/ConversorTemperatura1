package br.edu.ifsp.dmo.conversordetemperatura1.model

object CelsiusFahrenheitStrategy : ConversorTemperatura {

    override fun converter(temperature: Double) = (temperature * 9/5) + 32

    override fun getScale() = "°F"

}