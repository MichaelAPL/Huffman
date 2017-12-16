/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arbol;

import Modelo.lista.Nodo;
import java.util.ArrayList;

/**
 *
 * @author MiguelAngel
 */
public class Arbol {

    protected NodoArbol raiz;

    public Arbol() {
        this.raiz = null;
    }

    public Arbol(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public NodoArbol getRaiz() {
        return raiz;
    }

    public void setRaiz(NodoArbol raiz) {
        this.raiz = raiz;
    }

    public void insertar(NodoArbol nuevo, NodoArbol pivote) {
        if (this.raiz == null) {
            raiz = nuevo;
        } else if (nuevo.getValor() <= pivote.getValor()) {
            if (pivote.getIzquierdo() == null) {
                pivote.setIzquierdo(nuevo);
            } else {
                insertar(nuevo, pivote.getIzquierdo());
            }
        } else if (pivote.getDerecho() == null) {
            pivote.setDerecho(nuevo);
        } else {
            insertar(nuevo, pivote.getDerecho());
        }
    }
    
    public ArrayList getHojas(){
        ArrayList hojas = new ArrayList<NodoArbol>();
        return getHojas(raiz, hojas);
    }
    
    private ArrayList getHojas(NodoArbol pivote, ArrayList hojas){
        if(pivote != null){
            if(pivote.getIzquierdo() == null){
                hojas.add(pivote);
            }
            getHojas(pivote.getIzquierdo(), hojas);
            getHojas(pivote.getDerecho(), hojas);
        }
        return hojas;
    }
    
    public String getStringRuta(ArrayList array){
        String ruta = "";
        for(int i = 0; i < array.size(); i++){
            ruta = ruta.concat((String)array.get(i));
        }
        return ruta;
    }
    
    public ArrayList getRuta(Object digito, NodoArbol pivote){
        ArrayList ruta = new ArrayList<>();
        Found found = new Found();
        getRuta(ruta, pivote, digito, found);
        return ruta;
    }

    private void getRuta(ArrayList ruta, NodoArbol pivote, Object digito, Found found){
        if(found.isFound() == false){
            if(pivote != null && pivote.getIzquierdo()!=null){
                ruta.add("0");
                getRuta(ruta, pivote.getIzquierdo(), digito, found);
                if(found.isFound() == false){
                    ruta.remove(ruta.size() - 1);
                    ruta.add("1");
                    getRuta(ruta, pivote.getDerecho(), digito, found);
                    if(found.isFound() == false){
                        ruta.remove(ruta.size() - 1);
                    }
                }
            }else{
                if(pivote.getDato() == digito){
                    found.setFound(true);
                }
            }
        }
    }
}
