package entidades

import enumerados.Cor
import enumerados.Marca
import enumerados.MaterialCaixaDeAgua
import java.math.BigDecimal

class CaixaDAgua( // Os 2 parenteses são o construtor da classe
    val material: MaterialCaixaDeAgua,
    val capacidade :Int, // Litros
    val preco: BigDecimal,
    val cor : Cor,
    val altura:Double,
    val marca : Marca,
    val peso :Double, //kg
    val largura :Double,
    val profundidade :Double
)// Aqui vai todos os atributos da classe
 {


}