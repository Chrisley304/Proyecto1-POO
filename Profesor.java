
import java.util.HashSet;


public class Profesor{
	String nombre;
	String apellido;
	String titulo;
	static int numMaestros;
	static HashSet<Profesor> conjuntoProfesores = new HashSet<Profesor>();


	public Profesor(String nombre, String apellido){
		numMaestros ++;
		this.nombre = nombre;
		this.apellido = apellido;
	}


	public void setTitulo(String titulo){
		this.titulo = titulo;
	}

	public String getTitulo(){
		return this.titulo;
	}

	public String getNombre(){
		return this.nombre;
	}

	public String getApellido(){
		return this.apellido;
	}


	public static void registrarProfesores(Profesor profe){
		
	    conjuntoProfesores.add(profe);
	}

	public static void mostrarProfesores(){
		int j = 1;
		//HashSet<Profesor> conjuntoProfesores = new HashSet<Profesor>();
		for(Profesor i : conjuntoProfesores){

			System.out.println("Profesor " + j + ": " + i.getTitulo()+ " " + i.getNombre() + " " + i.getApellido());
			j++;
		}
	}


}