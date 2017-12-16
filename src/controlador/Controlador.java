/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Modelo.Compresor;
import Modelo.Escritor;
import arbol.Arbol;
import arbol.NodoArbol;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import vista.ventanaCompresor;
import vista.ventanaResultados;

/**
 *
 * @author MiguelAngel
 */
public class Controlador {

    private ventanaCompresor ventanaInicial;
    private ventanaResultados ventanaResultados;
    private Compresor compresor;

    public Controlador(ventanaCompresor ventana, ventanaResultados ventana2) {
        this.ventanaInicial = ventana;
        this.ventanaResultados = ventana2;
        inicializarVentanaCompresor();
        this.ventanaInicial.setVisible(true);
    }

    private void inicializarVentanaCompresor() {
        this.ventanaInicial.getOrigenButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser explorador = new JFileChooser();
                explorador.setDialogTitle("Abrir fichero");
                explorador.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
                int seleccion = explorador.showDialog(null, "Abrir");
                String path = "";
                switch (seleccion) {
                    case JFileChooser.APPROVE_OPTION:
                        path = explorador.getSelectedFile().getPath();
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    case JFileChooser.ERROR_OPTION:
                        break;
                }
                ventanaInicial.getOrigenTF().setText(path);
            }
        });

        this.ventanaInicial.getDestinoButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser explorador = new JFileChooser();
                explorador.setDialogTitle("Abrir fichero");
                explorador.setFileFilter(new FileNameExtensionFilter("TEXT FILES", "txt", "text"));
                int seleccion = explorador.showDialog(null, "Abrir");
                String path = "";
                switch (seleccion) {
                    case JFileChooser.APPROVE_OPTION:
                        path = explorador.getSelectedFile().getPath();
                        break;
                    case JFileChooser.CANCEL_OPTION:
                        break;
                    case JFileChooser.ERROR_OPTION:
                        break;
                }
                ventanaInicial.getDestinoTF().setText(path);
            }
        });

        this.ventanaInicial.getOperarButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                compresor = new Compresor(ventanaInicial.getOrigenTF().getText());
                compresor.llenarLista();
                compresor.comprimir();
                Arbol arbol = (Arbol) compresor.getLista().getinicio();
                ArrayList hojas = arbol.getHojas();
                Hashtable table = new Hashtable(hojas.size());
                Escritor escritor = new Escritor(ventanaInicial.getDestinoTF().getText());
                for (int i = 0; i < hojas.size(); i++) {
                    NodoArbol tmp = (NodoArbol) hojas.get(i);
                    ArrayList ruta = arbol.getRuta(tmp.getDato(), arbol.getRaiz());
                    String rutas = arbol.getStringRuta(ruta);
                    table.put(tmp.getDato(), rutas);
                }
                try {
                    escritor.escribir(table, compresor.getLector().getLista());
                    JOptionPane.showMessageDialog(null, "El archivo ha sido comprimido en el destino especificado");
                    inicializarVentanaResultados();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la escritura del archivo, verifique la ruta Destino", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        ventanaInicial.getSalirButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void inicializarVentanaResultados() {
        DefaultTableModel modelo;
        String cabecera[] = {"Dígito", "Frecuencia", "Código"};
        String datos[][] = {};
        modelo = new DefaultTableModel(datos, cabecera);

        ventanaResultados.getjTable().setModel(modelo);

        Arbol arbol = (Arbol) compresor.getLista().getinicio();
        ArrayList hojas = arbol.getHojas();
        Hashtable table = new Hashtable(hojas.size());
        for (int i = 0; i < hojas.size(); i++) {
            NodoArbol tmp = (NodoArbol) hojas.get(i);
            ArrayList ruta = arbol.getRuta(tmp.getDato(), arbol.getRaiz());
            String rutas = arbol.getStringRuta(ruta);
            table.put(tmp.getDato(), rutas);
        }
        
        for(int i = 0; i < hojas.size(); i++){
            NodoArbol tmp = (NodoArbol) hojas.get(i);
            Object row[] = {tmp.getDato(), tmp.getValor(), table.get(tmp.getDato())};
            modelo.addRow(row);
        }
        
        this.ventanaResultados.getAceptarButton().addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ventanaResultados.hide();
            }      
        });
        
        this.ventanaResultados.setVisible(true);
    }
}
