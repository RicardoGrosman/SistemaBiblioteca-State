public class EstadoLivroDisponivel extends EstadoLivro {

    private EstadoLivroDisponivel() {}
    private static EstadoLivroDisponivel instance = new EstadoLivroDisponivel();
    public static EstadoLivroDisponivel getInstance() {
        return instance;
    }

    public String obterEstado() {
        return "Disponível";
    }

    public boolean emprestar(LivroBiblioteca livro) {
        livro.definirEstado(EstadoLivroEmprestado.getInstance());
        return true;
    }

    public boolean reservar(LivroBiblioteca livro) {
        livro.definirEstado(EstadoLivroReservado.getInstance());
        return true;
    }

    public boolean manter(LivroBiblioteca livro) {
        livro.definirEstado(EstadoLivroEmManutencao.getInstance());
        return true;
    }

    public boolean remover(LivroBiblioteca livro) {
        livro.definirEstado(EstadoLivroRemovido.getInstance());
        return true;
    }
}