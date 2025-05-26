public class EstadoLivroReservado extends EstadoLivro {

    private EstadoLivroReservado() {}
    private static EstadoLivroReservado instance = new EstadoLivroReservado();
    public static EstadoLivroReservado getInstance() {
        return instance;
    }

    public String obterEstado() {
        return "Reservado";
    }

    public boolean emprestar(LivroBiblioteca livro) {
        livro.definirEstado(EstadoLivroEmprestado.getInstance());
        return true;
    }

    public boolean devolver(LivroBiblioteca livro) {
        livro.definirEstado(EstadoLivroDisponivel.getInstance());
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