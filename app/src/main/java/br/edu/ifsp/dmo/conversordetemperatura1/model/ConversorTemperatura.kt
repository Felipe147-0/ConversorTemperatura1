package br.edu.ifsp.dmo.conversordetemperatura1.model
/*Crie dentro do pacote “model” a interface ConversorTemperatura e as classes CelsuisStrategy e
FahrenheitStrategy.
Conforme indicado, a lógica do sistema utilizará o padrão de projeto “Strategy”. De forma geral, o
comportamento do objeto é alterado de acordo com a estratégia mais adequada para a situação. Conheça
mais sobre esse padrão em <https://refactoring.guru/pt-br/design-patterns/strategy>. Além disso, cada uma
das estratégias foi implementada em forma de Singleton, um outro padrão de projeto que permite apenas uma
única instância de uma classe. Conheça mais sobre o Singleton em <https://refactoring.guru/pt-br/designpatterns/singleton>. Para o uso de Singleton em Kotlin deve-se utilizar a declaração de objetos conforme
apresentado em <https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview>.
*/
interface ConversorTemperatura {

    /**
     * Método define o comportamento de todas as
     * classes que implementam a interface.
     */
    fun converter(temperature: Double): Double
    /**
    * Método retorna a escala da temperatura
    * convertida.
    */
    fun getScale(): String

}