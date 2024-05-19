import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.*;

class TArbolGenericoTest {
    TArbolGenerico<Comparable> arbol1;
    @BeforeEach
    void setUp() {
        arbol1 = new TArbolGenerico<>();
    }
    @org.junit.jupiter.api.Test
    @DisplayName("Intentar insertar otra raíz / Rectorado inexistente")
    void insertar() {
        assertTrue(arbol1.insertar("Rectoria","")); //RAÍZ
        assertTrue(arbol1.insertar("Vicerrectoría del medio universitario", "Rectoria"));
        assertTrue(arbol1.insertar("Vicerrectoría académica","Rectoria"));

        assertFalse(arbol1.insertar("Nuevo Rectorado", "")); //Intentar insertar otra raíz
        assertFalse(arbol1.insertar("Facultad de ingeniería", "Otrorectorad")); //Rectorado inexistente
    }

    @org.junit.jupiter.api.Test
    void buscar() {
        TNodoGenerico<Comparable> nodo1 = new TNodoGenerico<>("Rectoria", "");
        TNodoGenerico<Comparable> nodo2 = new TNodoGenerico<>("Vicerrectoría del medio universitario", "");
        TNodoGenerico<Comparable> nodo3 = new TNodoGenerico<>("Vicerrectoría académica", "");
        arbol1.insertar(nodo1.getEtiqueta(),"");
        arbol1.insertar(nodo2.getEtiqueta(), nodo1.getEtiqueta());
        arbol1.insertar(nodo3.getEtiqueta(), nodo1.getEtiqueta());
        assertNotNull(arbol1.buscar("Vicerrectoría del medio universitario"));
        assertNull(arbol1.buscar("Rectoria de NuevaYork")); //elemento inexistente en el árbol
    }

    @org.junit.jupiter.api.Test
    void listarIdentado() {
        TNodoGenerico<Comparable> nodo1 = new TNodoGenerico<>("Rectoria", null);
        TNodoGenerico<Comparable> nodo2 = new TNodoGenerico<>("Vicerrectoría del medio universitario", "");
        TNodoGenerico<Comparable> nodo3 = new TNodoGenerico<>("Vicerrectoría académica", "");
        arbol1.listarIdentado();
    }
}