/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import controlador.Controlador;
import vista.ventanaCompresor;
import vista.ventanaResultados;

/**
 *
 * @author MiguelAngel
 */
public class Main {
    public static void main(String[] args) {
        ventanaCompresor ventanaInicial = new ventanaCompresor();
        ventanaResultados ventanaSecundaria = new ventanaResultados();
        Controlador controlador = new Controlador(ventanaInicial, ventanaSecundaria);
    }
}
