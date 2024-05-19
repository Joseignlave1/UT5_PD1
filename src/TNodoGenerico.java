public class TNodoGenerico<T> implements INodoArbolGenerico<T> {
    Comparable etiqueta;
    TNodoGenerico<T> primerHijo;
    TNodoGenerico<T> hermanoDer;
    T datos;

    public TNodoGenerico (Comparable etiqueta, T datos) {
        this.etiqueta = etiqueta;
        this.datos = datos;
    }
    @Override
    public Comparable getEtiqueta() {
        return this.etiqueta;
    }

    @Override
    public TNodoGenerico<T> getPrimerHijo() {
        return this.primerHijo;
    }

    @Override
    public TNodoGenerico<T> getHermanoDer() {
        return this.hermanoDer;
    }

    @Override
    public void setPrimerHijo(TNodoGenerico<T> elemento) {
        this.primerHijo = elemento;
    }

    @Override
    public void setHermanoDer(TNodoGenerico<T> elemento) {
        this.hermanoDer = elemento;
    }

    @Override
    public TNodoGenerico<T> buscar(Comparable unaEtiqueta) {
        TNodoGenerico<T> resultado = null;
        if(unaEtiqueta.equals(this.etiqueta)) {
            return this; //Las etiquetas son iguales
        } else {
            if(this.primerHijo != null) {
                resultado = this.primerHijo.buscar(unaEtiqueta);
            }
            if(resultado == null && this.hermanoDer != null) { //Se buscó en el primer hijo y no se encontró el elemento con la etiqueta esperada
                resultado = this.hermanoDer.buscar(unaEtiqueta);
            }
        }
        return resultado;
    }

    @Override
    public boolean insertar(Comparable unaEtiqueta, Comparable etiquetaPadre) {
        if(etiquetaPadre.equals("")) {
            if(this.etiqueta == null) {
                this.etiqueta = unaEtiqueta;
                return true;
            } else {
                return false;
            }
        } else {
            TNodoGenerico<T> nodoPadre = buscar(etiquetaPadre);
            if(nodoPadre == null) {
                return false; //No se encontró un nodo padre
            } else {
                TNodoGenerico<T> nuevoNodo = new TNodoGenerico<>(unaEtiqueta, null);
                if(nodoPadre.getPrimerHijo() == null) {
                    nodoPadre.setPrimerHijo(nuevoNodo);
                } else {
                    TNodoGenerico<T> actual = nodoPadre.primerHijo;
                    while(actual.getHermanoDer() != null) {
                        actual = actual.getHermanoDer();
                    }
                    actual.setHermanoDer(nuevoNodo); //RECORREMOS TODOS LOS HERMANOS DERECHOS Y LO AÑADIMOS AL FINAL COMO EL ULTIMO HERMANO DERECHO
                }
                return true;
            }
        }
    }

    @Override
    public TNodoGenerico<T> eliminar(Comparable unaEtiqueta) {
        return null;
    }

    @Override
    public void listarIdentado() {
        listarIdentadoNiveles(this, 0);
    }

    @Override
    public T getDatos() {
        return this.datos;
    }

    private void listarIdentadoNiveles(TNodoGenerico<T> nodo, int nivel) {
        if (nodo != null) {
            for (int i = 0; i < nivel; i++) {
                System.out.print("  "); // Imprime dos espacios por nivel
            }
            System.out.println(nodo.getEtiqueta());
            // Llama recursivamente a los hijos del nodo actual con un nivel aumentado en uno
            if (nodo.getPrimerHijo() != null) {
                listarIdentadoNiveles(nodo.getPrimerHijo(), nivel + 1);
            }
            // Llama recursivamente a los hermanos derechos del nodo actual con el mismo nivel
            if (nodo.getHermanoDer() != null) {
                listarIdentadoNiveles(nodo.getHermanoDer(), nivel);
            }
        }
    }
}
