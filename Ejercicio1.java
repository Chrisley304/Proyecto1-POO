
import java.util.Scanner; 
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        int n=0;

        Map<Integer, Object> alumnos_registrados = new HashMap<Integer, Object>();
        
        System.out.println("**********  Proyecto 1  **********");
        do{
            System.out.println("MENÚ PRINCIPAL: \n1.Registar Alumnos\n2.Registrar Asignatura\n3. Registrar profesor\n4. Abrir nuevo grupo\n5. Inscribir alumno\n6. Mostrar elementos\n7. Salir");
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
                    alumnos_registrados.put(numCuenta, new Alumno(nombre, apellido, edad, numCuenta, semestre, correo));
                }
                
                case 5:{
                    System.out.println("Ingresa el numero de cuenta del alumno");
                    int num = sc.nextInt();
                    Integer numCUENTA = num;
                    System.out.println(alumnos_registrados.get(numCUENTA));
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
