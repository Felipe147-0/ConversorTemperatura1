package br.edu.ifsp.dmo.conversordetemperatura1.model

class FahrenheitStrategy : ConversorTemperatura {

    override fun converter(temperature: Double): Double {
        return 1.8 * temperature + 32
    }
    override fun getScale(): String {
        return "ºF"
    }
}