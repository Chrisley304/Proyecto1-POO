package Clases_Inscripcion;

import java.util.*;

public class Asignatura{
    String nombre;
    int clave;
    public int no_grupos;
    int creditos;
    boolean lab; //laboratorio extra
    //mejor ponerlo en la eleccion (main) o creacion de la asignatura
    String[] divisiones;
    char tipo; //teoría o laboratorio normal
    String division;

    public Asignatura(){

    }

    //Constructor
    public Asignatura(String nombre, int clave, int creditos,String division,char tipo, boolean lab){ // No entendi como funcionaba el tipo -C
        this.nombre = nombre;
        this.clave = clave;
        this.creditos = creditos;
        this.division = division;
        this.lab = lab;
        this.tipo = tipo;
        no_grupos = 0;
    }


    public void setNo_grupos(int no_grupos){ this.no_grupos = no_grupos;} // Set necesesario para una vez creados los grupos darle valor a la variable, (ej. aumentando en 1 en el main y pasandola como parametro en el set) -C

    public String getDivision(){
        return this.division;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getClave(){
        return this.clave;
    }

    public int getNoGrupos(){
        return this.no_grupos;
    }

    public int getCreditos(){
        return this.creditos;
    }

    public char getTipo(){
        return this.tipo;
    }

    public void setDivision(String division){
        this.division = division;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setClave(int clave){
        this.clave = clave;
    }

    public void setNoGrupos(int no_grupos){
        this.no_grupos = no_grupos;
    }

    public void setCreditos(int creditos){
        this.creditos = creditos;
    }

    public void setTipo(char tipo){
        this.tipo = tipo;
    }




	/*IDEA PARA DIVISIONES
    List<String> list = Arrays.asList(a);
  	System.out.println("The list is: " + list); */

    public void mostrarAsignatura(){
        System.out.println("ASIGNATURA: " + this.nombre);
        System.out.println("CLAVE: " + this.clave);
        System.out.println("NÚMERO DE GRUPOS EXISTENTES: " + this.no_grupos);
        System.out.println("CRÉDITOS: " + this.creditos);
        System.out.println("DIVISIÓN: " + this.division);
        System.out.println("TIPO: " + this.tipo);
        System.out.println();
    }



    //USO EXCLUSIVO DE INSCRIPCIÓN
    public static boolean existeAsignatura(int clave, ArrayList<Asignatura> materias ){

        for (Asignatura i : materias) {
            if(i.clave == clave)
                return true;
        }
        return false;
    }



     public static Asignatura obtenerMateria(int clave, ArrayList<Asignatura> materias ){

        //Asignatura a = new Asignatura();
        int i = 0;
        while(materias.get(i).getClave()!=clave){
            i++;
            //return materias.get(i)
        }
        return materias.get(i);
/*
        for(int i = 0;i<materias.size();i++){
            if(materias.get(i).getClave() == clave){
                a.setClave(materias.get(i).getClave());
                a.setTipo(materias.get(i).getTipo());
                a.setCreditos(materias.get(i).getCreditos());
                a.setNombre(materias.get(i).getNombre());
                a.setNoGrupos(materias.get(i).getNoGrupos());
                a.setDivision(materias.get(i).getDivision());  
                break; 
            }
            
        }
        return a;*/
    }
}
