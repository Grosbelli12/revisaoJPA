package ui
import Crud.cadastrarCaixa
import enumerados.MaterialCaixaDeAgua
fun menu(){

    do {
    println("1 - Cadastrar Caixa D'Água\n" +
            "2 - Editar Caixa D'Água\n" +
            "3 - Listar Caixas D'Água\n" +
            "4 - Excluir Caixa D'Água\n" +
            "0 - Sair")

    val opcao = readln().toInt()

    when (opcao) {
        0 -> println("Adeus amigo!")
        1 -> { cadastrarCaixa()
            println("Cadastrando caixa...")
        }
        2 -> println("Editando caixa...")
        3 -> println("Listar caixas...")
        4 -> println("Excluindo caixa...")
        else -> println("Opcão invalida!")
    }
    }while (opcao!= 0)


}