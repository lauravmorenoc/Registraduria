/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa1;

/**
 *
 * @author Laura M
 */
public class Jurado extends Persona{
    private Mesa mesa;
    private Situacion situacion;
    private boolean asignado;

    public Jurado(String nombre, String direccion, int telefono, int cedula, int edad) {
        super(nombre, direccion, telefono, cedula, edad);
        this.asignado=false;
        this.mesa=new Mesa();
        this.situacion=new Situacion();
    }
    
    public Jurado(Mesa mesa, Situacion situacion, String nombre, String direccion, int telefono, int cedula, int edad) {
        super(nombre, direccion, telefono, cedula, edad);
        this.mesa = mesa;
        this.situacion = situacion;
        this.asignado=false;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Situacion getSituacion() {
        return situacion;
    }

    public void setSituacion(Situacion situacion) {
        this.situacion = situacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public boolean getAsignado() {
        return asignado;
    }

    public void setAsignado(boolean asignado) {
        this.asignado = asignado;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
        
}
