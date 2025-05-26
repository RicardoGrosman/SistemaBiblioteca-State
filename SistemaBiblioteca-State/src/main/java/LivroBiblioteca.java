public class LivroBiblioteca {

    private String titulo;
    private EstadoLivro estado;

    public LivroBiblioteca() {
        this.estado = EstadoLivroDisponivel.getInstance();
    }

    public void definirEstado(EstadoLivro estado) {
        this.estado = estado;
    }

    public boolean emprestar() {
        return estado.emprestar(this);
    }

    public boolean reservar() {
        return estado.reservar(this);
    }

    public boolean devolver() {
        return estado.devolver(this);
    }

    public boolean manter() {
        return estado.manter(this);
    }

    public boolean remover() {
        return estado.remover(this);
    }

    public String obterNomeEstado() {
        return estado.obterEstado();
    }

    public String obterTitulo() {
        return titulo;
    }

    public void definirTitulo(String titulo) {
        this.titulo = titulo;
    }

    public EstadoLivro obterEstado() {
        return estado;
    }
}