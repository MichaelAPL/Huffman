/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MiguelAngel
 */
public class Lector {

    protected String path;
    private List<String> lista;
    protected Hashtable hashTable;
    
    public List getLista(){
        return this.lista;
    }

    public Lector(String path) {
        this.path = path;
        hashTable = new Hashtable(93);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Hashtable getHashTable() {
        return hashTable;
    }

    public void leerArchivo() {
        try {
            lista = Files.readAllLines(Paths.get(path));
            int frecuencia, j;
            for (String linea : lista) {
                for (int i = 33; i < 126; i++) {
                    frecuencia = 0;
                    for (j = 0; j < linea.length(); j++) {
                        if ((int) linea.charAt(j) == i) {
                            frecuencia++;
                        }
                    }
                    if (frecuencia > 0) {
                        char c = (char) i;
                        hashTable.put(c, frecuencia);
                    }
                }
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error en la lectura del archivo. Verifique la ruta de origen", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public Enumeration getCaracteres(){
        Enumeration<Character> llaves = hashTable.keys();
        return llaves; 
    }
    
    public Enumeration getFrecuencias(){
        Enumeration<Integer> enumeration = hashTable.elements();
        return enumeration;
    }
}
