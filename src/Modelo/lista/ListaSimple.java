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
public class ListaSimple {

    protected Nodo inicio;
    protected Nodo ultimo;

    public boolean isEmpty() {
        return inicio == null;
    }
    
    public Object getinicio(){
        Object tmp = inicio.getDato();
        return tmp;
    }
    
    public Object getSiguiente(){
        Object tmp = inicio.getSiguiente().getDato();
        return tmp;
    }

    public void InsertaInicio(int valor, Object dato) {
        if (isEmpty()) {
            inicio = ultimo = new Nodo(valor, dato);
        } else {
            inicio = new Nodo(valor, dato, inicio);
        }
    }

    public void InsertaFinal(int valor, Object dato) {
        if (isEmpty()) {
            inicio = ultimo = new Nodo(valor, dato);
        } else {
            Nodo tmp = new Nodo(valor, dato);
            ultimo.setSiguiente(tmp);
            ultimo = tmp;
        }
    }
    
    public Nodo EliminaInicio() {
        Nodo eliminado = null;
        if (isEmpty()) {
            System.out.println("Lista vacia!!");
        } else {
            eliminado = inicio;
            inicio = inicio.getSiguiente();
        }
        return eliminado;
    }

    public void insertaEnOrden(int valor, Object dato) {
        if (isEmpty()) {
            InsertaInicio(valor, dato);
        } else if (inicio == ultimo) {//Solamente un elemento en la lista
            if (valor < inicio.getValor()) {
                InsertaInicio(valor, dato);
            } else {
                InsertaFinal(valor, dato);
            }
        } else {
            Nodo antes = null, despues = inicio;
            while (despues != null && valor > despues.getValor()) {
                antes = despues;
                despues = despues.getSiguiente();
            }
            if (antes == null) {
                InsertaInicio(valor, dato);
            } else if (despues == null) {
                InsertaFinal(valor, dato);
            } else {
                Nodo nuevo = new Nodo(valor, dato, despues);
                antes.setSiguiente(nuevo);
            }
        }
    }
    
    public boolean hasNext(){
        return inicio.getSiguiente() != null;
    }
}
