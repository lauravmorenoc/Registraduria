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
public class Mesa {
    protected Persona presi;
    protected Persona vice;
    protected Persona vocal;
    protected Jurado[] jurados;
    
    public Mesa(){
        
    }

    public Mesa(Persona presi, Persona mesa, Persona vocal){
        this.presi = presi;
        this.vice = mesa;
        this.vocal = vocal;
        this.jurados=new Jurado[3];
    }
    public Mesa(Persona presi, Persona mesa, Persona vocal, Jurado[] jurados) {
        this.presi = presi;
        this.vice = mesa;
        this.vocal = vocal;
        this.jurados = jurados;
        if(!(this.jurados==null)){
            for(int n=0; n<3; n++){
         this.jurados[n].setAsignado(true);
        }
        }
    }

    public Persona getPresi() {
        return presi;
    }

    public void setPresi(Persona presi) {
        this.presi = presi;
    }

    public Persona getVice() {
        return vice;
    }

    public void setVice(Persona vice) {
        this.vice = vice;
    }

    public Persona getVocal() {
        return vocal;
    }

    public void setVocal(Persona vocal) {
        this.vocal = vocal;
    }

    public Jurado[] getJurados() {
        return jurados;
    }

    public void setJurados(Jurado[] jurados) {
        this.jurados = jurados;
        for(int n=0; n<3; n++){
         this.jurados[n].setAsignado(true);
        }
        
    }
    
    public void asignarJefes(Persona[] jefes){
        this.presi=jefes[0];
        this.vice=jefes[1];
        this.vocal=jefes[2];
    }
}
