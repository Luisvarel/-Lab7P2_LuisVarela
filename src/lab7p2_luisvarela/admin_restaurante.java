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
                bw.write("[nombre: "+t.getNombre()+", ubicacion: "+t.getUbicacion()+", Lista de producto: "+" Nombre: "+t.getLista_p()[0].getNombre()+", Precio: "+t.getLista_p()[0].getPrecio()+", Nombre: "+t.getLista_p()[1].getNombre()+", Precio: "+t.getLista_p()[1].getPrecio()+", Nombre: "+t.getLista_p()[2].getNombre()+", Precio: "+t.getLista_p()[2].getPrecio()+", saldo: "+ t.getSaldo()+", ]"); 
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
                    a=a.replace("Nombre:", "");
                    a=a.replace("Precio:", "");
                    a=a.replace("saldo:", "");
                    String []temp=a.split(",");
                    restaurante r=new restaurante(temp[0], temp[1]);
                    producto p1=new producto(temp[2], Integer.parseInt(temp[3]));
                    producto p2=new producto(temp[4], Integer.parseInt(temp[5]));
                    producto p3=new producto(temp[6], Integer.parseInt(temp[7]));
                    producto[]lista_producto={p1,p2,p3};
                    r.setLista_p(lista_producto);
                    r.setSaldo(Integer.parseInt(temp[8]));
                    listaPersonas.add(r);
                }
            } catch (Exception ex) {
            }
            sc.close();
        }//FIN IF
    }
}
