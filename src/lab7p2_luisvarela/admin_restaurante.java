/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7p2_luisvarela;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Luis Andres Varela
 */
public class admin_restaurante {

    private ArrayList<restaurante> listaPersonas = new ArrayList();
    private File archivo = null;

    public admin_restaurante(String path) {
        archivo = new File(path);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public ArrayList<restaurante> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<restaurante> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    @Override
    public String toString() {
        return "listaPersonas=" + listaPersonas;
    }

    //extra mutador
    public void setPersona(restaurante p) {
        this.listaPersonas.add(p);
    }

    //metodos de administracion
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (restaurante t : listaPersonas) {
                bw.write("[ nombre: "+t.getNombre()+", ubicacion: "+t.getUbicacion()+", Lista de producto: "+t.getLista_p()[0]+", "+t.getLista_p()[1]+", "+t.getLista_p()[2]+", saldo: "+t.getSaldo()+", ]");
            }
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner sc = null;
        listaPersonas = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                String a="[ nombre: "+t.getNombre()+", ubicacion: "+t.getUbicacion()+", Lista de producto: "+t.getLista_p()[0]+", "+t.getLista_p()[1]+", "+t.getLista_p()[2]+", saldo: "+t.getSaldo()+", ]";
                sc.useDelimiter(";");
                while (sc.hasNext()) {
                    listaPersonas.add(new restaurante(sc.next(), sc.next()));
                }
            } catch (Exception ex) {
            }
            sc.close();
        }//FIN IF
    }
}
