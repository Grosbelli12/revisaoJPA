package Crud
    
import java.lang.Exception
import java.sql.Connection
import java.sql.DriverManager

class EntidadeJDBC(
    val url : String,
    val usuario : String,
    val senha : String,
) {
    fun conectarComBanco() : Connection? {
        //Quando precisa fazer algo que possa falhar
        try{
            val conexao : Connection =
                DriverManager.getConnection(//cada banco tem o seu driver
                    //quando a Classe instanciar os atributos abaixo terão valores
                    this.url, this.usuario, this.senha

                )
            return conexao
        } catch (erro : Exception){
            println(erro.printStackTrace())
        }
        return null
    }
}