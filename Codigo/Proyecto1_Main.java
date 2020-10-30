
import java.util.Scanner;
import Clases_Inscripciones.*;

import java.util.*;

public class Proyecto1_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;//,numAl=0,numAs=0,numProf=0,numGrupos=0;
//        int n=0;  <-- Esta variable nunca se ocupa xd -C
        
        ArrayList<Alumno> alumnos_registrados = new ArrayList<>();
        ArrayList<Asignatura> listaMaterias = new ArrayList<>();
        HashSet<Profesor> LisProfesores = new HashSet<>();
        Hashtable <Integer, ArrayList<Grupo>> grupos = new Hashtable<>();
        
        System.out.println("**********  Proyecto 1: Sistema de Inscripciones  **********");
        do{
            System.out.println("MENÚ PRINCIPAL: \n1) Registar Alumnos\n2) Registrar Asignatura\n3) Registrar profesor\n4) Abrir nuevo grupo\n5) Inscribir alumno\n6) Mostrar elementos\n7) Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                
                case 1:{
                    String nombre,apellido,semestre,correo;
                    int edad,numCuenta;
                    System.out.println("Ingrese los datos del alumno: ");
                    System.out.println("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Apellido: ");
                    apellido = sc.nextLine();
                    System.out.println("Edad: ");
                    edad = sc.nextInt();
                    System.out.println("Numero de cuenta: ");
                    numCuenta = sc.nextInt();
                    System.out.println("Semestre: ");
                    semestre = sc.nextLine();
                    System.out.println("Correo electronico: ");
                    correo = sc.nextLine();
                    alumnos_registrados.add(numCuenta, new Alumno(nombre, apellido, edad, numCuenta, semestre, correo));
                }
                
                case 2:{
                    String nombre,division;
                    boolean laboratorio;
                    int clave,creditos;
//                    numAs+=1;         No se porque esta esta variable -C
                    System.out.println("Ingrese la información de la materia: ");
                    System.out.println("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Clave: ");
                    clave = sc.nextInt();
                    System.out.println("Creditos: ");
                    creditos= sc.nextInt();
                    System.out.print("Division: ");
                    division = sc.nextLine();
                    System.out.print("La materia tiene Laboratorio(L+)? (si/no)");
                    String siono = sc.nextLine();
                    laboratorio = siono.equals("si");   //Al equals ser un método que devuelve un boolean, si ves verdadera, la variable sera true y viceversa
//                    Asignatura[numAs] asignaturas = new Asignatura(nombre, clave, créditos, division, laboratorio);
                    listaMaterias.add(new Asignatura(nombre, clave, creditos, division, laboratorio));
                }

                case 3:{
                    String nombre,apellido,titulo;
                    System.out.println("Ingrese la información del profesor: ");
                    System.out.println("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Apellido: ");
                    apellido = sc.nextLine();
                    System.out.println("Grado academico: ");
                    titulo = sc.nextLine();

                    Profesor prof = new Profesor(nombre,apellido,titulo);
                    LisProfesores.add(prof);
                }
                
                case 4: {   // FALTA incluir la forma de elegir el profesor para la materia
                    System.out.println("Ingresa la clave de la materia, de la cual se abrira el grupo: ");
                    int clave = sc.nextInt();
                    if (Asignatura.existeAsignatura(clave,listaMaterias)){ // Si existe la materia devuelve true
                        if (!grupos.containsKey(clave)){        // Hash = { 1890: {}, 65655: { 1: 2 2 6 6 }  5526: {}  }
                            ArrayList<Grupo> nuevogrup = new ArrayList<>();
                            grupos.put(clave, nuevogrup);
                        }
                        ArrayList<Grupo> lista = grupos.get(clave);
                        String horas, salon;
                        int numDeGrupo;
                        numDeGrupo = lista.size() + 1;
                        System.out.println("Ingrese la información para abrir un grupo: ");
                        horas = Horario();
                        ArrayList<String> dias = Dias();
                        System.out.println("Salon: ");
                        salon = sc.nextLine();
                        Asignatura materia = listaMaterias.get(clave);
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
                    System.out.println("\t1) Mostrar lista de alumnos regitrados\n\t2) Mostrar lista de asignaturas\n\t3) Mostrar lista de profesores\n\t4) Mostrar lista de grupos");
                    int subop = sc.nextInt();
                    switch (subop){

                        case 1: {//Mostrar lista de alumnos registrados
                            //for (int i = 0; i<)
                        }break;

                        //Mostrar lista de alumnos inscritos

                        case 2: {//Mostrar lista de asignaturas
                        }break;

                        case 3: {//Mostrar lista de profesores
                            int j =1;
                            for (Profesor i : LisProfesores) {
                                System.out.printf("Profesor %d:",j);
                                i.MostrarProfesor();
                                j++;
                            }
                        }break;
                        case 4:{//Mostrar lista de grupos
                            // get keys() from Hashtable and iterate
                            Enumeration<Integer> llaves = grupos.keys();
                            while(llaves.hasMoreElements()) {
                                Integer key = llaves.nextElement();
                                ArrayList<Grupo> temp = grupos.get(key);    // Obtiene la lista de grupos por materia
                                Grupo materia = temp.get(0);
                                materia.materia.mostrarAsignatura(); // Muestra la información de la materia de los grupos a mostrar
                                for (Grupo k: temp) { // Muestra la información de la lista anterior por grupo
                                    k.MostrarGrupo();
                                }
                            }
                        }
                    }
            }
        }

    }while(opcion != 7);
        sc.close();
    } // Fin del Main

    static public String Horario(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        String horas = "";
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
        sc.close();
        return horas;
    }

    static public ArrayList<String> Dias(){
        Scanner sc = new Scanner(System.in);
        int opcion, num;
        ArrayList<String> dias = new ArrayList<>();
        System.out.print("Ingrese el numero de dias que se lleva la materia a la semana:  ");
        num = sc.nextInt();
        while (dias.size() != num){
            System.out.printf("Seleccione el dia %d: \n\t1) Lunes\n\t2) Martes\n\t3) Miercoles\n\t4) Jueves\n\t5) Viernes\n\t6) Sabado\n\t",dias.size()+1);
            opcion = sc.nextInt();
            switch (opcion){
                case 1:{
                    dias.add("Lunes");
                }break;

                case 2:{
                    dias.add("Martes");
                }break;

                case 3:{
                    dias.add("Miercoles");
                }break;

                case 4:{
                    dias.add("Jueves");
                }break;

                case 5:{
                    dias.add("Viernes");
                }break;

                case 6:{
                    dias.add("Sabado");
                }break;

                default:{
                    System.out.println("Por favor elige una opcion correcta");
                }break;
            }
        }
        sc.close();
        return dias;
    }

}   //Fin de la Clase

