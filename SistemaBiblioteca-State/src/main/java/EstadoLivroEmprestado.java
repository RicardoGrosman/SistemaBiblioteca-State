public class EstadoLivroEmprestado extends EstadoLivro {

    private EstadoLivroEmprestado() {}
    private static EstadoLivroEmprestado instance = new EstadoLivroEmprestado();
    public static EstadoLivroEmprestado getInstance() {
        return instance;
    }

    public String obterEstado() {
        return "Emprestado";
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