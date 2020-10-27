
import java.util.Scanner;
import Clases_Inscripciones.*;
import CodigoP4_Chris.Asignatura;
import CodigoP4_Chris.Profesor;

import java.util.*;

public class Proyecto1_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion,numAl=0,numAs=0,numProf=0,numGrupos=0;
        int n=0;
        
//        List<Alumno> listaAlumnos = new List<Alumno>;
//        List<Asignatura> listaMaterias = new List<Asignatura>;
//        List<Profesor> listaProfesores = new List<Profesor>;
        Hashtable <Integer, ArrayList<Grupo>> grupos = new Hashtable<>();
        
        System.out.println("**********  Proyecto 1: Sistema de Inscripciones  **********");
        do{
            System.out.println("MENÚ PRINCIPAL: \n1) Registar Alumnos\n2) Registrar Asignatura\n3) Registrar profesor\n4) Abrir nuevo grupo\n5) Inscribir alumno\n6) Mostrar elementos\n7) Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                
//                case 1:{
//                    String nombre,apellido,semestre,correo;
//                    int edad,numCuenta;
//                    numAl+=1;
//                    System.out.println("Ingrese los datos del alumno: ");
//                    System.out.println("Nombre: ");
//                    nombre = sc.nextLine();
//                    System.out.println("Apellido: ");
//                    apellido = sc.nextLine();
//                    System.out.println("Edad: ");
//                    edad = sc.nextInt();
//                    System.out.print("Numero de cuenta: ");
//                    numCuenta = sc.nextInt();
//                    System.out.print("Semestre: ");
//                    semestre = sc.nextLine();
//                    System.out.print("Correo electronico: ");
//                    correo = sc.nextLine();
//                    Alumno alumnos[numAl] = new Alumno(nombre, apellido, edad, numCuenta, semestre, correo);
//                    listaAlumnos.add(alumnos[numAl]);
//                }
                
//                case 2:{
//                    String nombre,division;
//                    boolean laboratorio;
//                    int clave,creditos;
//                    numAs+=1;
//                    System.out.println("Ingrese la información de la materia: ");
//                    System.out.println("Nombre: ");
//                    nombre = sc.nextLine();
//                    System.out.println("Clave: ");
//                    clave = sc.nextInt();
//                    System.out.println("Creditos: ");
//                    creditos= sc.nextInt();
//                    System.out.print("Division: ");
//                    division = sc.nextLine();
//                    System.out.print("La materia tiene Laboratorio(L+)? (True/False)");
//                    laboratorio = sc.nextBoolean();
//                    Asignatura asignaturas[numAs] = new Asignatura(nombre, clave, creditos, division, laboratorio);
//                    listaMaterias.add(asignaturas[numAs]);
//                }
                
//                case 3:{
//                    String nombre,apellido,titulo;
//                    int clave,creditos;
//                    numProf+=1;
//                    System.out.println("Ingrese la información del profesor: ");
//                    System.out.println("Nombre: ");
//                    nombre = sc.nextLine();
//                    System.out.println("Apellido: ");
//                    apellido = sc.nextLine();
//                    System.out.println("Titulo: ");
//                    titulo = sc.nextLine();
//                    Profesor profesores[numProf] = new Profesor(nombre, apellido, titulo);
//                    listaProfesores.add(profesores[numProf]);
//                }
                
                case 4: {
                    System.out.println("Ingresa la clave de la materia, de la cual se abrira el grupo: ");
                    int clave = sc.nextLine();
                    if (MetododevalidarMateria(clave)){ // Si existe la materia devuelve true
                        if (!grupos.containsKey(clave)){
                            ArrayList<Grupo> nuevogrup = new ArrayList<>();
                            grupos.put(clave, nuevogrup);
                        }
                        ArrayList<Grupo> lista = grupos.get(clave);
                        String horas, salon, dias;
                        int numDeGrupo;
                        numDeGrupo = temp.size() + 1;
                        System.out.println("Ingrese la información para abrir un grupo: ");
                        horas = Horario();
                        System.out.println("Dias: ");
                        dias = sc.nextLine();
                        System.out.println("Salon: ");
                        salon = sc.nextLine();
                        /*Mostrar lista de profesores
                          Asignar profesor

                          Mostrar lista de Asignaturas
                          Asignar Asignatura
                         */            //El profesor y la materia provienen de la lista de esas clases
                        lista.add(new Grupo(numDeGrupo, horas, dias, salon, profe, materia));
                        grupos.replace(clave, lista); //Se reemplaza la lista con menos datos con la nueva con mas datos
                    }else{
                        System.out.println("La materia ingresada no existe :(");
                    }
                }
                case 5:{
                    //Inscribir alumnos
                    //    Mostrar grupos
                    //    Pedir número de cuenta y clave de grupo
                }
                case 6:{
                    //Mostrar lista de alumnos regitrados
                    //Mostrar lista de alumnos inscritos
                    //Mostrar lista de asignaturas
                    //Mostrar lista de profesores
                    //Mostrar lista de grupos
                }
            }
        }while (opcion != 7);
        sc.close();
    }

    static String Horario(){
        int opcion;
        String horas = new String();
        while (horas.isEmpty()){
            System.out.println("Por favor seleccione uno de los siguientes horarios:\n1) 7:00-9:00\n2) 9:00-11:00\n3) 11:00-13:00\n4) 13:00-15:00\n5) 15:00-17:00\n6) 17:00-19:00\n7) 19:00-21:00\n8) 21:00-23:00\n");
            opcion = sc.nextInt();
            switch (opcion){
                case 1:{
                    horas ="7:00-9:00";
                }break;

                case 2:{
                    horas ="9:00-11:00";
                }break;

                case 3:{
                    horas ="11:00-13:00";
                }break;

                case 4:{
                    horas ="13:00-15:00";
                }break;

                case 5:{
                    horas ="15:00-17:00";
                }break;

                case 6:{
                    horas ="17:00-19:00";
                }break;

                case 7:{
                    horas ="19:00-21:00";
                }break;

                case 8:{
                    horas ="21:00-23:00";
                }break;

                default:{
                    System.out.println("Por favor elige una opcion correcta");
                }break;
            }
        }
        return horas;
    }
}

