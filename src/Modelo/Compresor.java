/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Modelo.lista.ListaSimple;
import Modelo.lista.Nodo;
import arbol.Arbol;
import arbol.NodoArbol;
import java.util.Enumeration;

/**
 *
 * @author MiguelAngel
 */
public class Compresor {

    protected Lector lector;
    protected ListaSimple lista;

    public Compresor(String path) {
        lector = new Lector(path);
        lista = new ListaSimple();
    }

    public void llenarLista() {
        lector.leerArchivo();
        Enumeration<Character> caracteres = lector.getCaracteres();
        Enumeration<Integer> frecuencias = lector.getFrecuencias();

        while (caracteres.hasMoreElements() && frecuencias.hasMoreElements()) {
            lista.insertaEnOrden(frecuencias.nextElement(), caracteres.nextElement());
        }
    }

    public void comprimir() {
        Arbol arbol;
        if (!lista.hasNext()) {
            Nodo aux = lista.EliminaInicio();
            char x = (char) 32;
            NodoArbol raiz = new NodoArbol(0, x);
            raiz.setIzquierdo(new NodoArbol(aux.getValor(), aux.getDato()));
            arbol = new Arbol(raiz);
            lista.insertaEnOrden(arbol.getRaiz().getValor(), arbol);
        } else {
            while (lista.hasNext()) {
                if (lista.getinicio() instanceof Character) {
                    if (lista.getSiguiente() instanceof Character) {
                        Nodo aux1 = lista.EliminaInicio();
                        Nodo aux2 = lista.EliminaInicio();
                        char x = (char) 32;
                        NodoArbol raiz = new NodoArbol(aux1.getValor() + aux2.getValor(), x);
                        raiz.setIzquierdo(new NodoArbol(aux1.getValor(), aux1.getDato()));
                        raiz.setDerecho(new NodoArbol(aux2.getValor(), aux2.getDato()));
                        arbol = new Arbol(raiz);
                        lista.insertaEnOrden(arbol.getRaiz().getValor(), arbol);
                    } else if (lista.getSiguiente() instanceof Arbol) {
                        Nodo aux1 = lista.EliminaInicio();
                        Arbol aux2 = (Arbol) lista.EliminaInicio().getDato();
                        char x = (char) 32;
                        NodoArbol raiz = new NodoArbol((aux1.getValor() + aux2.getRaiz().getValor()), x);
                        raiz.setIzquierdo(new NodoArbol(aux1.getValor(), aux1.getDato()));
                        raiz.setDerecho(aux2.getRaiz());
                        arbol = new Arbol(raiz);
                        lista.insertaEnOrden(arbol.getRaiz().getValor(), arbol);
                    }
                } else if (lista.getinicio() instanceof Arbol) {
                    if (lista.getSiguiente() instanceof Character) {
                        Arbol aux1 = (Arbol) lista.EliminaInicio().getDato();
                        Nodo aux2 = lista.EliminaInicio();
                        char x = (char) 32;
                        NodoArbol raiz = new NodoArbol(aux1.getRaiz().getValor() + aux2.getValor(), x);
                        raiz.setIzquierdo(aux1.getRaiz());
                        raiz.setDerecho(new NodoArbol(aux2.getValor(), aux2.getDato()));
                        arbol = new Arbol(raiz);
                        lista.insertaEnOrden(arbol.getRaiz().getValor(), arbol);
                    } else if (lista.getSiguiente() instanceof Arbol) {
                        Arbol aux1 = (Arbol) lista.EliminaInicio().getDato();
                        Arbol aux2 = (Arbol) lista.EliminaInicio().getDato();
                        char x = (char) 32;
                        NodoArbol raiz = new NodoArbol(aux1.getRaiz().getValor() + aux2.getRaiz().getValor(), x);
                        raiz.setIzquierdo(aux1.getRaiz());
                        raiz.setDerecho(aux2.getRaiz());
                        arbol = new Arbol(raiz);
                        lista.insertaEnOrden(arbol.getRaiz().getValor(), arbol);
                    }
                }
            }
        }
    }

    public Lector getLector() {
        return lector;
    }

    public ListaSimple getLista() {
        return lista;
    }
}
