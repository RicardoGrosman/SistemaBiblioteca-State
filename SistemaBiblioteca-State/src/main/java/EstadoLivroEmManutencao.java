public class EstadoLivroEmManutencao extends EstadoLivro {

    private EstadoLivroEmManutencao() {}
    private static EstadoLivroEmManutencao instance = new EstadoLivroEmManutencao();
    public static EstadoLivroEmManutencao getInstance() {
        return instance;
    }

    public String obterEstado() {
        return "Em Manutenção";
    }

    public boolean devolver(LivroBiblioteca livro) {
        livro.definirEstado(EstadoLivroDisponivel.getInstance());
        return true;
    }

    public boolean remover(LivroBiblioteca livro) {
        livro.definirEstado(EstadoLivroRemovido.getInstance());
        return true;
    }
}