package Clases_Inscripcion;

public class Profesor{
	String nombre;
	String apellido;
	String titulo;
	static public int numMaestros;


	public Profesor(String nombre, String apellido,String titulo){
		numMaestros ++;
		this.nombre = nombre;
		this.apellido = apellido;
		this.titulo = titulo;
	}


	public void setTitulo(String titulo){
		this.titulo = titulo;
	}

	public String getNombre(){
		return this.nombre;
	}

	public String getApellido(){
		return this.apellido;
	}

	public void MostrarProfesor(){
		System.out.printf("\t\tNombre del Profesor: %s\n",this.nombre);
		System.out.printf("\t\tApellido del Profesor: %s\n",this.apellido);
		System.out.printf("\t\tTitulo: %s\n",this.titulo);
		System.out.println();
	}


}