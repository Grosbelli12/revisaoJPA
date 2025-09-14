package Crud

import entidades.CaixaDAgua
import enumerados.Cor
import enumerados.Marca
import enumerados.MaterialCaixaDeAgua
import ui.menu
import java.sql.ResultSet


val conectar = EntidadeJDBC(
    url = "jdbc:postgresql://localhost:5432/revisao",
    usuario = "postgres",
    senha = "postgres"
)
var id = 0
fun criarTabelaCaixa() {

    val sql = "CREATE TABLE IF NOT EXISTS CaixaDAgua " +
            " (id serial NOT NULL PRIMARY KEY," +
            " material varchar(255)," +
            " preco varchar(255)," +
            " capacidade float," +
            " altura float," +
            "marca varchar(255)," +
            " cor varchar(255)," + //Enumeradores serão STRINGS no banco
            " peso float," +
            " largura float," +
            " profundidade float" +
            ")"

    val banco = conectar.conectarComBanco()
    val enviarParaBanco = banco!!.createStatement().execute(sql)

    println(enviarParaBanco)//Se retornar false ou 1, deu certo!

    banco.close()//encerra a conexão
}

fun cadastrarCaixa(id: Int) {

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

    println("Escolha o preço da caixa")
    val preco = readln().toBigDecimal()

    println("Escolha a capacidade em litros da caixa  D'água")
    val capacidade = readln().toInt()


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
                "1 - MARCA1\n" +
                "2 - MARCA2"
    )
    opcao = readln().toInt()
    var marca: Marca

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

    val caixa = CaixaDAgua(
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
    val banco = conectar.conectarComBanco()!!

    if (id == 0) {
        val salvar = banco.prepareStatement(
            "INSERT INTO CaixaDAgua (material, preco, " +
                    " capacidade, altura, marca," +
                    " cor, peso, largura, profundidade)" +
                    " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)"
        )
        salvar.setString(1, caixa.material.name)
        salvar.setString(2, caixa.preco.toString())
        salvar.setInt(3, caixa.capacidade)
        salvar.setDouble(4, caixa.altura)
        salvar.setString(5, caixa.marca.name)
        salvar.setString(6, caixa.cor.name)
        salvar.setDouble(7, caixa.peso)
        salvar.setDouble(8, caixa.largura)
        salvar.setDouble(9, caixa.profundidade)
        salvar.executeUpdate() // Isso fará um commit no banco

    } else {
        val sql = "UPDATE    CaixaDAgua SET material = ?," +
                " preco = ?," +
                " capacidade = ?," +
                " altura = ?," +
                " marca = ?," +
                " cor = ?," +
                " peso = ?," +
                " largura = ?, " +
                " profundidade = ?" +
                " WHERE id = ?"

        val editar = banco.prepareStatement(sql)
        editar.setInt(10, id)
        editar.setString(1, caixa.material.name)
        editar.setString(2, caixa.preco.toString())
        editar.setInt(3, caixa.capacidade)
        editar.setDouble(4, caixa.altura)
        editar.setString(5, caixa.marca.name)
        editar.setString(6, caixa.cor.name)
        editar.setDouble(7, caixa.peso)
        editar.setDouble(8, caixa.largura)
        editar.setDouble(9, caixa.profundidade)
        editar.executeUpdate() // Isso fará um commit no banco
    }
    banco.close()
}

fun buscarEExibirCaixa(id: Int) {
    if (id == 0) {
        println("opção inválida")
    } else {

        val banco = conectar.conectarComBanco()
        val sqlBusca = "SELECT * FROM CaixaDAgua   WHERE ID = ?"
        val resultados = banco!!.prepareStatement(sqlBusca)
        resultados.setInt(1, id)
        val retorno = resultados.executeQuery()

        while (retorno.next()) {
            println(
                "---------------------------------------\n" +
                        "Id: ${retorno.getInt("id")}\n" +
                        "material: ${retorno.getString("material")}\n" +
                        "preco: ${retorno.getString("preco")}\n" +
                        "capacidade: ${retorno.getDouble("capacidade")}\n" +
                        "altura: ${retorno.getDouble("altura")}\n" +
                        "marca:${retorno.getString("marca")}\n" +
                        "cor: ${retorno.getString("cor")}\n" +
                        "peso: ${retorno.getDouble("peso")}\n" +
                        "largura: ${retorno.getDouble("largura")}\n" +
                        "profundidade: ${retorno.getDouble("profundidade")}\n"
            )

        }
        banco.close()

    }
}

fun editarCaixa() {
    println("Digite o id que deseja editar")
    val idParaEditar = readln().toInt()

   buscarEExibirCaixa(idParaEditar)

    println("Faça suas alterações")
    cadastrarCaixa(idParaEditar)

}

fun listarCaixas() {
    val banco = conectar.conectarComBanco()
    val sql = "SELECT * FROM CaixaDAgua"
    val resultados: ResultSet = banco!!.createStatement().executeQuery(sql)

    while (resultados.next()) {
        println(
            "Id: ${resultados.getInt("id")}\n" +
                    "material: ${resultados.getString("material")}\n" +
                    "preco: ${resultados.getString("preco")}\n" +
                    "capacidade: ${resultados.getDouble("capacidade")}\n" +
                    "altura: ${resultados.getDouble("altura")}\n" +
                    "marca:${resultados.getString("marca")}\n" +
                    "cor: ${resultados.getString("cor")}\n" +
                    "peso: ${resultados.getDouble("peso")}\n" +
                    "largura: ${resultados.getDouble("largura")}\n" +
                    "profundidade: ${resultados.getDouble("profundidade")}\n"
        )

    }
    banco.close()
}

fun excluirCaixa() {
    println("Digite o ID que deseja excluir ")
    val idParaExcluir = readln().toInt()

    buscarEExibirCaixa(idParaExcluir)

    println("Tem certeza que deseja excluir esse registro?")
    val resposta = readln().lowercase()
    when (resposta) {
        "sim" -> {
            val banco = conectar.conectarComBanco()
            val deletar = banco!!.prepareStatement("DELETE FROM CaixaDAgua   WHERE id = ?")
            deletar.setInt(1, idParaExcluir) // diz qual é o valor do 1° ponto de interrogação
            deletar.executeUpdate() // Manda a instrução ser executada
            println("Excluido com sucesso")
        }

        else -> {
            println("Erro... Operação cancelada")
        }

    }
}

