package br.edu.ifsp.dmo.conversordetemperatura1.model

object CelsiusKelvinStrategy : ConversorTemperatura {

    override fun converter(temperature: Double) = temperature + 273

    override fun getScale() = "K"

}