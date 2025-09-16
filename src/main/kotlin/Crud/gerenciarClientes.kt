package Crud


val conexão = conectar
fun criarTabelaClientes(){

    val sql = "CREATE TABLE IF NOT EXISTS Clientes " +
            "(id serial NOT NULL PRIMARY KEY, " +
            "nome varchar(255)," +
            ""
}
