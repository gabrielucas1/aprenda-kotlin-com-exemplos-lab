// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

data class Usuario(val nome: String,val idade: Int, val nivel: Nivel, val feedback : Int, val conteudoUsuario : List<ConteudoEducacional>){

    fun avalicao(): String {
         return when(feedback){
            1 -> "BOM"
            2 -> "EXCELENTE"
            else -> "PESSIMO"
        }
    }
}

data class ConteudoEducacional(var conteudo: Int, val duracao: Int = 60){

    fun materia(): String{
        return when(conteudo){
            1 ->"MATEMATICA"
            2 ->"PHYTON"
            3 ->"JAVA SPRING BOOT"
            4 ->"IA"
            else -> "CONTEUDO NÃO EXISTE "

        }
    }
    }

  data class Formacao(var nome: String,var conteudos: List<ConteudoEducacional>) {

      val inscritos = mutableListOf<Usuario>()
    
      fun matricular(vararg usuario: Usuario) {
        inscritos.addAll(usuario.toList())
      }
  }

  fun exibirUser(usuario : Usuario){
    println("Usuário ${usuario.nome}, tem ${usuario.idade} anos, está no nivel ${usuario.nivel}, e o seu feedback é ${usuario.avalicao()}, está estudando o conteudo ${usuario.conteudoUsuario[0].materia()}\n\n")

  }

fun main() {


    val pessoa = Usuario("Gabriel",20,Nivel.BASICO,1,listOf(ConteudoEducacional(2)))
     exibirUser(pessoa)
 
    val pessoa2 = Usuario("Ana",22,Nivel.AVANÇADO,1,listOf(ConteudoEducacional(1)))
     exibirUser(pessoa2)

    val formacao = Formacao("Kotlin",listOf(ConteudoEducacional(2), ConteudoEducacional(1)))
    formacao.matricular(pessoa,pessoa2)

    println("Conteúdos da formação ${formacao.nome}: ${formacao.conteudos.joinToString(", ") { it.materia() }}")


}

