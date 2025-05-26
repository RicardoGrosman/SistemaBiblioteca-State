import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LivroBibliotecaTest {

    LivroBiblioteca livro;

    @BeforeEach
    public void setUp() {
        livro = new LivroBiblioteca();
    }


    @Test
    public void deveEmprestarLivroDisponivel() {
        livro.definirEstado(EstadoLivroDisponivel.getInstance());
        assertTrue(livro.emprestar());
        assertEquals(EstadoLivroEmprestado.getInstance(), livro.obterEstado());
    }

    @Test
    public void deveReservarLivroDisponivel() {
        livro.definirEstado(EstadoLivroDisponivel.getInstance());
        assertTrue(livro.reservar());
        assertEquals(EstadoLivroReservado.getInstance(), livro.obterEstado());
    }

    @Test
    public void deveManterLivroDisponivel() {
        livro.definirEstado(EstadoLivroDisponivel.getInstance());
        assertTrue(livro.manter());
        assertEquals(EstadoLivroEmManutencao.getInstance(), livro.obterEstado());
    }

    @Test
    public void deveRemoverLivroDisponivel() {
        livro.definirEstado(EstadoLivroDisponivel.getInstance());
        assertTrue(livro.remover());
        assertEquals(EstadoLivroRemovido.getInstance(), livro.obterEstado());
    }

    @Test
    public void naoDeveDevolverLivroDisponivel() {
        livro.definirEstado(EstadoLivroDisponivel.getInstance());
        assertFalse(livro.devolver());
    }


    @Test
    public void deveDevolverLivroEmprestado() {
        livro.definirEstado(EstadoLivroEmprestado.getInstance());
        assertTrue(livro.devolver());
        assertEquals(EstadoLivroDisponivel.getInstance(), livro.obterEstado());
    }

    @Test
    public void deveManterLivroEmprestado() {
        livro.definirEstado(EstadoLivroEmprestado.getInstance());
        assertTrue(livro.manter());
        assertEquals(EstadoLivroEmManutencao.getInstance(), livro.obterEstado());
    }

    @Test
    public void deveRemoverLivroEmprestado() {
        livro.definirEstado(EstadoLivroEmprestado.getInstance());
        assertTrue(livro.remover());
        assertEquals(EstadoLivroRemovido.getInstance(), livro.obterEstado());
    }

    @Test
    public void naoDeveEmprestarLivroEmprestado() {
        livro.definirEstado(EstadoLivroEmprestado.getInstance());
        assertFalse(livro.emprestar());
    }

    @Test
    public void naoDeveReservarLivroEmprestado() {
        livro.definirEstado(EstadoLivroEmprestado.getInstance());
        assertFalse(livro.reservar());
    }


    @Test
    public void deveEmprestarLivroReservado() {
        livro.definirEstado(EstadoLivroReservado.getInstance());
        assertTrue(livro.emprestar());
        assertEquals(EstadoLivroEmprestado.getInstance(), livro.obterEstado());
    }

    @Test
    public void deveDevolverLivroReservado() {
        livro.definirEstado(EstadoLivroReservado.getInstance());
        assertTrue(livro.devolver());
        assertEquals(EstadoLivroDisponivel.getInstance(), livro.obterEstado());
    }

    @Test
    public void deveManterLivroReservado() {
        livro.definirEstado(EstadoLivroReservado.getInstance());
        assertTrue(livro.manter());
        assertEquals(EstadoLivroEmManutencao.getInstance(), livro.obterEstado());
    }

    @Test
    public void deveRemoverLivroReservado() {
        livro.definirEstado(EstadoLivroReservado.getInstance());
        assertTrue(livro.remover());
        assertEquals(EstadoLivroRemovido.getInstance(), livro.obterEstado());
    }

    @Test
    public void naoDeveReservarLivroReservado() {
        livro.definirEstado(EstadoLivroReservado.getInstance());
        assertFalse(livro.reservar());
    }


    @Test
    public void deveDevolverLivroEmManutencao() {
        livro.definirEstado(EstadoLivroEmManutencao.getInstance());
        assertTrue(livro.devolver());
        assertEquals(EstadoLivroDisponivel.getInstance(), livro.obterEstado());
    }

    @Test
    public void deveRemoverLivroEmManutencao() {
        livro.definirEstado(EstadoLivroEmManutencao.getInstance());
        assertTrue(livro.remover());
        assertEquals(EstadoLivroRemovido.getInstance(), livro.obterEstado());
    }

    @Test
    public void naoDeveEmprestarLivroEmManutencao() {
        livro.definirEstado(EstadoLivroEmManutencao.getInstance());
        assertFalse(livro.emprestar());
    }

    @Test
    public void naoDeveReservarLivroEmManutencao() {
        livro.definirEstado(EstadoLivroEmManutencao.getInstance());
        assertFalse(livro.reservar());
    }

    @Test
    public void naoDeveManterLivroEmManutencao() {
        livro.definirEstado(EstadoLivroEmManutencao.getInstance());
        assertFalse(livro.manter());
    }


    @Test
    public void naoDeveEmprestarLivroRemovido() {
        livro.definirEstado(EstadoLivroRemovido.getInstance());
        assertFalse(livro.emprestar());
    }

    @Test
    public void naoDeveReservarLivroRemovido() {
        livro.definirEstado(EstadoLivroRemovido.getInstance());
        assertFalse(livro.reservar());
    }

    @Test
    public void naoDeveDevolverLivroRemovido() {
        livro.definirEstado(EstadoLivroRemovido.getInstance());
        assertFalse(livro.devolver());
    }

    @Test
    public void naoDeveManterLivroRemovido() {
        livro.definirEstado(EstadoLivroRemovido.getInstance());
        assertFalse(livro.manter());
    }

    @Test
    public void naoDeveRemoverLivroRemovido() {
        livro.definirEstado(EstadoLivroRemovido.getInstance());
        assertFalse(livro.remover());
    }
}