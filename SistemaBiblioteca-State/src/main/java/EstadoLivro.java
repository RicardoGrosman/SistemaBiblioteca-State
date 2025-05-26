public abstract class EstadoLivro {

    public abstract String obterEstado();

    public boolean emprestar(LivroBiblioteca livro) {
        return false;
    }

    public boolean reservar(LivroBiblioteca livro) {
        return false;
    }

    public boolean devolver(LivroBiblioteca livro) {
        return false;
    }

    public boolean manter(LivroBiblioteca livro) {
        return false;
    }

    public boolean remover(LivroBiblioteca livro) {
        return false;
    }
}