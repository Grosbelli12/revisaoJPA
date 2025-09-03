package entidades

import enumerados.Experiencia
import enumerados.Setor
import enumerados.Sexo
import java.math.BigDecimal

class Funcionario(
    nome: String,
    idade: Int,
    cpf: Int,
    sexo: Sexo,
    telefone: String,
    val salario: BigDecimal,
    val experiencia: Experiencia,
    val setor: Setor
) : Pessoa(nome = nome,
    idade = idade,
    cpf = cpf,
    sexo = sexo,
    telefone = telefone,
    ) {


    //Comportamento do Profissional
    fun instalarCaixaDAgua(clt: Funcionario): Boolean {

        if ( clt.setor.equals(Setor.MONTAGEM)){
           return true;
        }else{
            return false;
        }
    }

    override fun receberConta(conta: Conta, aDever : BigDecimal ){
        conta.saldo = conta.saldo.subtract(aDever)
    }
}

