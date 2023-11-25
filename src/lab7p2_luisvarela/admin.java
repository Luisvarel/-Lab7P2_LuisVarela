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
public class admin {

    private ArrayList<usuario> listaPersonas = new ArrayList();
    private File archivo = null;

    public admin(String path) {
        archivo = new File(path);
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public ArrayList<usuario> getListaUsuarios() {
        return listaPersonas;
    }

    public void setListaPersonas(ArrayList<usuario> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

    @Override
    public String toString() {
        return "listaPersonas=" + listaPersonas;
    }

    //extra mutador
    public void setusuario(usuario p) {
        this.listaPersonas.add(p);
    }

    //metodos de administracion
    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (usuario t : listaPersonas) {
                bw.write("[nombre: " + t.getNombre() + ", usuario: " + t.getUsuario() + ", contraseña: " + t.getContrasena() + ", saldo: "+ t.getSaldo()+", ]");
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
                    String a = "";
                    a += sc.nextLine();
                    a = a.replace("saldo:", "");
                    a = a.replace("[nombre:", "");
                    a = a.replace("]", "");
                    a = a.replace("usuario:", "");
                    a = a.replace("contraseña:", "");
                    a = a.replace("saldo:", "");
                    String[] temp = a.split(",");
                    usuario temp1=new usuario(temp[0], temp[1], temp[2]);
                    temp1.setSaldo(Integer.parseInt(temp[3]));
                    listaPersonas.add(new usuario(temp[0], temp[1], temp[2]));
                }
            } catch (Exception ex) {
            }
            sc.close();
        }//FIN IF
    }

}
