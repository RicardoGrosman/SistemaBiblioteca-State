public class EstadoLivroRemovido extends EstadoLivro {

    private EstadoLivroRemovido() {}
    private static EstadoLivroRemovido instance = new EstadoLivroRemovido();
    public static EstadoLivroRemovido getInstance() {
        return instance;
    }

    public String obterEstado() {
        return "Removido";
    }
}