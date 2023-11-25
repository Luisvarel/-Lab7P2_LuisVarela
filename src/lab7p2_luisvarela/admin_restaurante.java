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
                bw.write("[nombre: "+t.getNombre()+", ubicacion: "+t.getUbicacion()+", Lista de producto: "+" Nombre: "+t.getLista_p()[0].getNombre()+", Precio: "+t.getLista_p()[0].getPrecio()+", "+t.getLista_p()[1]+", "+t.getLista_p()[2]+", saldo: "+t.getSaldo()+", ]");
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
               
                while (sc.hasNext()) {
                    String a="";
                    a+=sc.nextLine();
                    a=a.replace("[nombre:","");
                    a=a.replace("ubicacion:","");
                    a=a.replace("Lista de producto:","");
                    a=a.replace("Lista de producto:","");
                    a=a.replace("saldo:","");
                    a=a.replace("]","");
                    String []temp=a.split(",");
                    restaurante r=new restaurante(temp[0], temp[1]);
                    r.setSaldo(Integer.parseInt(temp[5]));
                    String[]lista_producto={temp[2],temp[3],temp[4]};
                    r.setLista_p(lista_producto);
                    listaPersonas.add(r);
                }
            } catch (Exception ex) {
            }
            sc.close();
        }//FIN IF
    }
}
