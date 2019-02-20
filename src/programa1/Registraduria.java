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
public class Registraduria {
    private ArrayList<Municipio> municipios;

    public Registraduria(ArrayList<Municipio> municipios) {
        this.municipios = municipios;
    }
    public ArrayList<Jurado> getJurados(){
        ArrayList<Jurado> juradosSalida=new ArrayList<>();
        for(Municipio municipio:this.getMunicipios()){
            for(Jurado jurado:municipio.getJurados()){
                juradosSalida.add(jurado);
            }
        }
        return juradosSalida;
    }
    
    public ArrayList<Jurado> getJuradosMunicipio(String nombre){
        ArrayList<Jurado> jurados=new ArrayList<>();
        for(Municipio municipio:this.getMunicipios()){
            if(municipio.getNombre()==nombre){ //Se comprobó que la condición sí se cumple y que los jurados del municipio no son nulos

                jurados=municipio.getJurados();
              //  System.out.println(municipio.getJurados().get(0).getNombre());
                return jurados;
            }
        }
        return jurados;
    }
    
    //Retorna lista de jurados que no asistieron a charlas
    public ArrayList<Jurado> getJuradosNoAsistencia(){
        ArrayList<Jurado> juradosSalida=new ArrayList<>();
        for(Municipio municipio: this.getMunicipios()){
            for(Jurado jurado:municipio.getJurados()){
                if(jurado.getSituacion().getCharla()==null){
                    juradosSalida.add(jurado);
                }
            }
        }
        return juradosSalida;
    }

    public ArrayList<Municipio> getMunicipios() {
        return municipios;
    }

    public void setMunicipios(ArrayList<Municipio> municipios) {
        this.municipios = municipios;
    }
    
    //Metodo para saber si una persona es jurado por su numero de cedula
    public Mesa esJurado(int n){ //Si esto retorna null, la persona no es jurado
        Mesa mesaSalida=new Mesa(null, null, null, null);
        boolean siEs=false;
        for(Municipio municipio:this.getMunicipios()){
            for(Empresa empresa:municipio.getEmpresa()){
                for(Persona persona: empresa.getPersonas()){
                    if(persona.getCedula()==n){
                       if(persona.getEsJurado()){
                           siEs=true;
                       } else return null;
                    }
                }
            }
        }
        
        if(siEs){
            for(Municipio municipio:this.getMunicipios()){
            for(Jurado jurado:municipio.getJurados()){
                    if(jurado.getCedula()==n){
                        mesaSalida=jurado.getMesa();
                    } else return null;   
            }
        }
        }
        return mesaSalida;
    }
    
