/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author MiguelAngel
 */
public class Escritor {
    private String path;
    
    public Escritor(String path){
        this.path = path;
    }
    
    public void escribir(Hashtable digitos, List<String> lista) throws IOException{
        BufferedWriter bw = new BufferedWriter(new FileWriter(path));
        for(String linea : lista){
            for(int i = 0; i < linea.length(); i++){
                bw.write((String) digitos.get(linea.charAt(i)));
            }
        }
        bw.close();
    }
}
