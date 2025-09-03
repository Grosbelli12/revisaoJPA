package Crud

import entidades.CaixaDAgua
import enumerados.Cor
import enumerados.Marca
import enumerados.MaterialCaixaDeAgua


fun criarTabelaCaixa(){
    val conectar = EntidadeJDBC(
        url = "jdbc:postgresql://localhost:5432/revisao",
        usuario = "postgres",
        senha = "postgres"
    )

    val sql = "CREATE TABLE IF NOT EXISTS CaixaDAgua " +
            " (id serial NOT NULL PRIMARY KEY," +
            " material varchar(255)," + //Enumeradores serão STRINGS no banco
            " capacidade float," +
            " cor varchar(255)," +
            " peso float," +
            " preco varchar(255)," +
            " altura float," +
            " largura float," +
            " profundidade float" +
            ")"

    val banco = conectar.conectarComBanco()
    val enviarParaBanco = banco!!.createStatement().execute(sql)

    println(enviarParaBanco)//Se retornar false ou 1, deu certo!

    banco.close()//encerra a conexão
}

fun cadastrarCaixa() {
    /* val material: MaterialCaixaDeAgua,
      val capacidade :Int, // Litros
     val preco: BigDecimal,
     val cor : Cor,
     val altura :Double,
     val marca : String,
     val peso :Double, //kg
     val largura :Double,
     val profundidade :Double*/

    println(
        "Escolha o material do qual a caixa é feita\n" +
                "1 - FIBRA_DE_VIDRO\n" +
                "2 - POLIETILENO"
    )

    var opcao = readln().toInt()

    var material: MaterialCaixaDeAgua

    when (opcao) {
        1 -> material = MaterialCaixaDeAgua.POLIETILENO
        else -> material = MaterialCaixaDeAgua.FIBRA_DE_VIDRO
    }

    println("Escolha a capacidade em litros da caixa  D'água")
    val capacidade = readln().toInt()

    println("Escolha o preço da caixa")
    val preco = readln().toBigDecimal()

    println(
        "Escolha a cor da caixa\n" +
                "1 - AZUL\n" +
                "2 - VERDE"
    )
    opcao = readln().toInt()
    var cor: Cor
    when (opcao) {
        1 -> cor = Cor.AZUL
        else -> cor = Cor.VERDE
    }

    println("Escolha a altura da caixa")
    val altura = readln().toDouble()

    println(
        "Escolha a marca da caixa\n" +
                "1 - MARCA1" +
                "2 - MARCA2"
    )
    opcao = readln().toInt()
    val marca: Marca

    when (opcao) {
        1 -> marca = Marca.MARCA1
        else -> marca = Marca.MARCA2
    }

    println("Escolha o peso da caixa")
    val peso = readln().toDouble()

    println("Escolha a largura da caixa")
    val largura = readln().toDouble()

    println("Escolha a profundidade da caixa")
    val profundidade = readln().toDouble()

    CaixaDAgua(
        material = material,
        preco = preco,
        capacidade = capacidade,
        altura = altura,
        marca = marca,
        cor = cor,
        peso = peso,
        largura = largura,
        profundidade = profundidade
    )

}

fun editarCaixa() {

}

