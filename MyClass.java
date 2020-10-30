import java.util.HashMap;
import java.util.Scanner;
  	public class MyClass {
  		public static void main(String []args){

  			Scanner sc = new Scanner(System.in);
  			int opcion;

  /*
	    HashMap<Integer, String> asignaturas = new HashMap<Integer, String>();
	    asignaturas.put(1, "Fisica");
	    asignaturas.put(2, "EDA 2");
	    asignaturas.put(3, "Algebra");
	    asignaturas.put(4, "Calculo Integral");
	    System.out.println(asignaturas); */

/*
	    Asignatura a = new Asignatura("Fisica", 1, 23,14,"DCB",'T');
	    a.mostrarAsignatura();
	    boolean l = a.existeAsignatura(1);
	    System.out.println(l);*/

	    do{
	    System.out.println("Ingrese el nombre del profesor: ");
	    sc.nextLine();
	    String nombreProfe = sc.nextLine();
	    System.out.println("Ingrese el apellido del profesor: ");
	    String apellidoProfe = sc.nextLine();
	    System.out.println("Ingrese el grado académico del profesor (Lic, Ing, M. en C, Dr, etc.: ");
	    String gradoAcademico = sc.nextLine();

	    Profesor prof = new Profesor(nombreProfe,apellidoProfe);
	    prof.setTitulo(gradoAcademico);
	    Profesor.registrarProfesores(prof); //imprime a los profesores
	    Profesor.mostrarProfesores();

	    System.out.println("Profesores registrados: " + Profesor.numMaestros);

	    System.out.println("1.Desea registrar otro profesor\n2.Salir ");
	    opcion = sc.nextInt();


		}while(opcion != 2);






	  }
	}