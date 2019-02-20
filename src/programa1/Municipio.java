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
public class Municipio {
    private String nombre;
    private ArrayList<PuestoVotacion> puestos;
    private ArrayList<Jurado> jurados;
    private ArrayList<Empresa> empresas;

    public Municipio(String nombre, ArrayList<PuestoVotacion> puestos, ArrayList<Empresa> empresa) {
        this.nombre = nombre;
        this.puestos = puestos;
        this.empresas = empresa;
        this.jurados=new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<PuestoVotacion> getPuestos() {
        return puestos;
    }

    public ArrayList<Jurado> getJurados() {
        for(PuestoVotacion puestos_:this.puestos){
            if(!(puestos_.getMesas()==null)){
            for(Mesa mesa:puestos_.getMesas()){
                for(int n=0; n<3; n++){//Comprobado imprimiendo el nombre del jurado
                    this.jurados.add(mesa.getJurados()[n]);//agregando los jurados de las mesas de los puestos al municipio
                }
            }
        }
    }
        return this.jurados;
    }

    public ArrayList<Empresa> getEmpresas() {
        return empresas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPuestos(ArrayList<PuestoVotacion> puestos) {
        this.puestos = puestos;
    }

    public void setEmpresa(ArrayList<Empresa> empresa) {
        this.empresas = empresa;
    }

    public void setJurados(ArrayList<Jurado> jurados) {
        this.jurados = jurados;
    }

    public void setEmpresas(ArrayList<Empresa> empresas) {
        this.empresas = empresas;
    }
    
    public Jurado[] seleccionarJurados(){ //Este metodo escoge tres jurados destinados a una mesa
        
        Jurado[] juradosSalida=new Jurado[3];
        int[] cedulas;
        int tamañoArregloCedulas=0;
        int contador1=0;
        int contador2=0;
        for(Empresa empresa:this.empresas){
            if(empresa.getPersonas()!=null) {tamañoArregloCedulas+=empresa.getPersonas().size();}
            //PROCESO COMPROBADO
        }
        cedulas=new int[tamañoArregloCedulas];
        //PROCESO COMPROBADO
        
        
        for(Empresa empresa: this.empresas){ //Tengase en cuenta que el registro de 
            //personas en cada empresa puede cambiar, así que no siempre se elegiran personas
            //de las primeras empresas guardadas en el arreglo del municipio
  
            //Lo siguiente se hace para escoger tres personas al azar;
            if(contador2<3){
            for(Persona persona: empresa.getPersonas()){ 
                cedulas[contador1]=persona.getCedula();
                //PROCESO COMPROBADO                
                contador1++;
            }
                //PROCESO COMPROBADO
                
                int variable=0;
                while((contador2<3)&&(variable<cedulas.length)){
                for(Persona persona: empresa.getPersonas()){ 
                    variable=(int)(Math.random()*(cedulas.length));
                    if(variable!=0){
                        variable--;
                    }
                if(persona.getCedula()==cedulas[variable]){
                    if((!persona.getEsJurado())&&(contador2<3)&&(persona.getEdad()>17)&&juradosSalida[contador2]==null){
                    Jurado jurado=new Jurado(persona.getNombre(), persona.getDireccion(), persona.getTelefono(), persona.getCedula(), persona.getEdad());
                    juradosSalida[contador2]=jurado;
                    persona.setEsJurado(true);
                    contador2++;
                }
                }
                }
                }   
            }
        
        }
        return juradosSalida;
    }
    
}
