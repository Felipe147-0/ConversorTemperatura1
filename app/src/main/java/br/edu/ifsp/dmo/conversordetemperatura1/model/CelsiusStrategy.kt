package br.edu.ifsp.dmo.conversordetemperatura1.model

class CelsiusStrategy : ConversorTemperatura {

    override fun converter(temperature: Double) = (temperature - 32) / 1.8
    override fun getScale() = "ºC"

}