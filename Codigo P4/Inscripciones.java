import java.util.Scanner;

public class Inscripciones{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        Alumno alumnos[] = new Alumno [5]; //Maximo 5
        Asignatura materias[] = new Asignatura[5];

        System.out.println("Bienvienido a las inscripciones 2020-1!\nPor favor elija una opcion:");
        do{
            System.out.println("1)Registar Alumno(Incluye domicilio)\n2)Registrar Asignatura(Incluye Profesor)\n3)Mostrar Alumnos\n4)Mostrar Asignaturas\n5)Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch(opcion){

                case 1:{ // Registrar alumnos 
                    int indice = Profesor.numProf;
                    if (indice == 4){// Maximo 5 Alumnos
                        System.out.println("Ya no hay espacio de alumnos :(");
                    }else {
                        System.out.print("Se procedera a registrar la informacion del alumno: \n");
                        System.out.print("Ingrese el nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ingrese el semestre: ");
                        String semestre = sc.nextLine();
                        System.out.print("Ingrese la edad: ");
                        int edad = sc.nextInt();
                        sc.nextLine();
                        System.out.print("Ingrese el numero de cuenta: ");
                        String numCuenta = sc.nextLine();
                        System.out.print("Ingrese el telefono: ");
                        String telefono = sc.nextLine();

                        alumnos[indice] = new Alumno(nombre, semestre, edad, numCuenta, telefono);

                        System.out.print("Se procedera a registrar la direccion del alumno: \n");
                        System.out.print("Ingrese la calle: ");
                        String calle = sc.nextLine();
                        System.out.println("Ingrese la delegacion: ");
                        String delegacion = sc.nextLine();
                        System.out.print("Ingrese la colonia: ");
                        String colonia = sc.nextLine();
                        System.out.print("Ingrese el Codigo Postal: ");
                        String CP = sc.nextLine();
                        System.out.print("Ingrese la ciudad: ");
                        String ciudad = sc.nextLine();

                        alumnos[indice].AsosiarDomicicilio(calle, delegacion, colonia, CP, ciudad);
                    }
                    
                }break;

                case 2:{ // Registrar asignatura
                    int indice = Profesor.numProf;
                    if ( indice == 4){
                        System.out.println("Ya no hay espacio de materias :(");
                    }else {
                        System.out.print("Se procedera a registrar la asignatura: \n");
                        System.out.print("Ingrese el nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Ingrese la clave: ");
                        int clave = sc.nextInt();
                        System.out.print("Ingrese la creditos: ");
                        int creditos = sc.nextInt();
                        sc.nextLine();
                        materias[indice] = new Asignatura(nombre,clave, creditos);

                        boolean barco;
                        System.out.print("Se procedera a registrar la informacion del profesor de la asignatura: \n");
                        System.out.print("Ingrese el nombre: ");
                        nombre = sc.nextLine();
                        System.out.print("Ingrese la calificacion del profesor: ");
                        float calificacion = sc.nextFloat();
                        sc.nextLine();
                        System.out.print("Es barco : ('si' o 'no'): ");
                        String siono= sc.nextLine();
                        if (siono.equals("si")){
                            barco = true;
                        }else{
                            barco = false;
                        }
                        materias[indice].AsociarProfesor(nombre, calificacion , barco);
                    }
                }break;


                case 3:{ // Mostrar Alumnos
                    if (Alumno.numAlu > 0){
                        System.out.printf("Hay %d alumnos registrados c/u con su profesor asignado\n", Alumno.numAlu);
                        for (int i =0; i<Alumno.numAlu;i++){
                            System.out.println("Alumno " + (i+1) + ":");
                            alumnos[i].MostrarAlumno();
                            System.out.println();
                        }
                    }else{
                        System.out.println("No hay alumnos registrados");
                    }
                }break;

                case 4:{ // Mostrar Asignaturas
                    if (Profesor.numProf > 0){
                        System.out.printf("Hay %d materias registradas c/u con su profesor asignado\n", Profesor.numProf);
                        for (int i =0; i<Profesor.numProf;i++){
                            System.out.println("Materia " + (i+1) + ":");
                            materias[i].MostrarAsignatura();
                            System.out.println();
                        }
                    }else{
                        System.out.println("No hay materias registradas");
                    }
                }break;

                case 5:{
                    System.out.println("Saliendo... hasta luego");
                }break;

                default:{
                    System.out.println("Por favor, elige una opcion correcta.");
                }break;

            }
        }while (opcion != 5);
        

        sc.close();
        
        
    }
    
}