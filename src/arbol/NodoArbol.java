/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

/**
 *
 * @author MiguelAngel
 */
public class NodoArbol {
    protected int valor;
    protected Object dato;
    
    protected NodoArbol izquierdo;
    protected NodoArbol derecho;
    
    public NodoArbol(int valor, Object dato){
        this.valor = valor;
        this.dato = dato;
    }
    
    public NodoArbol(int valor, Object dato, NodoArbol izquierdo, NodoArbol derecho){
        this.valor = valor;
        this.dato = dato;
        this.izquierdo = izquierdo;
        this.derecho = derecho;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Object getDato() {
        return dato;
    }

    public void setDato(Object dato) {
        this.dato = dato;
    }

    public NodoArbol getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoArbol izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoArbol getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoArbol derecho) {
        this.derecho = derecho;
    }
}
