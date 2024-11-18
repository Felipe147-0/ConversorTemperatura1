package br.edu.ifsp.dmo.conversordetemperatura1.model

object KelvinCelciusStrategy : ConversorTemperatura{

    override fun converter(temperature: Double): Double {
        return temperature - 273
    }

    override fun getScale(): String {
        return "ºC"
    }

}