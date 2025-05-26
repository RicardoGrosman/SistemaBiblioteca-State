Sistema de Gerenciamento de Livros de Biblioteca
Este projeto implementa um sistema de gerenciamento de estados de livros em uma biblioteca, utilizando o padrão de projeto comportamental State em Java. O sistema modela o ciclo de vida de um livro, permitindo transições entre estados como Disponível, Emprestado, Reservado, Em Manutenção e Removido.
Estrutura do Projeto
O projeto está organizado no pacote padroescomportamentais.state e contém as seguintes classes:

LivroBiblioteca: Classe principal que representa um livro na biblioteca, com atributos titulo e estado, e métodos para ações como emprestar(), reservar(), devolver(), manter() e remover().
EstadoLivro: Classe abstrata que define a interface para os estados do livro, com métodos como obterEstado(), emprestar(), reservar(), etc.
Classes de Estado Concretas:
EstadoLivroDisponivel: Estado inicial, permite emprestar, reservar, manter ou remover o livro.
EstadoLivroEmprestado: Permite devolver, manter ou remover o livro.
EstadoLivroReservado: Permite emprestar, devolver, manter ou remover o livro.
EstadoLivroEmManutencao: Permite devolver ou remover o livro.
EstadoLivroRemovido: Estado final, não permite nenhuma ação.


LivroBibliotecaTest: Classe de teste JUnit que verifica todas as transições de estado válidas e inválidas.

O padrão State é implementado usando o padrão Singleton para as classes de estado, garantindo uma única instância por estado.
Diagrama de Classes UML
O diagrama UML do sistema pode ser representado com o seguinte código PlantUML:
@startuml
package "padroescomportamentais.state" {
  class LivroBiblioteca {
    -titulo: String
    -estado: EstadoLivro
    +LivroBiblioteca()
    +definirEstado(estado: EstadoLivro): void
    +emprestar(): boolean
    +reservar(): boolean
    +devolver(): boolean
    +manter(): boolean
    +remover(): boolean
    +obterNomeEstado(): String
    +obterTitulo(): String
    +definirTitulo(titulo: String): void
    +obterEstado(): EstadoLivro
  }
  abstract class EstadoLivro {
    +{abstract} obterEstado(): String
    +emprestar(livro: LivroBiblioteca): boolean
    +reservar(livro: LivroBiblioteca): boolean
    +devolver(livro: LivroBiblioteca): boolean
    +manter(livro: LivroBiblioteca): boolean
    +remover(livro: LivroBiblioteca): boolean
  }
  class EstadoLivroDisponivel {
    -instance: EstadoLivroDisponivel {static}
    -EstadoLivroDisponivel()
    +getInstance(): EstadoLivroDisponivel {static}
    +obterEstado(): String
    +emprestar(livro: LivroBiblioteca): boolean
    +reservar(livro: LivroBiblioteca): boolean
    +manter(livro: LivroBiblioteca): boolean
    +remover(livro: LivroBiblioteca): boolean
  }
  class EstadoLivroEmprestado {
    -instance: EstadoLivroEmprestado {static}
    -EstadoLivroEmprestado()
    +getInstance(): EstadoLivroEmprestado {static}
    +obterEstado(): String
    +devolver(livro: LivroBiblioteca): boolean
    +manter(livro: LivroBiblioteca): boolean
    +remover(livro: LivroBiblioteca): boolean
  }
  class EstadoLivroReservado {
    -instance: EstadoLivroReservado {static}
    -EstadoLivroReservado()
    +getInstance(): EstadoLivroReservado {static}
    +obterEstado(): String
    +emprestar(livro: LivroBiblioteca): boolean
    +devolver(livro: LivroBiblioteca): boolean
    +manter(livro: LivroBiblioteca): boolean
    +remover(livro: LivroBiblioteca): boolean
  }
  class EstadoLivroEmManutencao {
    -instance: EstadoLivroEmManutencao {static}
    -EstadoLivroEmManutencao()
    +getInstance(): EstadoLivroEmManutencao {static}
    +obterEstado(): String
    +devolver(livro: LivroBiblioteca): boolean
    +remover(livro: LivroBiblioteca): boolean
  }
  class EstadoLivroRemovido {
    -instance: EstadoLivroRemovido {static}
    -EstadoLivroRemovido()
    +getInstance(): EstadoLivroRemovido {static}
    +obterEstado(): String
  }
  LivroBiblioteca --> "1" EstadoLivro : estado
  EstadoLivro <|-- EstadoLivroDisponivel
  EstadoLivro <|-- EstadoLivroEmprestado
  EstadoLivro <|-- EstadoLivroReservado
  EstadoLivro <|-- EstadoLivroEmManutencao
  EstadoLivro <|-- EstadoLivroRemovido
}
@enduml

Para visualizar o diagrama, cole o código acima em uma ferramenta como PlantUML Web Server.
Dependências

Java: Versão 8 ou superior.
JUnit 5: Para execução dos testes (incluso no arquivo LivroBibliotecaTest.java).
Dependências recomendadas no pom.xml (se usar Maven):<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-api</artifactId>
        <version>5.10.2</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter-engine</artifactId>
        <version>5.10.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>





Como Usar

Compilar o Projeto:

Certifique-se de ter o JDK instalado.
Compile as classes com:javac -d . src/padroescomportamentais/state/*.java




Executar os Testes:

Configure o JUnit 5 no seu ambiente (ou use uma IDE como IntelliJ ou Eclipse com suporte a JUnit).
Execute a classe LivroBibliotecaTest para verificar todas as transições de estado:java -cp .;junit-platform-console-standalone.jar org.junit.platform.console.ConsoleLauncher --select-class padroescomportamentais.state.LivroBibliotecaTest

(Substitua ; por : em sistemas Unix/Linux/Mac.)


Exemplo de Uso:

Crie uma instância de LivroBiblioteca e manipule seus estados:package padroescomportamentais.state;

public class Main {
    public static void main(String[] args) {
        LivroBiblioteca livro = new LivroBiblioteca();
        livro.definirTitulo("Dom Casmurro");
        System.out.println("Estado inicial: " + livro.obterNomeEstado()); // Disponível
        livro.emprestar();
        System.out.println("Após emprestar: " + livro.obterNomeEstado()); // Emprestado
        livro.devolver();
        System.out.println("Após devolver: " + livro.obterNomeEstado()); // Disponível
    }
}





Estrutura de Estados e Transições

Disponível: Pode ser emprestado, reservado, colocado em manutenção ou removido.
Emprestado: Pode ser devolvido, colocado em manutenção ou removido.
Reservado: Pode ser emprestado, devolvido (cancelar reserva), colocado em manutenção ou removido.
Em Manutenção: Pode ser devolvido (voltar a Disponível) ou removido.
Removido: Estado final, sem transições permitidas.

Testes
A classe LivroBibliotecaTest contém testes JUnit para todas as transições válidas e inválidas:

Testa ações permitidas (e.g., deveEmprestarLivroDisponivel) com verificação de mudança de estado.
Testa ações inválidas (e.g., naoDeveDevolverLivroDisponivel) com verificação de que o estado não muda.



