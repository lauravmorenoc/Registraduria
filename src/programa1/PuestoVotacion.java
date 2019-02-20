/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package programa1;

import java.util.ArrayList;

/**
 *
 * @author Laura M
 */
public class PuestoVotacion {
    private String direccion;
    private String horario;
    private ArrayList<Mesa> mesas;

    public PuestoVotacion(String direccion, String horario) {
        this.direccion = direccion;
        this.horario = horario;
        this.mesas=new ArrayList<>();
    }
    
    public void addMesa(Persona presi, Persona vice, Persona vocal){
        Mesa mesa=new Mesa(presi, vice, vocal);
        mesas.add(mesa);
    }
    
    public void addMesa(Persona presi, Persona vice, Persona vocal, Jurado[] jurados){
        Mesa mesa=new Mesa(presi, vice, vocal, jurados);
        mesas.add(mesa);
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public ArrayList<Mesa> getMesas() {
        return mesas;
    }
    
}
