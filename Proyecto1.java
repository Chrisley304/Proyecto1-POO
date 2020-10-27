import java.util.Scanner; 
import java.util.List;

public class Proyecto1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion,numAl=0,numAs=0,numProf=0,numGrupos=0;
        int n=0;
        
        List<Alumno> listaAlumnos = new List<Alumno>;
        List<Asignatura> listaMaterias = new List<Asignatura>;
        List<Profesor> listaProfesores = new List<Profesor>;
        List<Grupo> listaGrupos = new List<Grupo>;
        
        System.out.println("**********  Proyecto 1  **********");
        do{
            System.out.println("MENÚ PRINCIPAL: \n1.Registar Alumnos\n2.Registrar Asignatura\n3. Registrar profesor\n4. Abrir nuevo grupo\n5. Inscribir alumno\n6. Mostrar elementos\n7. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){
                
                case 1:{
                    String nombre,apellido,semestre,correo;
                    int edad,numCuenta;
                    numAl+=1;
                    System.out.println("Ingrese los datos del alumno: ");
                    System.out.println("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Apellido: ");
                    apellido = sc.nextLine();
                    System.out.println("Edad: ");
                    edad = sc.nextInt();
                    System.out.print("Numero de cuenta: ");
                    numCuenta = sc.nextInt();
                    System.out.print("Semestre: ");
                    semestre = sc.nextLine();
                    System.out.print("Correo electronico: ");
                    correo = sc.nextLine();
                    Alumno alumnos[numAl] = new Alumno(nombre, apellido, edad, numCuenta, semestre, correo);
                    listaAlumnos.add(alumnos[numAl]);
                }
                
                case 2:{
                    String nombre,division;
                    boolean laboratorio;
                    int clave,creditos;
                    numAs+=1;
                    System.out.println("Ingrese la información de la materia: ");
                    System.out.println("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Clave: ");
                    clave = sc.nextInt();
                    System.out.println("Creditos: ");
                    creditos= sc.nextInt();
                    System.out.print("Division: ");
                    division = sc.nextLine();
                    System.out.print("La materia tiene Laboratorio(L+)? (True/False)");
                    laboratorio = sc.nextBoolean();
                    Asignatura asignaturas[numAs] = new Asignatura(nombre, clave, creditos, division, laboratorio);
                    listaMaterias.add(asignaturas[numAs]);
                }
                
                case 3:{
                    String nombre,apellido,titulo;
                    int clave,creditos;
                    numProf+=1;
                    System.out.println("Ingrese la información del profesor: ");
                    System.out.println("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.println("Apellido: ");
                    apellido = sc.nextLine();
                    System.out.println("Titulo: ");
                    titulo = sc.nextLine();
                    Profesor profesores[numProf] = new Profesor(nombre, apellido, titulo);
                    listaProfesores.add(profesores[numProf]);
                }
                
                case 4:{
                    String horario, dias;
                    int salon, numDeGrupo, claveUnica;
                    numGrupos+=1;
                    System.out.println("Ingrese la información para abrir un grupo: ");
                    System.out.println("Numero de Grupo: ");
                    numDeGrupo = sc.nextInt();
                    System.out.println("Salon: ");
                    salon = sc.nextInt();
                    System.out.println("Horario: ");
                    horario = sc.nextLine();
                    System.out.println("Dias: ");
                    dias = sc.nextLine();
                    System.out.println("Clave unica: ");
                    claveUnica = sc.nextInt();
                    /*Mostrar lista de profesores
                      Asignar profesor
                    
                      Mostrar lista de Asignaturas
                      Asignar Asignatura
                     */      
                    Grupo grupos[numGrupos] = new Grupo(numDeGrupo,salon,horario,dias,clave unica);
                    listaGrupos.add(grupos[numGrupos]); //Tablas Hash?
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
}