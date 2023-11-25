/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab7p2_luisvarela;

/**
 *
 * @author Luis Andres Varela
 */
public class restaurante {

    private String nombre;
    private String ubicacion;
    private producto[] lista_p = new producto[3];
    private int saldo = 0;

    public restaurante() {
    }

    public restaurante(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        saldo = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public producto[] getLista_p() {
        return lista_p;
    }

    public void setLista_p(producto[] lista_p) {
        this.lista_p = lista_p;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return nombre ;
    }

}
