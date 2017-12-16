/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.lista;

/**
 *
 * @author MiguelAngel
 */
public class Nodo {

    protected Object dato;
    protected int valor;
    protected Nodo siguiente;

    public Nodo(int valor, Object dato, Nodo siguiente) {
        this.valor = valor;
        this.dato = dato;
        this.siguiente = siguiente;
    }
    
    public Nodo(int valor, Object dato){
        this.valor = valor;
        this.dato = dato;
    }
    
    public Nodo() {};

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    
    /**
     * @return the dato
     */
    public Object getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Object dato) {
        this.dato = dato;
    }

    /**
     * @return the siguiente
     */
    public Nodo getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