    public static void main(String args[]){
        //Persona(String nombre, String direccion, int telefono, int cedula)
        Persona p1=new Persona("Mario", "Carrera 30", 7472674, 1234, 30);
        Persona p2=new Persona("Cecilia", "Calle 26", 6438506, 2345, 40);
        Persona p3=new Persona("Antonio", "Avenida Rojas", 6785985, 3456, 17);
        Persona p4=new Persona("Mariela", "Avenida Boyaca", 7594760, 4567, 35);
        Persona p5=new Persona("Julio", "Call 45", 6494649, 5678, 24);
        Persona viceP1M1=new Persona("Vicepresi", "Avenida Cali", 1234567, 6789, 36);
        Persona presiP1M1=new Persona("Presi", "Suba", 4058365, 7890, 67);
        Persona vocalP1M1=new Persona("Vocal", "La Gaitana", 5730579, 8901, 80);
        Persona[] jefesP1M1={presiP1M1, viceP1M1, vocalP1M1};
        //Persona p9=new Persona();
        //Persona p10=new Persona();
        
        
        ArrayList<Persona> personas= new ArrayList<>();
        personas.add(p5);
        personas.add(p4);
        personas.add(p3);
        personas.add(p2);
        personas.add(p1);
        
        
        Empresa empresa=new Empresa("Empresa x", "Calle 45", 986574, personas);
        
        ArrayList<Empresa> empresas1=new ArrayList<>();
        empresas1.add(empresa);
        
        PuestoVotacion puesto1=new PuestoVotacion("La Campiña", "6am a 6pm");
        puesto1.addMesa(presiP1M1, viceP1M1, vocalP1M1);
        
        //HASTA AQUÍ COMPROBADO QUE LA MESA HA SIDO AÑADIDA AL PUESTO CON LOS RESPECTIVOS DATOS: SE IMPRIMIO NOMBRE DE PRESI Y VICE
        
        ArrayList<PuestoVotacion> puestos1=new ArrayList<>();
        puestos1.add(puesto1);
        
        Municipio bogota=new Municipio("Bogota", puestos1, empresas1);
        
        //HASTA AQUI COMPROBADO QUE SE AÑADIÓ BIEN EL PUESTO DE VOTACION AL MUNICIPIO: SE IMPRIMIO HORARIO
        
        ArrayList<Municipio> municipios=new ArrayList<>();
        municipios.add(bogota);
        
        Registraduria registraduria1=new Registraduria(municipios);
                
        //HASTA AQUI COMPROBADO QUE LOS MUNICIPIOS FUERON GUARDADOS CORRECTAMENTE: SE IMPRIMIO EL NOMBRE DE UNA EMPRESA DEL MUNICIPIO BOGOTÁ
        
        //Suponiendo que los presidentes, vocales, etc, no son aleatorios y estan previamente escogidos
        //Aquí se añaden jurados una de la mesas de uno de los puestos de votación del municipio
       
        bogota.getPuestos().get(0).getMesas().get(0).setJurados(bogota.seleccionarJurados());
        //HASTA AQUÍ ESTÁ COMPROBADO
         
         //Aqui se le asigna la mesa a cada jurado
         for(Jurado jurado: registraduria1.getMunicipios().get(0).getPuestos().get(0).getMesas().get(0).getJurados()){
             jurado.setMesa(registraduria1.getMunicipios().get(0).getPuestos().get(0).getMesas().get(0));
         }
         //HASTA AQUI COMPROBADO
         
         
        
        //Aquí se le asigna una situacion a cada jurado
        Situacion situacion1=new Situacion();
        Situacion situacion2=new Situacion();
        Situacion situacion3=new Situacion();
        situacion1.addCharla(3, "20 de febrero");
        situacion2.addExcusa("Le dio traqueomingacecolisis");
        situacion3.addSancion(true, false, 800000);
        
        bogota.getPuestos().get(0).getMesas().get(0).getJurados()[0].setSituacion(situacion1);
        bogota.getPuestos().get(0).getMesas().get(0).getJurados()[1].setSituacion(situacion2);
        bogota.getPuestos().get(0).getMesas().get(0).getJurados()[2].setSituacion(situacion3);
        
     
        
        //Imprimiendo informacion de los jurados de uno de los municipios
        for(Jurado jurado: registraduria1.getJuradosMunicipio("Bogota")){
            System.out.println("Jurado: " + jurado.getNombre() + ", " + jurado.getDireccion()+ ", "+ jurado.getTelefono() + ", " + jurado.getCedula() + "Asignado: " + jurado.getAsignado());
        }
        
        //Imprimiendo nombres de los integrantes de una mesa
        System.out.println("");
        System.out.println("Presidente mesa 1: "+registraduria1.getMunicipios().get(0).getPuestos().get(0).getMesas().get(0).getPresi().getNombre());
        System.out.println("Vicepresidente mesa 1: "+registraduria1.getMunicipios().get(0).getPuestos().get(0).getMesas().get(0).getVice().getNombre());
        System.out.println("Vocal mesa 1: "+registraduria1.getMunicipios().get(0).getPuestos().get(0).getMesas().get(0).getVocal().getNombre());
        for(int n=0; n<3; n++){
            System.out.println("Jurado "+(n+1)+ " mesa "+ (n+1)+ ": "+registraduria1.getMunicipios().get(0).getPuestos().get(0).getMesas().get(0).getJurados()[n].getNombre());
        }
        
        }
}
