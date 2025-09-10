package ui

import Crud.cadastrarCaixa
import Crud.editarCaixa
import Crud.excluirCaixa
import Crud.listarCaixas
import enumerados.MaterialCaixaDeAgua

fun menu() {

    do {
        println(
            "1 - Cadastrar Caixa D'Água\n" +
                    "2 - Editar Caixa D'Água\n" +
                    "3 - Listar Caixas D'Água\n" +
                    "4 - Excluir Caixa D'Água\n" +
                    "0 - Sair"
        )

        val opcao = readln().toInt()

        when (opcao) {
            0 -> println("Adeus amigo!")
            1 ->{
                println("Cadastrando caixa...")
                // Sempre que for cadastrar uma caixa nova p ID será 0
                cadastrarCaixa(0)
            }

            2 -> {
                println("Editando caixa...")
                editarCaixa()
            }
            3 ->{
                println("Listanod caixas...")
                listarCaixas()
            }

            4 -> {
                println("Excluindo caixa...")
                excluirCaixa()
            }

            else -> println("Opcão invalida!")
        }
    } while (opcao != 0)


}