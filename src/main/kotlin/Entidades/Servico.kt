package entidades

import java.math.BigDecimal

class Servico (
    val orcamento :BigDecimal,
    val maoDeObra : BigDecimal, //hora
    val funcionario : Funcionario
) {
}