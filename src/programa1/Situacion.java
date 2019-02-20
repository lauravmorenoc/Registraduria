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
public class Situacion {
    private Charla charla;
    private Excusa excusa;
    private Sancion sancion;

    public Situacion() {
    }
    public void addCharla(double duracion, String fecha){
        Charla charla_=new Charla(duracion, fecha);
        charla=charla_;
    }
    public void addExcusa(String descripcion){
        Excusa excusa_=new Excusa(descripcion);
        excusa=excusa_;
    }
    public void addSancion(boolean asistencia, boolean abandono, double valor){
        Sancion sancion_=new Sancion(asistencia, abandono, valor);
        sancion=sancion_;
    }

    public Charla getCharla() {
        return charla;
    }

    public Excusa getExcusa() {
        return excusa;
    }

    public Sancion getSancion() {
        return sancion;
    }
    
    
}
