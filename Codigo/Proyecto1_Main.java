import java.util.Scanner;
import Clases_Inscripcion.*;

import java.util.*;

public class Proyecto1_Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        // Declaración de listas:
        Map<Integer, Alumno> alumnos_registrados = new HashMap<>();
        ArrayList<Asignatura> listaMaterias = new ArrayList<>();
        HashSet<Profesor> LisProfesores = new HashSet<>();
        Hashtable <Integer, ArrayList<Grupo>> grupos = new Hashtable<>();
        
        System.out.println("**********  Proyecto 1: Sistema de Inscripciones  **********");
        do{
            System.out.println("\nMENÚ PRINCIPAL: \n1) Registar Alumnos\n2) Registrar Asignatura\n3) Registrar profesor\n4) Abrir nuevo grupo\n5) Inscribir alumno\n6) Mostrar elementos\n7) Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion) {

                case 1: {
                    String nombre, apellido, semestre, correo;
                    int edad, numCuenta;
                    System.out.println("Ingrese los datos del alumno: ");
                    System.out.println("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Apellido: ");
                    apellido = sc.nextLine();
                    System.out.println("Edad: (0-100) ");
                    edad = sc.nextInt();
                    while (edad < 0 || edad>100){
                        System.out.print("La edad, no es correcta, por favor intentelo de nuevo\n Edad: ");
                        edad = sc.nextInt();
                    }
                    System.out.println("Numero de cuenta (9 digitos): ");
                    numCuenta = sc.nextInt();
                    while (String.valueOf(numCuenta).length() != 9){
                        System.out.print("El numero de cuenta, no es correcto, por favor intentelo de nuevo\n Num de cuenta: ");
                        numCuenta = sc.nextInt();
                    }
                    System.out.println("Semestre: ");
                    sc.nextLine();
                    semestre = sc.nextLine();
                    System.out.println("Correo electronico: ");
                    correo = sc.nextLine();
                    while (correo.indexOf('@') == -1) {
                        System.out.print("El correo, no es correcto, debe incluir '@' para ser correcto. Por favor intentelo de nuevo\n Correo: ");
                        correo = sc.nextLine();
                    }
                    alumnos_registrados.put(numCuenta, new Alumno(nombre, apellido, edad, semestre, correo));
                    break;
                }

                case 2: { // Registrar Asignatura
                    String nombre, division;
                    boolean laboratorio;
                    int clave, creditos;

                    System.out.println("Ingrese la información de la materia: ");
                    System.out.println("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Clave: (4 digitos)");
                    clave = sc.nextInt();
                    while ( (String.valueOf(clave)).length() != 4) {
                        System.out.print("La clave, no es correcta, esta debe ser de 4 digitos. Por favor intentelo de nuevo\n Clave: ");
                        clave = sc.nextInt();
                    }
                    System.out.println("Creditos: ");
                    creditos = sc.nextInt();
                    while (creditos < 0 || creditos > 20){
                        System.out.print("Lo sentimos, los creditos no pueden ser negativos ni mayores a 20, Intentalo de nuevo\nCreditos: ");
                        creditos = sc.nextInt();
                    }
                    System.out.print("Seleccione una division: \n");
                    String[] divisiones = new String[] { "Division de Ciencias Basicas", "Division de Ingenierias Civil y Geomatica", "Division de Ingenieria Electrica", "Division de Ingenieria en Ciencias de la Tierra","Division de Ingenieria Mecanica e Industrial","Division de Ciencias Sociales y Humanidades","Division de Educacion Continua y a Distancia"};

                    for (int i = 0; i < divisiones.length; i++) {
                        System.out.printf("%d) %s\n",i+1,divisiones[i]);
                    }
                    System.out.print("Opcion: ");
                    int d = sc.nextInt();
                    while (d < 1 || d > divisiones.length){
                        System.out.print("Por favor elige una opcion correcta\nOpcion: ");
                        d = sc.nextInt();
                    }
                    division = divisiones[d-1];
                    System.out.print("La materia tiene Laboratorio(L+)? (si/no) :  ");
                    sc.nextLine();
                    String siono = sc.nextLine();
                    System.out.println();
                    siono = siono.toLowerCase();
                    laboratorio = siono.equals("si");

                    Asignatura asig = new Asignatura(nombre, clave, creditos, division, 'T' ,laboratorio);
                    listaMaterias.add(asig);
                    if (laboratorio) {
                        int claveLab;
                        String nombreLab;
                        //Se le suma 5000 porque asi es la inscripción en la facultad
                        claveLab = clave + 5000;
                        nombreLab = "Laboratorio de " + nombre;
                        Asignatura asigLab = new Asignatura(nombreLab, claveLab, creditos, division, 'L', false);
                        listaMaterias.add(asigLab);
                    }
                }break;

                case 3: { // Registrar profesor
                    String nombre, apellido, titulo;
                    System.out.println("Ingrese la información del profesor: ");
                    System.out.println("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Apellido: ");
                    apellido = sc.nextLine();
                    System.out.println("Grado academico: ");
                    titulo = sc.nextLine();

                    Profesor prof = new Profesor(nombre, apellido, titulo);
                    LisProfesores.add(prof);
                    break;
                }

                case 4: {   // Registrar grupo
                    if (!LisProfesores.isEmpty()){ // Se verifica si hay profesores registrados, ya que no se pueden crear grupos sin profesores
                        System.out.println("Ingresa la clave de la materia, de la cual se abrira el grupo: ");
                        int clave = sc.nextInt();
                        if (Asignatura.existeAsignatura(clave, listaMaterias)) { // Si existe la materia devuelve true
                            if (!grupos.containsKey(clave)) {
                                ArrayList<Grupo> nuevogrup = new ArrayList<>();
                                grupos.put(clave, nuevogrup);
                            }

                            ArrayList<Grupo> lista = grupos.get(clave);
                            String horas, salon;
                            int numDeGrupo = lista.size() + 1;
                            System.out.println("Ingrese la información para abrir un grupo: ");
                            horas = Horario();
                            ArrayList<String> dias = Dias();
                            System.out.println("Salon: ");
                            sc.nextLine();
                            salon = sc.nextLine();
                            int k = 0;
                            System.out.println("Por favor elija uno de los siguientes profesores\nNota: Si se requiere ver la informacion del profesor, favor de ir a la opcion para hacerlo (6)\n");
                            for (Profesor i : LisProfesores){ // Mostrar profesores disponible
                                k++;
                                System.out.println( k +") Profesor " + i.getNombre() + " " + i.getApellido());
                            }
                            int opcionProf = sc.nextInt();
                            while (opcionProf > k || opcionProf<1){
                                System.out.println("La opcion ingresada es incorrecta, por favor ingrese una correcta:");
                                opcionProf = sc.nextInt();
                            }
                            k=1;
                            Profesor profe = null;
                            for (Profesor i : LisProfesores){ // Mostrar profesores disponible
                                if (k == opcionProf){
                                    profe = i;
                                    break;
                                }
                                k++;
                            }

                            //OBJETO ASIGNATURA QUE CORRESPONDA A LA CLAVE DEL USUARIO
                            lista.add(new Grupo(numDeGrupo, horas, dias, salon, profe, Asignatura.obtenerMateria(clave,listaMaterias))); //ES ESTE EL PROBLEMA PARA ESCOGER LA MATERIA EN listaMaterias
                            Asignatura.obtenerMateria(clave,listaMaterias ).setNo_grupos(numDeGrupo);
                            grupos.replace(clave, lista); //Se reemplaza la lista con menos datos con la nueva con mas datos
                        } else {
                            System.out.println("La materia ingresada no existe :(");
                        }
                    }else{
                        System.out.println("No hay profesores registrados, por favor registre profesores y intente de nuevo.");
                    }
                }break;

                case 5:{ // Inscribir alumnos
                    if(Alumno.numeroAlumnos == 0){
                        System.out.println("No existen alumnos registrados");
                        break;
                    }else{
                        System.out.println("Ingresa numero de cuenta:");
                        int numCuenta = sc.nextInt();
                        
                        if (alumnos_registrados.containsKey(numCuenta)){
                            // imprimir claves de asignaturas
                            System.out.println("Materias con claves registradas en el sistema:");
                            
                            for(Asignatura i : listaMaterias){
                                System.out.println("\tMateria : " + i.getNombre() + " Clave: " + i.getClave());
                            }
                            
                            System.out.println("Ingrese la clave de la Asignatura: ");
                            int claveAsig = sc.nextInt();

                            if (grupos.containsKey(claveAsig)){
                                ArrayList<Grupo> gruposmateria = grupos.get(claveAsig);
                                for (Grupo grupo : gruposmateria) {
                                    grupo.MostrarGrupo();
                                    System.out.println();
                                }
                                System.out.print("Grupo a inscribir: ");
                                int seleccion = sc.nextInt() - 1;
                                while (seleccion < 0 || seleccion >= gruposmateria.size()){
                                    System.out.print("El grupo ingresado no existe, favor de ingresar un numero de grupo correcto:\nGrupo: ");
                                    seleccion = sc.nextInt() - 1;
                                }
                                alumnos_registrados.get(numCuenta).AsignarGrupo(gruposmateria.get(seleccion));
                                grupos.get(claveAsig).get(seleccion).Addalumnos(String.valueOf(numCuenta));
                            }else{
                                System.out.println("Lo sentimos, no hay grupos para la materia ingresada :(");
                            }
                        } else{
                            System.out.println("El alumno no fue encontrado, intentalo de nuevo.");
                        }
                    }

                }break;

                case 6: {
                    System.out.println("\t1) Mostrar lista de alumnos regitrados\n\t2) Mostrar lista de asignaturas\n\t3) Mostrar lista de profesores\n\t4) Mostrar lista de grupos");
                    int subop = sc.nextInt();
                    switch (subop) {

                        case 1: {//Mostrar lista de alumnos registrados
                            if (!alumnos_registrados.isEmpty()){
                                for (int i : alumnos_registrados.keySet()) {
                                    System.out.println("\nNo.Cuenta: " + i);
                                    alumnos_registrados.get(i).mostrarAlumno();
                                    System.out.println();
                                }
                            }else{
                                System.out.println("No hay alumnos registrados");
                            }
                        }break;


                        case 2: {//Mostrar lista de asignaturas
                            if (!listaMaterias.isEmpty()){
                                for (Asignatura materia : listaMaterias) {
                                    materia.mostrarAsignatura();
                                }
                            }else{
                                System.out.println("No hay materias registradas");
                            }
                        }break;

                        case 3: {//Mostrar lista de profesores
                            if (!LisProfesores.isEmpty()){
                                int j = 1;
                                for (Profesor i : LisProfesores) {
                                    System.out.printf("Profesor %d:\n", j);
                                    i.MostrarProfesor();
                                    j++;
                                }
                            }else{
                                System.out.println("No hay profesores registrados");
                            }  
                        }break;

                        
                        case 4:{//Mostrar lista de grupos
                        	Enumeration<Integer> llaves = grupos.keys();
                        	while (llaves.hasMoreElements()) {
					            Integer key = llaves.nextElement();

					            System.out.println(key);

					            for(Grupo k : grupos.get(key)){
					            	k.MostrarGrupo();
					            }

					        }
                        }
                    }

                }break;

            }
        }while(opcion != 7);

        sc.close();
    } // Fin del Main


    static public String Horario(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        String horas = "";
        while (horas.isEmpty()){
            System.out.println("Por favor seleccione uno de los siguientes horarios:\n1) 7:00-9:00\n2) 9:00-11:00\n3) 11:00-13:00\n4) 13:00-15:00\n5) 15:00-17:00\n6) 17:00-19:00\n7) 19:00-21:00\n8) 21:00-23:00");
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
        return dias;
    }
}//Fin de la Clase

