package Clases_Inscripciones;

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

	public String getTitulo(){
		return this.titulo;
	}

	public String getNombre(){
		return this.nombre;
	}

	public String getApellido(){
		return this.apellido;
	}

/*	public static void mostrarProfesores(){
		int j = 1;
		//HashSet<Profesor> conjuntoProfesores = new HashSet<Profesor>();
		for(Profesor i : conjuntoProfesores){
			System.out.println("Profesor " + j + ": " + i.getTitulo()+ " " + i.getNombre() + " " + i.getApellido());
			j++;
		}
	}*/

	public void MostrarProfesor(){
		System.out.printf("Nombre del Profesor: %s\n",this.nombre);
		System.out.printf("Apellido del Profesor: %s\n",this.apellido);
		System.out.printf("Titulo: %s\n",this.titulo);
	}


}